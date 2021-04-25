package com.example.newsapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.repo.NewsRepository
import java.lang.IllegalArgumentException


class ViewModelFactory (val newsRepository: NewsRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(newsRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}