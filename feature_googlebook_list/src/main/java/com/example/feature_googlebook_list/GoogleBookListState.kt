package com.example.feature_googlebook_list

import com.example.core_model.GoogleBookItem

data class GoogleBookListUiState(
    val searchBookState: SearchBookUiState
)

sealed interface SearchBookUiState {
    data class Success(val items: List<GoogleBookItem>) : SearchBookUiState
    object Error : SearchBookUiState
    object Loading : SearchBookUiState
}