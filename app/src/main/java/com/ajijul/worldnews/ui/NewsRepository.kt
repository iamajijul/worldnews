package com.ajijul.worldnews.ui

import com.ajijul.worldnews.models.NewsResponse
import com.ajijul.worldnews.network.ResponseWrapper

interface NewsRepository {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) : ResponseWrapper<NewsResponse?>
}