package com.example.core_data.source.remote

import com.example.core_model.response.GoogleBookResponse
import kotlinx.coroutines.flow.Flow

interface GoogleBookRemoteDataSource {

   fun getSearchBookResponse(q : String, startIndex : Int) : Flow<GoogleBookResponse>
}