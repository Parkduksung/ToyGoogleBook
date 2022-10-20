package com.example.core_data.repo

import com.example.core_data.source.remote.GoogleBookRemoteDataSource
import com.example.core_model.MOCK_GOOGLE_BOOK_RESPONSE
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GoogleBookRepositoryImplTest {

    private val googleBookRemoteDataSource: GoogleBookRemoteDataSource = mock()

    private lateinit var googleBookRepository: GoogleBookRepository

    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        googleBookRepository = GoogleBookRepositoryImpl(googleBookRemoteDataSource)
    }


    @Test
    fun getSearchBookResponseTest() = runBlocking {

        //given
        whenever(
            googleBookRemoteDataSource.getSearchBook(
                "android",
                startIndex = 1,
                maxResult = 20
            )
        ).thenReturn(
            flowOf(MOCK_GOOGLE_BOOK_RESPONSE)
        )

        //when
        googleBookRepository.getSearchBook(
            "android",
            startIndex = 1,
            maxResult = 20
        ).collectLatest {

                //then
                assertEquals(it, MOCK_GOOGLE_BOOK_RESPONSE)
            }

    }
}