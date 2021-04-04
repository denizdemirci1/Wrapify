package com.wrapify

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wrapify.util.MainViewEvent
import com.wrapify.util.UserManager

class MainViewModel @ViewModelInject constructor(
    private val userManager: UserManager
) : ViewModel() {

    private val _event = MutableLiveData<MainViewEvent>()
    val event: LiveData<MainViewEvent> = _event

    private val _isAuthenticated = mutableStateOf(false)
    val isAuthenticated: State<Boolean> = _isAuthenticated

    private fun sendEvent(event: MainViewEvent) {
        _event.value = event
    }

    fun saveToken(accessToken: String) {
        userManager.token = accessToken
        _isAuthenticated.value = true
    }

    fun clearToken() {
        userManager.token = null
        _isAuthenticated.value = false
    }

    /***
     * If the auto authentication failed, try to refresh token
     * by authenticating again before showing error message.
     * If it fails again, then show the error.
     */
    fun handleAuthError(message: String?) {
        if (userManager.tokenRefreshed) {
            sendEvent(MainViewEvent.ShowError(message.orEmpty()))
            userManager.tokenRefreshed = false
        } else {
            userManager.tokenRefreshed = false
            sendEvent(MainViewEvent.Authenticate)
        }
    }

}
