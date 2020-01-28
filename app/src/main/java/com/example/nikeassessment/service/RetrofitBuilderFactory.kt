package com.example.nikeassessment.service

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilderFactory {

    fun <T> getProvider(
        client: okhttp3.OkHttpClient = Client.instance,
        serviceClass: Class<T>,
        baseUrl:String
    ):T{
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(client)
            .build()

        return retrofit.create(serviceClass)
    }

}