package com.ajijul.worldnews.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ajijul.worldnews.R
import com.ajijul.worldnews.adapters.viewholders.NewsViewHolders
import com.ajijul.worldnews.models.Article

class NewsAdapter : RecyclerView.Adapter<NewsViewHolders>() {


    private val differCallBack = object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {

            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {

            return oldItem == newItem
        }

    }

    private var differList = AsyncListDiffer(this, differCallBack)
    private var onItemClickListener: ((Article) -> Unit)? = null

    fun setOnClickListener(listener: ((Article) -> Unit)?) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolders {

        return NewsViewHolders(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_article_preview, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return differList.currentList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolders, position: Int) {
        val article = differList.currentList[position]
        holder.setData(article)
        holder.itemView.setOnClickListener {
            onItemClickListener?.let {
                it(article)
            }
        }
    }


}