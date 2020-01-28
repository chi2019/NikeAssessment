package com.example.nikeassessment.repository

import com.example.nikeassessment.model.ListItem

interface SearchRepository {

    /**
     * This method return the list of search results,
     * there a might be possibility of occurence of exception, in that case return null
     */
    suspend fun getServiceResponse(searchQuery : String):List<ListItem>?

    companion object{
        fun getSearchRepository():SearchRepositoryImpl{
            return SearchRepositoryImpl()
        }
    }
}