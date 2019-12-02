package android.example.myapplication.features.moviedetail.usecase

import android.example.myapplication.features.moviedetail.repository.MovieDetailRepository
import android.example.network.models.MovieDetailModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieDetailUseCase @Inject constructor(private val movieDetailRepository: MovieDetailRepository) {

    fun getMovie(): Single<MovieDetailModel> {
        return movieDetailRepository.getMovie()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
