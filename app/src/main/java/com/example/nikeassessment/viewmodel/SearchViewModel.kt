package com.example.nikeassessment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nikeassessment.model.ListItem
import com.example.nikeassessment.repository.SearchRepository
import kotlinx.coroutines.launch

class SearchViewModel(private val searchRepository: SearchRepository = SearchRepository.getSearchRepository()) :
    ViewModel() {

     private var _searchResults = MutableLiveData<List<ListItem>>()
     val searchResults:LiveData<List<ListItem>> = _searchResults

     fun getSearchResults(searchQuery :String){
        viewModelScope.launch {
            val res = searchRepository.getServiceResponse(searchQuery)
            _searchResults.value = res
        }
     }

    fun sortByThumbsUp(){
        _searchResults.value = _searchResults.value?.sortedByDescending { it.thumbsUp }
    }

    fun sortByThumbsDown(){
            _searchResults.value =  _searchResults.value?.sortedByDescending { it.thumbsDown }
    }
}