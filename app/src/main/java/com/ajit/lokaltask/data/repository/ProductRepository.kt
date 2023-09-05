package com.ajit.lokaltask.data.repository

import com.ajit.lokaltask.data.model.Product
import com.ajit.lokaltask.data.remote.ApiService

class ProductRepository(private val apiService: ApiService) {

    // Get Products
    suspend fun getProducts(): List<Product> {
        val response = apiService.getProducts()
        return response.products
    }
}
