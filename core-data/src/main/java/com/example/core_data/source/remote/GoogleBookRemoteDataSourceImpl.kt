package com.example.core_data.source.remote

import com.example.core_model.response.GoogleBookResponse
import com.example.core_network.GoogleBookApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GoogleBookRemoteDataSourceImpl @Inject constructor(private val googleBookApi: GoogleBookApi) :
    GoogleBookRemoteDataSource {

    override fun getSearchBookResponse(q: String, startIndex: Int,maxResult : Int): Flow<GoogleBookResponse> =
        flow { emit(googleBookApi.getSearchBooks(q = q, startIndex = startIndex, maxResults = maxResult)) }
}