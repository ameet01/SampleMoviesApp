package android.example.myapplication.features.moviedetail.views

import android.example.myapplication.MainApplication
import android.example.myapplication.common.FragmentNavigator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import javax.inject.Inject

class MovieDetailFragment : Fragment(), FragmentNavigator {

    @Inject
    lateinit var viewModel: MovieDetailViewModel
    private lateinit var movieDetailView: MovieDetailView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        movieDetailView = MovieDetailView(container, viewModel, this)
        setHasOptionsMenu(true)
        return movieDetailView.view.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDi()
    }

    private fun initDi() {
        MainApplication.applicationComponent.movieDetailBuilder().movieId(arguments?.getString("id") ?: "").build().inject(this)
    }

    override fun navigate(action: Int, bundle: Bundle) {
        findNavController().navigate(action, bundle)
    }
}
