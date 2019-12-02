package android.example.myapplication.features.moviedetail.repository

import android.example.network.models.MovieDetailModel
import io.reactivex.Single


class MovieDetailCache {
    private val cache = HashMap<String, Single<MovieDetailModel>>()

    fun containsKey(string: String) = cache.containsKey(string)

    fun get(string: String) = cache[string]

    fun put(string: String, response: Single<MovieDetailModel>) {
        cache[string] = response
    }
}
