package com.arthlimchiu.mymovies.movies.repository

import com.arthlimchiu.mymovies.movies.Movie
import io.reactivex.Single
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val api: TMDbApi,
    private val mapper: MovieDTOMapper
) : MoviesRepository {

    override fun getMovies(): Single<List<Movie>> {
        return api
            .getMovies()
            .map { response -> mapper.mapMovieDTOsToMovies(response.movies) }
    }
}