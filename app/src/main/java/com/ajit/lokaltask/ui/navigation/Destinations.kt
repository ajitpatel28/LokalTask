package com.ajit.lokaltask.ui.navigation


sealed class Destinations(val route: String) {
    object ProductListScreen : Destinations("productList")
    object ProductDetailsScreen : Destinations("productDetails")
}
