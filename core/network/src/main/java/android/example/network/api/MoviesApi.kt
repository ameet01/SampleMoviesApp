package android.example.network.api

import android.example.network.models.MovieListModel
import androidx.annotation.Keep
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET(".")
    @Keep
    fun searchForMovie(@Query(value = "s") string: String): Single<MovieListModel>
}
