package com.example.nikeassessment.service

import com.example.nikeassessment.model.SearchResponse
import retrofit2.Response
import retrofit2.http.*

interface SearchService {

    @GET("/define")
    @Headers("X-RapidAPI-Key: b22d01e4cbmsha5b982080085549p1b3594jsndab6917cff90")
    suspend fun getSearchResults(@Query("term") searchQuery:String): Response<SearchResponse>

}