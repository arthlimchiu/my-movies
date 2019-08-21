package com.arthlimchiu.mymovies.movies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arthlimchiu.mymovies.R
import com.arthlimchiu.mymovies.component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: MoviesViewModelFactory

    private lateinit var viewModel: MoviesViewModel

    private lateinit var toolbar: Toolbar
    private lateinit var movies: RecyclerView
    private lateinit var moviesAdapter: MoviesAdapter

    private val disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component.inject(this)

        viewModel = ViewModelProviders.of(this, factory).get(MoviesViewModel::class.java)

        toolbar = findViewById(R.id.toolbar)
        movies = findViewById(R.id.movies)

        initToolbar()

        movies.layoutManager = LinearLayoutManager(this)
        moviesAdapter = MoviesAdapter()
        movies.adapter = moviesAdapter

        viewModel.movies.observe(this, Observer { movies ->
            moviesAdapter.updateMovies(movies)
        })

        viewModel.getMovies()
    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
        title = getString(R.string.app_name)
    }

    override fun onStop() {
        super.onStop()
        disposables.clear()
    }
}