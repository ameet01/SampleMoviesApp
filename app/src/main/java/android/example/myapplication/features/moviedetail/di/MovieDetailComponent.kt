package android.example.myapplication.features.moviedetail.di

import android.example.myapplication.features.moviedetail.views.MovieDetailFragment
import dagger.BindsInstance
import dagger.Subcomponent
import javax.inject.Qualifier
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class MovieDetailScope

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Named(val value: String = "")

@MovieDetailScope
@Subcomponent(modules = [MovieDetailModule::class, MoviesDetailViewModelModule::class])
interface MovieDetailComponent {

    fun inject(movieDetailFragment: MovieDetailFragment)

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance fun movieId(@Named("movieId") id: String): Builder
        fun build(): MovieDetailComponent
    }
}



