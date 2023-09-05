package com.ajit.lokaltask.data.remote

import com.ajit.lokaltask.data.model.ApiResponse
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts(): ApiResponse
}
