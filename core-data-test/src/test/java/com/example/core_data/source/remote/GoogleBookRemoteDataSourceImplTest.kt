package com.example.core_data.source.remote

import com.example.core_model.MOCK_GOOGLE_BOOK_RESPONSE
import com.example.core_network.GoogleBookApi
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GoogleBookRemoteDataSourceImplTest {

    private val googleBookApi: GoogleBookApi = mock()

    private lateinit var googleBookRemoteDataSource: GoogleBookRemoteDataSource

    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        googleBookRemoteDataSource = GoogleBookRemoteDataSourceImpl(googleBookApi)
    }

    @Test
    fun getSearchBookResponseTest() = runBlocking {

        //given
        whenever(
            googleBookApi.getSearchBooks(
                "android",
                startIndex = 1,
                maxResults = 20
            )
        ).thenReturn(
            MOCK_GOOGLE_BOOK_RESPONSE
        )

        //when
        googleBookRemoteDataSource.getSearchBook(
            "android",
            startIndex = 1,
            maxResult = 20
        ).collectLatest {

            //then
            assertEquals(it, MOCK_GOOGLE_BOOK_RESPONSE)
        }

    }
}