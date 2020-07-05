package com.ajijul.worldnews.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajijul.worldnews.models.NewsResponse
import com.ajijul.worldnews.network.ResponseWrapper
import kotlinx.coroutines.launch

class NewsViewModel @ViewModelInject constructor(val mainRepository: NewsRepository) :
    ViewModel() {

    private var breakingNews = MutableLiveData<ResponseWrapper<NewsResponse?>>()
    private var breakingNewsPageNumber = 1

    fun observeBreakingNews() : LiveData<ResponseWrapper<NewsResponse?>> = breakingNews

    fun getBreakingNews(countryCode: String) = viewModelScope.launch {
        breakingNews.postValue(ResponseWrapper.Loading())
        val response =
            mainRepository.getBreakingNews(countryCode, breakingNewsPageNumber)
        breakingNews.postValue(response)
    }
}