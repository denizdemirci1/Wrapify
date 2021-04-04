package com.wrapify

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.spotify.sdk.android.authentication.AuthenticationClient
import com.spotify.sdk.android.authentication.AuthenticationRequest
import com.spotify.sdk.android.authentication.AuthenticationResponse
import com.wrapify.ui.listing.ListingViewModel
import com.wrapify.ui.theme.WrapifyTheme
import com.wrapify.util.WrapifyMain
import com.wrapify.util.constants.SpotifyConstants
import com.wrapify.util.constants.SpotifyConstants.SPOTIFY_REQUEST_CODE
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private val listingViewModel: ListingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        openSpotifyLoginActivity()
        setContent {
            val currentTheme = isSystemInDarkTheme()
            val toggleTheme: () -> Unit = {
                if (currentTheme) setDayTheme() else setDarkTheme()
            }
            WrapifyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    WrapifyMain(toggleTheme, viewModel, listingViewModel)
                }
            }
        }
    }

    private fun setDayTheme() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    private fun setDarkTheme() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
    }

    private fun openSpotifyLoginActivity() {
        val builder = AuthenticationRequest.Builder(
            BuildConfig.SPOTIFY_CLIENT_ID,
            AuthenticationResponse.Type.TOKEN,
            getString(R.string.spotify_uri_callback)
        )

        builder.setScopes(arrayOf(SpotifyConstants.SCOPES))

        AuthenticationClient.openLoginActivity(
            this,
            SPOTIFY_REQUEST_CODE,
            builder.build())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Check if result comes from the correct activity
        if (requestCode == SPOTIFY_REQUEST_CODE) {
            val response = AuthenticationClient.getResponse(resultCode, data)

            when (response.type) {
                // Response was successful and contains auth token
                AuthenticationResponse.Type.TOKEN -> {
                    viewModel.saveToken(response.accessToken)
                }

                // Auth flow returned an error
                AuthenticationResponse.Type.ERROR -> {
                    viewModel.clearToken()
                    viewModel.handleAuthError(response.error)
                }

                else -> Log.i("MainActivity", "Something went wrong")
            }
        }
    }
}
