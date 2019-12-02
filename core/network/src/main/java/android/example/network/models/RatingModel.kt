package android.example.network.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RatingModel(
    @Json(name = "Source") var source: String? = null,
    @Json(name = "Value") var value: String? = null
)
