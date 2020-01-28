package com.example.nikeassessment.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.example.nikeassessment.R
import com.example.nikeassessment.model.ListItem
import kotlinx.android.synthetic.main.search_result_item.view.*

class SearchResultItemViewHolder(@LayoutRes layoutId: Int, parent: ViewGroup) :
    RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(layoutId, parent, false)){

    lateinit var author:TextView
    lateinit var likeCount:TextView
    lateinit var disLikeCount:TextView



    init {
        setUpView(itemView)
    }

    fun setUpView(view: View){
        author =  view.findViewById(R.id.author)
        likeCount = view.findViewById(R.id.likeCount)
        disLikeCount = view.findViewById(R.id.disLikeCount)
    }

    fun bind(searchResultItem :ListItem){
        author.text = searchResultItem.author
        likeCount.text = searchResultItem.thumbsUp?.toString()
        disLikeCount.text = searchResultItem.thumbsDown?.toString()
    }

}