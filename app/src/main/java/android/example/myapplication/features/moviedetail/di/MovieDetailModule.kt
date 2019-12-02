package android.example.myapplication.features.moviedetail.di

import android.example.myapplication.common.ViewModelKey
import android.example.myapplication.features.moviedetail.repository.MovieDetailCache
import android.example.myapplication.features.moviedetail.repository.MovieDetailRepository
import android.example.myapplication.features.moviedetail.usecase.MovieDetailUseCase
import android.example.myapplication.features.moviedetail.views.MovieDetailViewModel
import android.example.myapplication.features.movieslist.di.MoviesListScope
import android.example.myapplication.features.movieslist.views.MoviesListViewModel
import android.example.network.MoviesInfo
import android.example.network.api.MovieDetailApi
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class MovieDetailModule {

    @Provides
    @MovieDetailScope
    fun provideMovieDetailApi(retrofit: Retrofit): MovieDetailApi {
        return retrofit.create(MovieDetailApi::class.java)
    }

    @Provides
    @MovieDetailScope
    fun provideMovieDetailRepository(@Named("movieId") movieId: String, movieDetailApi: MovieDetailApi): MovieDetailRepository {
        return MovieDetailRepository(movieDetailApi, movieId, MovieDetailCache())
    }
}

@Module
abstract class MoviesDetailViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailViewModel::class)
    internal abstract fun moviesListViewModel(viewModel: MovieDetailViewModel): ViewModel
}
