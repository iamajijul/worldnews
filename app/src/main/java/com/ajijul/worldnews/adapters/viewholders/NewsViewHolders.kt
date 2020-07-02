package com.ajijul.worldnews.adapters.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ajijul.worldnews.models.Article
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_article_preview.view.*

class NewsViewHolders(itemView : View) : RecyclerView.ViewHolder(itemView) {

    fun setData(article: Article){
        itemView.apply {
            Glide.with(this).load(article.urlToImage).into(ivArticleImage)
            tvSource.text  =article.source.name
            tvTitle.text = article.title
            tvDescription.text = article.description
            tvPublishedAt.text = article.publishedAt
        }
    }
}