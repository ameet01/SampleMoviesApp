package android.example.myapplication.features.movieslist.usecase

import android.example.myapplication.features.movieslist.di.MoviesListScope
import android.example.myapplication.features.movieslist.repository.MoviesListRepository
import android.example.network.models.MovieListModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@MoviesListScope
class MoviesListUseCase @Inject constructor(
    private val moviesListRepository: MoviesListRepository
) {

    fun searchMovies(string: String): Single<MovieListModel> {
        return moviesListRepository.getMoviesFromSearch(string)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
