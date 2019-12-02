package android.example.myapplication.features.movieslist.views

import android.example.myapplication.common.FragmentNavigator
import android.example.network.models.MovieModel
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

class MoviesListAdapter(private val fragmentNavigator: FragmentNavigator) : ListAdapter<MovieModel, MovieItemView.ViewHolder>(MoviesListDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemView.ViewHolder {
        val movieItem = MovieItemView(parent, fragmentNavigator)
        return MovieItemView.ViewHolder(movieItem)
    }

    override fun onBindViewHolder(holder: MovieItemView.ViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
    }
}

