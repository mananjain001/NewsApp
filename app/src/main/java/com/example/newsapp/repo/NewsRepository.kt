package com.example.newsapp.repo

import com.example.newsapp.api.RetrofitInstance
import javax.inject.Inject

class NewsRepository @Inject constructor() {

    suspend fun getNews()=
        RetrofitInstance.api.getNews()
}