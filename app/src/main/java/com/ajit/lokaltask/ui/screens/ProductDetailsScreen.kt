package com.ajit.lokaltask.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.ajit.lokaltask.data.model.Product
import com.ajit.lokaltask.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ProductDetailsScreen(
    product: Product,
    navController: NavHostController
) {

    // Remember the pager state to control the image gallery
    val pagerState = rememberPagerState(pageCount = product.images.size)


    // Main Column composable for the product details screen
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Back button at the top-left corner
        IconButton(
            onClick = {
                navController.navigateUp()
            },
            modifier = Modifier.align(Alignment.Start)
        ) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
        }

        // Horizontal image gallery
        if (product.images.isNotEmpty()) {
            Text(
                text = "Product Images",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            ) { page ->
                Image(
                    painter = rememberImagePainter(
                        data = product.images[page],
                        builder = {
                            placeholder(R.drawable.placeholder_img) // Placeholder while loading
                            error(R.drawable.placeholder_img) // Placeholder in case of an error
                            crossfade(true)
                        }
                    ),
                    contentDescription = "product_image",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(400.dp, 400.dp)
                        .padding(4.dp)
                        .clip(
                            shape = RoundedCornerShape(8.dp)
                        )
                )

            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Product brand
        Text(text = "Brand: ${product.brand}", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))


        // Product category
        Text(text = "Category: ${product.category}")
        Spacer(modifier = Modifier.height(16.dp))

        // Product title
        Text(text = "Title: ${product.title}", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))

        // Description
        Text(text = "Description: ${product.description}")
        Spacer(modifier = Modifier.height(16.dp))

        // Discount percentage and price
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = "Discount Percentage: ${product.discountPercentage}%")
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Price: $${product.price}")
        }
        Spacer(modifier = Modifier.height(16.dp))


        // Product stock
        Text(text = "Stock: ${product.stock}")

    }
}

