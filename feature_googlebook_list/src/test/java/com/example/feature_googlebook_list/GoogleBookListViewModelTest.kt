package com.example.feature_googlebook_list

import com.example.core_common.CommonUiState
import com.example.core_data.repo.GoogleBookRepository
import com.nhaarman.mockitokotlin2.mock
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GoogleBookListViewModelTest {

    private val googleBookRepository: GoogleBookRepository = mock()

    private lateinit var googleBookListViewModel: GoogleBookListViewModel


    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        googleBookListViewModel = GoogleBookListViewModel(googleBookRepository)
    }

    @Test
    fun initUiTest() {
        val uiState = googleBookListViewModel.uiState.value
        assertEquals(uiState.commonUiState, CommonUiState.HideLoading)
        assertEquals(uiState.searchBookState, SearchBookUiState.Idle)
    }

    @Test
    fun inputTest() {

        googleBookListViewModel.onInputChange("android")

        assertEquals(googleBookListViewModel.inputState.value, "android")
    }
}