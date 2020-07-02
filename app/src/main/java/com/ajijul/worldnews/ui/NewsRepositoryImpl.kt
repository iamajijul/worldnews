package com.ajijul.worldnews.ui

import com.ajijul.worldnews.db.ArticleDao
import com.ajijul.worldnews.network.NewsApi
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(api: NewsApi, dao: ArticleDao) : NewsRepository {




}