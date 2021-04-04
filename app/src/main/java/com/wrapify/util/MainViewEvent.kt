package com.wrapify.util

sealed class MainViewEvent {
    object Authenticate: MainViewEvent()
    data class ShowError(val message: String): MainViewEvent()
}