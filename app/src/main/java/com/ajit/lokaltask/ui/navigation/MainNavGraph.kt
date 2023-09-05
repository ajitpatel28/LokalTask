package com.ajit.lokaltask.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ajit.lokaltask.ui.screens.ProductDetailsScreen
import com.ajit.lokaltask.ui.screens.ProductListScreen
import com.ajit.lokaltask.ui.viewmodel.ProductViewModel

@Composable
fun MainNavGraph(
    navController: NavHostController,
    viewModel: ProductViewModel
) {
    NavHost(navController, startDestination = Destinations.ProductListScreen.route) {
        composable(Destinations.ProductListScreen.route) {
            ProductListScreen(
                viewModel = viewModel,
                navController = navController
            )
        }
        composable(Destinations.ProductDetailsScreen.route) {
            val selectedProduct = viewModel.selectedProduct.value
            selectedProduct?.let { product ->
                ProductDetailsScreen(product, navController)
            } ?: run {
                navController.navigateUp()
            }
        }
    }
}
