package android.example.myapplication.features.movieslist.views

import android.example.myapplication.R
import android.example.myapplication.common.FragmentNavigator
import android.example.myapplication.common.utils.isVisible
import android.example.myapplication.databinding.MoviesListViewBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

private const val LAYOUT_ID = R.layout.movies_list_view

class MoviesListView(
    parent: ViewGroup?,
    private val moviesViewModel: MoviesListViewModel,
    private val fragment: LifecycleOwner
) {

    private val homeListAdapter = MoviesListAdapter(fragment as FragmentNavigator)
    val view: MoviesListViewBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context), LAYOUT_ID, parent, false)

    init {
        initView()
        observeViewModel()
    }

    private fun initView() {
        view.apply {
            viewModel = moviesViewModel
            lifecycleOwner = fragment
            moviesRecyclerView.apply {
                adapter = homeListAdapter
                layoutManager = LinearLayoutManager(context)
            }
            searchButton.setOnClickListener {
                moviesViewModel.searchForMovies(view.movieSearch.text.toString())
            }
        }
    }

    private fun observeViewModel() {
        moviesViewModel.viewState.observe(fragment, Observer { viewState -> render(viewState) })
    }

    private fun render(viewState: MoviesListViewState) {
        homeListAdapter.submitList(viewState.movies)
        view.errorView.isVisible = viewState.isError
        view.progressLoader.isVisible = viewState.isLoading
    }
}
