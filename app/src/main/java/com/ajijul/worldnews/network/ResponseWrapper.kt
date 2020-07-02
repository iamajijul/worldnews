package com.ajijul.worldnews.network

sealed class ResponseWrapper<T>(
    val data: T? = null,
    val message: String? = null

) {


    class Success<T>(data: T) : ResponseWrapper<T>(data)
    class Error<T>(message: String?, data: T?) : ResponseWrapper<T>(data, message)
    class Loading<T> : ResponseWrapper<T>()

}