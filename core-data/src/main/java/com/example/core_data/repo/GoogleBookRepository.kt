package com.example.core_data.repo

import com.example.core_common.result.Result
import com.example.core_data.source.remote.GoogleBookRemoteDataSource
import com.example.core_model.GoogleBookItem
import kotlinx.coroutines.flow.Flow

interface GoogleBookRepository : GoogleBookRemoteDataSource {

    suspend fun getSearchBookItem(
        q: String,
        startIndex: Int
    ): Flow<Result<List<GoogleBookItem>>>



}