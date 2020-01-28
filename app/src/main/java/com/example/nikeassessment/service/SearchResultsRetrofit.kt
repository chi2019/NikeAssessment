package com.example.nikeassessment.service

class SearchResultsRetrofit {

    fun getSearchs() : SearchService = RetrofitBuilderFactory.getProvider(
        baseUrl = "https://mashape-community-urban-dictionary.p.rapidapi.com",
        serviceClass = SearchService::class.java
    )
}