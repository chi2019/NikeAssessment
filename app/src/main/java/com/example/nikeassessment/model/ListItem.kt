package com.example.nikeassessment.model

import com.google.gson.annotations.SerializedName


data class ListItem(

	@SerializedName("thumbs_down")
	val thumbsDown: Int?,

	val author: String?,

	@SerializedName("thumbs_up")
	val thumbsUp: Int?
)