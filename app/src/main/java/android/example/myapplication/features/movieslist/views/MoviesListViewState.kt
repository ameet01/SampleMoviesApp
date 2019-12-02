package android.example.myapplication.features.movieslist.views

import android.example.network.models.MovieModel


data class MoviesListViewState(
    val movies: List<MovieModel> = emptyList(),
    val isError: Boolean = false,
    val isLoading: Boolean = false
)
