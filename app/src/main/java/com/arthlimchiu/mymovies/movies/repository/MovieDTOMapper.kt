package com.arthlimchiu.mymovies.movies.repository

import com.arthlimchiu.mymovies.movies.Movie
import javax.inject.Inject

class MovieDTOMapper @Inject constructor() {

    fun mapMovieDTOsToMovies(movies: List<MovieDTO>): List<Movie> {
        return movies.map { mapMovieDTOtoMovie(it) }
    }

    fun mapMovieDTOtoMovie(movie: MovieDTO): Movie {
        return Movie(
            movie.title,
            movie.image,
            movie.rating
        )
    }
}