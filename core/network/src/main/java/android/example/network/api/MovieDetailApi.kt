package android.example.network.api

import android.example.network.models.MovieDetailModel
import androidx.annotation.Keep
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDetailApi {

    @GET(".")
    @Keep
    fun getMovie(@Query(value = "i") id: String): Single<MovieDetailModel>
}
