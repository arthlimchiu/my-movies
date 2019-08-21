package com.arthlimchiu.mymovies.di

import com.arthlimchiu.mymovies.movies.repository.MovieDTOMapper
import com.arthlimchiu.mymovies.movies.repository.MoviesRepository
import com.arthlimchiu.mymovies.movies.repository.MoviesRepositoryImpl
import com.arthlimchiu.mymovies.movies.repository.TMDbApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesMoviesRepository(api: TMDbApi, mapper: MovieDTOMapper): MoviesRepository {
        return MoviesRepositoryImpl(api, mapper)
    }
}