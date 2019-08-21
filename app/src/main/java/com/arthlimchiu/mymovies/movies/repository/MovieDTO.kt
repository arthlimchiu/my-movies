package com.arthlimchiu.mymovies.movies.repository

import com.google.gson.annotations.SerializedName

data class MovieDTO(
    @SerializedName("title") val title: String,
    @SerializedName("poster_path") val image: String,
    @SerializedName("vote_average") val rating: Float
)