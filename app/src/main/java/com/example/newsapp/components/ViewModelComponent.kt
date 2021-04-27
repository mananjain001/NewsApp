package com.example.newsapp.components

import com.example.newsapp.ui.MainActivity
import dagger.Component

@Component
interface ViewModelComponent {

    fun inject(mainActivity: MainActivity)
}