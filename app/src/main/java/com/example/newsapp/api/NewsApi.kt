package com.example.newsapp.api

import com.example.newsapp.models.ApiResponse
import com.example.newsapp.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("v2/everything")
    suspend fun getNews(
        @Query("apiKey")
        apiKey: String = Constants.API_KEY
    ):Response<ApiResponse>
}