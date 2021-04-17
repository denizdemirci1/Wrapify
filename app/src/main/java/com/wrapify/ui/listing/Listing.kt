package com.wrapify.ui.listing

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import com.wrapify.model.wrapify.TopItem
import com.wrapify.ui.component.CircularLoading
import com.wrapify.ui.component.WrapifyItem

@Composable
fun Listing(
    type: String
) {
    val listingViewModel = hiltNavGraphViewModel<ListingViewModel>()
    when (type) {
        "Tracks" -> listingViewModel.getTopTracks()
        "Artists" -> listingViewModel.getTopArtists()
    }

    when (val event = listingViewModel.event.value) {
        ListingViewEvent.OnInitialState -> CircularLoading()
        is ListingViewEvent.OnTopArtistsFetched -> TopItems(list = event.list)
        is ListingViewEvent.OnTopTracksFetched -> TopItems(list = event.list)
        is ListingViewEvent.OnError -> Unit
    }
}

@Composable
fun TopItems(
    list: List<TopItem>
) {
    LazyColumn {
        itemsIndexed(list) { index, item ->
            WrapifyItem(
                item,
                index
            )
        }
    }
}
