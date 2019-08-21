package com.arthlimchiu.mymovies.movies.repository

import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    @SerializedName("results") val movies: List<MovieDTO>
)