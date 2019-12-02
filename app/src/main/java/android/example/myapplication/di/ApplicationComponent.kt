package android.example.myapplication.di

import android.example.myapplication.MainApplication
import android.example.myapplication.di.modules.ApplicationModule
import android.example.myapplication.di.modules.DatabaseModule
import android.example.myapplication.di.modules.NetworkModule
import android.example.myapplication.features.moviedetail.di.MovieDetailComponent
import android.example.myapplication.features.movieslist.di.MoviesListComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [NetworkModule::class,
               DatabaseModule::class,
               ApplicationModule::class]
)
interface ApplicationComponent {

    fun inject(application: MainApplication)

    fun moviesListComponent(): MoviesListComponent

    fun movieDetailBuilder(): MovieDetailComponent.Builder
}
