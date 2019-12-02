package android.example.myapplication.features.movieslist.views

import android.example.myapplication.MainApplication
import android.example.myapplication.common.FragmentNavigator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import javax.inject.Inject

class MoviesListFragment : Fragment(), FragmentNavigator {

    @Inject lateinit var factory: ViewModelProvider.Factory
    private val viewModel by viewModels<MoviesListViewModel> { factory }
    private lateinit var moviesListView: MoviesListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDi()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        moviesListView = MoviesListView(container, viewModel, this)
        return moviesListView.view.root
    }

    private fun initDi() {
        MainApplication
            .applicationComponent
            .moviesListComponent().also {
                it.inject(this)
            }
    }

    override fun navigate(action: Int, bundle: Bundle) {
        findNavController().navigate(action, bundle)
    }
}
