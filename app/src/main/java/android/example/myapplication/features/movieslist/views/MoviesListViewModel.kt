package android.example.myapplication.features.movieslist.views

import android.example.myapplication.common.utils.addTo
import android.example.myapplication.features.movieslist.usecase.MoviesListUseCase
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MoviesListViewModel @Inject constructor(
    private val moviesListUseCase: MoviesListUseCase
) : ViewModel() {

    private val _viewState = MutableLiveData<MoviesListViewState>(MoviesListViewState())
    val viewState: LiveData<MoviesListViewState> = _viewState

    private val compositeDisposable = CompositeDisposable()

    fun searchForMovies(string: String) {
        moviesListUseCase.searchMovies(string)
            .doOnError { _viewState.value = _viewState.value?.copy(isError = true, isLoading = false) }
            .doOnSubscribe { _viewState.value = _viewState.value?.copy(isLoading = true, isError = false) }
            .subscribe { response ->
                _viewState.value = _viewState.value?.copy(
                    movies = response.search,
                    isError = false,
                    isLoading = false
                )
            }
            .addTo(compositeDisposable)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}


