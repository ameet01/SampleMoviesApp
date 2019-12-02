package android.example.network.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieListModel(
    @Json(name = "Search") var search: List<MovieModel> = listOf(),
    @Json(name = "totalResults") var totalResults: String = "",
    @Json(name = "Response") var response: String = ""
)
