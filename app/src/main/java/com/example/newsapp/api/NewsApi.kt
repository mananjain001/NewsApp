package com.example.newsapp.api

import com.example.newsapp.models.ApiResponse
import com.example.newsapp.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("v2/top-headlines")
    suspend fun getNews(
        @Query("apiKey")
        apiKey: String = Constants.API_KEY,
        @Query("page")
        pageNumber: Int = 1,
        @Query("country")
        country :String = "in"
    ):Response<ApiResponse>
}