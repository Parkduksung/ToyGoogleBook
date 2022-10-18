package com.example.core_data.repo

import com.example.core_common.result.Result
import com.example.core_data.source.remote.GoogleBookRemoteDataSource
import com.example.core_model.GoogleBookItem
import com.example.core_model.response.GoogleBookResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GoogleBookRepositoryImpl @Inject constructor(private val googleBookRemoteDataSource: GoogleBookRemoteDataSource) :
    GoogleBookRepository {

    private val bookLinkedHashMap = LinkedHashMap<String, GoogleBookItem>()

    override suspend fun getSearchBookItem(
        q: String,
        startIndex: Int
    ): Flow<Result<List<GoogleBookItem>>> = flow {
        try {

            emit(Result.Loading)

//            val toGoogleBookItem = googleBookRemoteDataSource.getSearchBookResponse(
//                q,
//                startIndex
//            ).items.map { Pair(it.volumeInfo.title, it.volumeInfo.asGoogleBookItem()) }
//
//            bookLinkedHashMap.putAll(toGoogleBookItem)
//
//            emit(Result.Success(bookLinkedHashMap.map { it.value }))

        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }

    private fun clear() {
        bookLinkedHashMap.clear()
    }

    override fun getSearchBookResponse(q: String, startIndex: Int): Flow<GoogleBookResponse> =
        googleBookRemoteDataSource.getSearchBookResponse(q, startIndex)


}