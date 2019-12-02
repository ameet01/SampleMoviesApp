package android.example.myapplication.features.moviedetail.views

import android.example.network.models.MovieDetailModel

data class MovieDetailViewState(
    val movieDetailResponse: MovieDetailModel = MovieDetailModel(),
    val isLoading: Boolean = false,
    val isError: Boolean = false
)
