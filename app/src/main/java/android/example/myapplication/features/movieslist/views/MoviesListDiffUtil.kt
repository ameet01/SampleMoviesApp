package android.example.myapplication.features.movieslist.views

import android.example.network.models.MovieModel
import androidx.recyclerview.widget.DiffUtil

class MoviesListDiffUtil : DiffUtil.ItemCallback<MovieModel>() {
    override fun areItemsTheSame(oldItem: MovieModel, newItem: MovieModel) = oldItem.imdbID == newItem.imdbID

    override fun areContentsTheSame(oldItem: MovieModel, newItem: MovieModel) = oldItem == newItem
}
