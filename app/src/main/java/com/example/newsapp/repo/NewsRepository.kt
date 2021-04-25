package com.example.newsapp.repo

import com.example.newsapp.api.RetrofitInstance

class NewsRepository {

    suspend fun getNews()=
        RetrofitInstance.api.getNews()
}