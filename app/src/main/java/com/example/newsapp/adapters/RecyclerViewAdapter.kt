package com.example.newsapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.models.Article
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.RecycleViewHolder>() {

    inner class RecycleViewHolder (item: View):RecyclerView.ViewHolder(item)

    private val differCallback = object  : DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.content == newItem.content
        }
    }

    val differ = AsyncListDiffer(this,differCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        return RecycleViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.recyclerview_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        val newsItem = differ.currentList[position]

        holder.itemView.apply {
            recyclerview_item_heading.text = newsItem.title
            recyclerview_item_publishedAt.text = newsItem.description
            Glide.with(this).load(newsItem.urlToImage).into(recyclerview_item_imageView)
            setOnClickListener{ onItemClicked(newsItem)}
        }
    }

    private fun onItemClicked(newsItem: Article?) {
        
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}