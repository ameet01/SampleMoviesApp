package android.example.myapplication.features.moviedetail.views

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

class MovieDetailFragment : Fragment(), FragmentNavigator {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel by viewModels<MovieDetailViewModel> { factory }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return MovieDetailView(container, viewModel, this).view.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDi()
    }

    private fun initDi() {
        MainApplication.applicationComponent.movieDetailBuilder()
            .movieId(arguments?.getString("id") ?: "")
            .build()
            .inject(this)
    }

    override fun navigate(action: Int, bundle: Bundle) {
        findNavController().navigate(action, bundle)
    }
}
