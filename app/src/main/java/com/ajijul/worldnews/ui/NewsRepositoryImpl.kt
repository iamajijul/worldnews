package com.ajijul.worldnews.ui

import com.ajijul.worldnews.base.BaseRepository
import com.ajijul.worldnews.db.ArticleDao
import com.ajijul.worldnews.models.NewsResponse
import com.ajijul.worldnews.network.NewsApi
import com.ajijul.worldnews.network.ResponseWrapper
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(var api: NewsApi, var dao: ArticleDao) :
    BaseRepository(), NewsRepository {
    override suspend fun getBreakingNews(
        countryCode: String,
        pageNumber: Int
    ): ResponseWrapper<NewsResponse?> {

        return safeApiCall { api.getLatestNews(countryCode, pageNumber).body() }
    }


}