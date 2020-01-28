package com.example.nikeassessment.ui.adapter

import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.nikeassessment.R
import com.example.nikeassessment.model.ListItem

class SearchResultsAdapter(var searchResults: List<ListItem>) :
    RecyclerView.Adapter<SearchResultItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultItemViewHolder {
        return SearchResultItemViewHolder(R.layout.search_result_item, parent)
    }

    override fun getItemCount(): Int = searchResults.size

    override fun onBindViewHolder(holder: SearchResultItemViewHolder, position: Int) {
       holder.bind(searchResults[position])
    }

    fun updateSearchList(searchResults: List<ListItem>){
        this.searchResults = searchResults
        notifyDataSetChanged()
    }

}