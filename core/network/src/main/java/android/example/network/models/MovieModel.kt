package android.example.network.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieModel(
    @Json(name = "Title") var title: String = "",
    @Json(name = "Year") var year: String = "",
    @Json(name = "imdbID") var imdbID: String = "",
    @Json(name = "Type") var type: String = "",
    @Json(name = "Poster") var poster: String = ""
)
