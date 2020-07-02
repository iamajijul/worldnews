package com.ajijul.worldnews.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
) {
    @PrimaryKey(autoGenerate = true) // Primary key generating inside class because
    var id: Int? = null
}