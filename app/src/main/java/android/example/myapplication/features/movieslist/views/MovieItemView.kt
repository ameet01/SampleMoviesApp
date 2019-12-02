package android.example.myapplication.features.movieslist.views

import android.example.myapplication.R
import android.example.myapplication.common.FragmentNavigator
import android.example.myapplication.common.base.BaseViewHolder
import android.example.myapplication.databinding.MovieItemBinding
import android.example.network.models.MovieModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieItemView(parent: ViewGroup, private val fragmentNavigator: FragmentNavigator) {

    val binding: MovieItemBinding = inflateDataBinding(parent).also {
        it.root.setFadeAnimation()
        it.root.movieListItem.setOnClickListener {
            val bundle = bundleOf("id" to movieId)
            val action = R.id.action_moviesListFragment_to_movieDetailFragment

            fragmentNavigator.navigate(action, bundle)
        }
    }
    private var movieId: String = ""


    private fun inflateDataBinding(parent: ViewGroup): MovieItemBinding {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.movie_item,
            parent,
            false
        )
    }

    private fun View.setFadeAnimation() {
        val anim = AlphaAnimation(0.0f, 1.0f)
        anim.duration = 800
        startAnimation(anim)
    }

    fun render(movieModel: MovieModel) {
        movieId = movieModel.imdbID
        binding.apply {
            movie = movieModel
        }
    }

    class ViewHolder(private val view: MovieItemView) : BaseViewHolder<MovieItemBinding>(view.binding) {

        fun bind(movie: MovieModel) {
            view.render(movie)
        }
    }
}


