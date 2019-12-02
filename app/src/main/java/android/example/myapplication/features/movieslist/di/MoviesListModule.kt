package android.example.myapplication.features.movieslist.di

import android.example.myapplication.common.ViewModelKey
import android.example.myapplication.features.movieslist.views.MoviesListViewModel
import android.example.network.api.MoviesApi
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import retrofit2.Retrofit

@Module
class MoviesListModule {

    @Provides
    @MoviesListScope
    fun provideMoviesApi(retrofit: Retrofit): MoviesApi {
        return retrofit.create(MoviesApi::class.java)
    }
}

@Module
abstract class MoviesListViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MoviesListViewModel::class)
    internal abstract fun moviesListViewModel(viewModel: MoviesListViewModel): ViewModel
}
