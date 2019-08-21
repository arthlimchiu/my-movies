package com.arthlimchiu.mymovies.movies.repository

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface TMDbApi {

    @GET("movie/popular")
    fun getMovies(
        @Query("api_key") apiKey: String = "<YOUR_API_KEY_HERE>",
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): Single<MoviesResponse>
}