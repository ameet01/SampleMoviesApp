package android.example.myapplication.features.moviedetail.repository

import android.example.network.api.MovieDetailApi
import android.example.network.models.MovieDetailModel
import io.reactivex.Single

class MovieDetailRepository constructor(
    private val movieDetailApi: MovieDetailApi,
    private val movieId: String
) {

    fun getMovie(): Single<MovieDetailModel> {
        return movieDetailApi.getMovie(movieId)
    }
}
