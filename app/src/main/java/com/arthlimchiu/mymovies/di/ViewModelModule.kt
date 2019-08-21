package com.arthlimchiu.mymovies.di

import com.arthlimchiu.mymovies.movies.repository.MoviesRepository
import com.arthlimchiu.mymovies.movies.MoviesViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun providesMoviesViewModelFactory(moviesRepository: MoviesRepository): MoviesViewModelFactory {
        return MoviesViewModelFactory(moviesRepository)
    }
}