package com.ajit.lokaltask.data.model

data class ApiResponse(
    val products: List<Product>,
    val total: Int,
    val skip: Int,
    val limit: Int
)

