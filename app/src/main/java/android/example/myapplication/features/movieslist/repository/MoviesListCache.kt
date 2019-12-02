package android.example.myapplication.features.movieslist.repository

import android.example.myapplication.features.movieslist.di.MoviesListScope
import android.example.network.models.MovieListModel
import io.reactivex.Single
import javax.inject.Inject

@MoviesListScope
class MoviesListCache @Inject constructor() {
    private val cache = HashMap<String, Single<MovieListModel>>()

    fun containsKey(string: String) = cache.containsKey(string)

    fun get(string: String) = cache[string]

    fun put(string: String, response: Single<MovieListModel>) {
        cache[string] = response
    }
}
