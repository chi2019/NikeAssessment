package com.example.nikeassessment.repository

import com.example.nikeassessment.model.ListItem
import com.example.nikeassessment.service.SearchResultsRetrofit
import com.example.nikeassessment.service.SearchService
import java.lang.Exception

class SearchRepositoryImpl(private val searchService: SearchService = SearchResultsRetrofit().getSearchs()) : SearchRepository {

    override suspend fun getServiceResponse(searchQuery : String):List<ListItem>?{
        try {
            val searchResults = searchService.getSearchResults(searchQuery)
            return when (searchResults.isSuccessful && searchResults.code() == 200) {
                true -> searchResults.body()?.list?.let { it }
                else -> null
            }
        }catch (e:Exception){
            return null
        }
    }

}