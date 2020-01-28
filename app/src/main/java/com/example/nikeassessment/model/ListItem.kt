package com.example.nikeassessment.model

import com.google.gson.annotations.SerializedName


data class ListItem(

	val defid: Int?,

	@SerializedName("sound_urls")
	val soundUrls: List<String?>?,

	@SerializedName("thumbs_down")
	val thumbsDown: Int?,

	val author: String?,

	@SerializedName("written_on")
	val writtenOn: String?,

	val definition: String?,

	val permalink: String?,

	@SerializedName("thumbs_up")
	val thumbsUp: Int?,

	val word: String?,

	@SerializedName("current_vote")
	val currentVote: String?,

	val example: String?
)