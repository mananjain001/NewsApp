package com.example.newsapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.models.ApiResponse
import com.example.newsapp.repo.NewsRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(val newsRepository : NewsRepository): ViewModel() {

    val newsData : MutableLiveData<ApiResponse> = MutableLiveData<ApiResponse>()

    init {
        getNews()
    }

    fun getNews() {

        viewModelScope.launch {
        val response = newsRepository.getNews()
        if (response.isSuccessful)
            newsData.postValue(response.body())
    }
//        viewModelScope.launch {
//            val response = async { newsRepository.getNews() }
//            val body = response.await().body()
//            newsData.postValue(body)
//        }
//
    }


}