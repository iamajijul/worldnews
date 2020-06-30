package com.ajijul.worldnews.network

import com.ajijul.worldnews.helper.Constant.API_KEY
import com.ajijul.worldnews.models.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("v2/top-headlines")
    suspend fun getLatestNews(
        @Query("country") countryCode : String = "us",
        @Query("page") pageNumber : Int = 1,
        @Query("apiKey") apiKey : String = API_KEY
    ) : Response<NewsResponse>

    @GET("v2/everything")
    suspend fun searchNews(
        @Query("q") query : String = "us",
        @Query("page") pageNumber : Int = 1,
        @Query("apiKey") apiKey : String = API_KEY
    ) : Response<NewsResponse>
}