package com.example.newsapp

data class ApiResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)