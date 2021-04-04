package com.wrapify.ui.listing

import com.wrapify.model.wrapify.TopItem

sealed class ListingViewEvent {

    object OnInitialState: ListingViewEvent()

    data class OnTopArtistsFetched(val list: List<TopItem>): ListingViewEvent()

    data class OnTopTracksFetched(val list: List<TopItem>): ListingViewEvent()

    data class OnError(val message: String): ListingViewEvent()
}
