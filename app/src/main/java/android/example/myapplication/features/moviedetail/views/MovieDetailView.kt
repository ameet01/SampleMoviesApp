package android.example.myapplication.features.moviedetail.views

import android.example.myapplication.R
import android.example.myapplication.databinding.MovieDetailViewBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

private const val LAYOUT_ID = R.layout.movie_detail_view

class MovieDetailView(
    parent: ViewGroup?,
    private val moviesViewModel: MovieDetailViewModel,
    private val fragment: LifecycleOwner
) {

    val view: MovieDetailViewBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context), LAYOUT_ID, parent,false)

    init {
        view.viewModel = moviesViewModel
        view.lifecycleOwner = fragment
        observeViewModel()
        moviesViewModel.getMovie()
    }

    private fun render(movieDetailViewState: MovieDetailViewState) {
        view.title.text = movieDetailViewState.movieDetailResponse.title
    }

    private fun observeViewModel() {
        moviesViewModel.movieDetailViewState.observe(fragment, Observer {
            render(it)
        })
    }
}
