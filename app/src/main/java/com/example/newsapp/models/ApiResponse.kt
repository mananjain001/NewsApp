package com.example.newsapp.models

data class ApiResponse(
        val articles: List<Article>,
        val status: String,
        val totalResults: Int
)