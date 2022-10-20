package com.example.core_data.repo

import com.example.core_data.source.remote.GoogleBookRemoteDataSource
import com.example.core_model.response.GoogleBookResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GoogleBookRepositoryImpl @Inject constructor(private val googleBookRemoteDataSource: GoogleBookRemoteDataSource) :
    GoogleBookRepository {
    override fun getSearchBook(
        q: String,
        startIndex: Int,
        maxResult: Int,
    ): Flow<GoogleBookResponse> =
        googleBookRemoteDataSource.getSearchBook(q, startIndex, maxResult)
}