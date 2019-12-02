package android.example.myapplication.features.movieslist.di

import android.example.myapplication.common.ViewModelKey
import android.example.myapplication.features.movieslist.views.MoviesListViewModel
import android.example.network.MoviesInfo
import android.example.network.api.MoviesApi
import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class MoviesListModule {

    @Provides
    @IntoMap
    @MoviesListScope
    @ViewModelKey(MoviesListViewModel::class)
    fun homeViewModel(viewModel: MoviesListViewModel): ViewModel = viewModel

    @Provides
    @MoviesListScope
    fun provideMoviesApi(retrofit: Retrofit): MoviesApi {
        return retrofit.create(MoviesApi::class.java)
    }
}
