package android.example.myapplication.features.moviedetail.views

import android.example.myapplication.common.utils.addTo
import android.example.myapplication.features.moviedetail.usecase.MovieDetailUseCase
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(
    private val movieDetailUseCase: MovieDetailUseCase
) : ViewModel() {

    private val _movieDetailViewState = MutableLiveData<MovieDetailViewState>(MovieDetailViewState())
    val movieDetailViewState: LiveData<MovieDetailViewState> = _movieDetailViewState

    private val compositeDisposable = CompositeDisposable()

    fun getMovie() {
        movieDetailUseCase.getMovie()
            .doOnError {
                _movieDetailViewState.value = _movieDetailViewState.value?.copy(isError = true, isLoading = false)
            }.doOnSubscribe {
                _movieDetailViewState.value = _movieDetailViewState.value?.copy(isError = false, isLoading = true)
            }.subscribe { response ->
                _movieDetailViewState.value = _movieDetailViewState.value?.copy(
                    isError = false,
                    isLoading = false,
                    movieDetailResponse = response
                )
            }.addTo(compositeDisposable)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}
