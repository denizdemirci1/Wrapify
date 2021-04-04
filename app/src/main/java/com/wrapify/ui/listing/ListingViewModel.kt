package com.wrapify.ui.listing

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wrapify.data.remote.util.parseNetworkError
import com.wrapify.data.repositories.PersonalizationRepository
import com.wrapify.model.util.Result
import com.wrapify.util.extensions.data.toTopItemList
import kotlinx.coroutines.launch

private const val MEDIUM_TERM = "medium_term"
private const val OFFSET = 0

class ListingViewModel @ViewModelInject constructor(
    private val repository: PersonalizationRepository
) : ViewModel() {

    private val _event: MutableState<ListingViewEvent> =
        mutableStateOf(ListingViewEvent.OnInitialState)
    val event: State<ListingViewEvent> = _event

    private fun sendEvent(event: ListingViewEvent) {
        _event.value = event
    }

    fun getTopArtists() {
        viewModelScope.launch {
            repository.fetchTopArtists(MEDIUM_TERM, OFFSET).let { result ->
                when (result) {
                    is Result.Success -> {
                        sendEvent(
                            ListingViewEvent.OnTopArtistsFetched(result.data.items.toTopItemList())
                        )
                    }
                    is Result.Error-> {
                        val message = parseNetworkError(result.exception)
                        message?.let { sendEvent(ListingViewEvent.OnError(message)) }
                    }
                }
            }
        }
    }

    fun getTopTracks() {
        viewModelScope.launch {
            repository.fetchTopTracks(MEDIUM_TERM, OFFSET).let { result ->
                when (result) {
                    is Result.Success -> {
                        sendEvent(
                            ListingViewEvent.OnTopTracksFetched(result.data.items.toTopItemList())
                        )
                    }
                    is Result.Error-> {
                        val message = parseNetworkError(result.exception)
                        message?.let { sendEvent(ListingViewEvent.OnError(message)) }
                    }
                }
            }
        }
    }
}
