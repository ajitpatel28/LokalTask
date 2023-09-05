package com.ajit.lokaltask.ui.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.ajit.lokaltask.data.model.Product
import com.ajit.lokaltask.ui.navigation.Destinations
import com.ajit.lokaltask.ui.viewmodel.ProductViewModel

@Composable
fun ProductListItem(
    product: Product,
    viewModel: ProductViewModel,
    navController: NavHostController
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                // Set the selected product in the ViewModel
                viewModel.setSelectedProduct(product)
                // Navigate to the details screen
                navController.navigate(Destinations.ProductDetailsScreen.route)
            },
        elevation = 8.dp,
        shape = RoundedCornerShape(12.dp),
        backgroundColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            // Product Category
            Text(
                text = "Category: ${product.category}",
                fontSize = 14.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(8.dp))

            // Product Title
            Text(
                text = product.title,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(4.dp))

            // Product Price
            Text(
                text = "Price: $${product.price}",
                fontSize = 16.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}
