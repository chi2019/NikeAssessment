package com.example.nikeassessment.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object Client {
    private var logging = false
    private val instanceDelegate = lazy {
        OkHttpClient.Builder().apply {
            if(logging){
                addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
            }
        }.build()
    }

    val instance by instanceDelegate

}