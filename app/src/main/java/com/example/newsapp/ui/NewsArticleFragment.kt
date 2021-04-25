package com.example.newsapp.ui

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.newsapp.R
import kotlinx.android.synthetic.main.fragment_news_article.*

class NewsArticleFragment :Fragment(R.layout.fragment_news_article) {


    lateinit var viewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments
        val url = args?.getString("Url")
        webView.apply {
            webViewClient = WebViewClient()
            loadUrl(url.toString())
        }

        viewModel = (activity as MainActivity).viewModel
    }
}