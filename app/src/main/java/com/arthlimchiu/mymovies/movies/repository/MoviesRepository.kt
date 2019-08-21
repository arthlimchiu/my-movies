package com.arthlimchiu.mymovies.movies.repository

import com.arthlimchiu.mymovies.movies.Movie
import io.reactivex.Single


interface MoviesRepository {

    fun getMovies(): Single<List<Movie>>
}