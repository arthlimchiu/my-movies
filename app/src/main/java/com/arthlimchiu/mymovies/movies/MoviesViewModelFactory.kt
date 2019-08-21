package com.arthlimchiu.mymovies.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arthlimchiu.mymovies.movies.repository.MoviesRepository
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class MoviesViewModelFactory @Inject constructor(private val repository: MoviesRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MoviesViewModel::class.java)) {
            return MoviesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}