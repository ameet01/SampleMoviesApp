package android.example.myapplication.features.moviedetail.repository

import android.example.network.api.MovieDetailApi
import android.example.network.models.MovieDetailModel
import io.reactivex.Single

class MovieDetailRepository constructor(
    private val movieDetailApi: MovieDetailApi,
    private val movieId: String,
    private val moviesDetailCache: MovieDetailCache
) {

    fun getMovie(): Single<MovieDetailModel> {
        return if (moviesDetailCache.containsKey(movieId)) {
            moviesDetailCache.get(movieId)!!
        } else {
            movieDetailApi.getMovie(movieId).`as` {
                moviesDetailCache.put(movieId, it)
                it
            }
        }
    }
}
