package android.example.myapplication.features.movieslist.repository

import android.example.myapplication.features.movieslist.di.MoviesListScope
import android.example.network.api.MoviesApi
import android.example.network.models.MovieListModel
import io.reactivex.Single
import javax.inject.Inject

@MoviesListScope
class MoviesListRepository @Inject constructor(
    private val moviesApi: MoviesApi,
    private val moviesListCache: MoviesListCache
) {

    fun getMoviesFromSearch(search: String): Single<MovieListModel> {
        return if (moviesListCache.containsKey(search)) {
            moviesListCache.get(search)!!
        } else {
            moviesApi.searchForMovie(search).`as` {
                moviesListCache.put(search, it)
                it
            }
        }
    }
}
