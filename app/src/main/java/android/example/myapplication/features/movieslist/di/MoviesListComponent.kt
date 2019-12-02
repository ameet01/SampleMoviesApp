package android.example.myapplication.features.movieslist.di

import android.example.myapplication.features.moviedetail.di.MovieDetailComponent
import android.example.myapplication.features.movieslist.views.MoviesListFragment
import android.example.network.api.MoviesApi
import dagger.Subcomponent
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class MoviesListScope

@MoviesListScope
@Subcomponent(modules = [MoviesListModule::class])
interface MoviesListComponent {

    val moviesApi: MoviesApi

    fun inject(moviesListFragment: MoviesListFragment)
}
