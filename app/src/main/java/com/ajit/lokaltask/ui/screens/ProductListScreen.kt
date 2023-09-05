package com.ajit.lokaltask.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ajit.lokaltask.ui.components.ProductListItem
import com.ajit.lokaltask.ui.viewmodel.ProductViewModel
import com.ajit.lokaltask.utils.UiState

@Composable
fun ProductListScreen(
    viewModel: ProductViewModel,
    navController: NavHostController
) {

    when (val productListState = viewModel.productListState.value) {
        is UiState.Success -> {
            val productList = productListState.data ?: emptyList()

            LazyColumn (
                contentPadding = PaddingValues(8.dp),
                modifier = Modifier.fillMaxSize()
            ){
                itemsIndexed(productList) { _, product ->
                    ProductListItem(product,viewModel,navController)
                }
            }
        }
        is UiState.Loading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            ) {
                CircularProgressIndicator()
            }
        }
        is UiState.Error -> {
            // Show error message
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "Error: ${productListState.message}",
                    color = Color.Red,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}
