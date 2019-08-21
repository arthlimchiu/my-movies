package com.arthlimchiu.mymovies.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arthlimchiu.mymovies.R
import com.bumptech.glide.Glide

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    private var movies: List<Movie> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    fun updateMovies(movies: List<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val image: ImageView = itemView.findViewById(R.id.movie_image)
        private val title: TextView = itemView.findViewById(R.id.movie_title)
        private val rating: TextView = itemView.findViewById(R.id.movie_rating)

        fun bind(movie: Movie) {
            Glide.with(itemView)
                .load("https://image.tmdb.org/t/p/w500${movie.image}")
                .into(image)

            title.text = movie.title
            rating.text = itemView.context.getString(R.string.rating, movie.rating)
        }
    }
}