package android.example.network.interceptors

import android.example.network.MoviesInfo
import okhttp3.Interceptor
import okhttp3.Response

class QueryParameterInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url().newBuilder().addQueryParameter("apikey", MoviesInfo.OMDBAPI_KEY).build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}
