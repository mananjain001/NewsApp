package com.example.newsapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.adapters.RecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_news_page.*

class NewsFragment :Fragment(R.layout.fragment_news_page) {

    lateinit var viewModel: MainViewModel
    lateinit var recyclerViewAdapter: RecyclerViewAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as MainActivity).viewModel

        initialiseRecyclerView()

        viewModel.newsData.observe(viewLifecycleOwner, Observer {
                recyclerViewAdapter.differ.submitList(it.articles)
        })
    }

    private fun initialiseRecyclerView()
    {
        recyclerViewAdapter = RecyclerViewAdapter()
        newsRecyclerView.apply {
            adapter = recyclerViewAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}