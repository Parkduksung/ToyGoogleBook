package com.example.core_network

import com.example.core_model.response.GoogleBookResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleBookApi {

    companion object {

        const val URL_BASE = "https://www.googleapis.com/"

        const val URL_SEARCH_BOOKS = "books/v1/volumes"
        const val DEFAULT_MAX_RESULTS = 20
        const val DEFAULT_PROJECTION = "lite"

    }

    /**
     * @see GoogleBookResponse
     */
    @GET(URL_SEARCH_BOOKS)
    suspend fun getSearchBooks(
        @Query("q") q: String,
        @Query("maxResults") maxResults: Int = DEFAULT_MAX_RESULTS,
        @Query("startIndex") startIndex: Int,
        @Query("projection") projection: String = DEFAULT_PROJECTION
    ): GoogleBookResponse

}