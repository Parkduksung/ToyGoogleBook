package com.example.core_network.retrofit

import com.example.core_model.response.GoogleBookResponse
import com.example.core_network.GoogleBookApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

private interface RetrofitGoogleBookNetworkApi {
    @GET(GoogleBookApi.URL_SEARCH_BOOKS)
    suspend fun getMovieList(
        @Query("q") q: String,
        @Query("maxResults") maxResults: Int = GoogleBookApi.DEFAULT_MAX_RESULTS,
        @Query("startIndex") startIndex: Int,
        @Query("projection") projection: String = GoogleBookApi.DEFAULT_PROJECTION
    ): GoogleBookResponse
}


@Singleton
class RetrofitGoogleBookNetwork @Inject constructor() : GoogleBookApi {

    private val networkApi = Retrofit.Builder().baseUrl(GoogleBookApi.URL_BASE)
        .addConverterFactory(GsonConverterFactory.create()).build()
        .create(RetrofitGoogleBookNetworkApi::class.java)


    override suspend fun getSearchBooks(
        q: String,
        maxResults: Int,
        startIndex: Int,
        projection: String
    ): GoogleBookResponse =
        networkApi.getMovieList(q, maxResults, startIndex, projection)
}