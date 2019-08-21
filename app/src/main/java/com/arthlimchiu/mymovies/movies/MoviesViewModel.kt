package com.arthlimchiu.mymovies.movies

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arthlimchiu.mymovies.movies.repository.MoviesRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MoviesViewModel @Inject constructor(private val repository: MoviesRepository) : ViewModel() {

    private val disposables = CompositeDisposable()

    private val _movies = MutableLiveData<List<Movie>>()

    val movies: LiveData<List<Movie>>
        get() = _movies

    fun getMovies() {
        disposables.add(
            repository
                .getMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { movies -> _movies.value = movies },
                    { throwable -> Log.e("MainActivity", "onError: ", throwable) }
                )
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}