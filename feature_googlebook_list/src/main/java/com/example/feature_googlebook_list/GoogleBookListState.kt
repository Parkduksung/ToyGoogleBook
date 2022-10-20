package com.example.feature_googlebook_list

import com.example.core_model.GoogleBookItem

data class GoogleBookListUiState(
    val commonUiState: CommonUiState,
    val searchBookState: SearchBookUiState
)

sealed interface SearchBookUiState {
    object Idle : SearchBookUiState
    data class Success(val items: List<GoogleBookItem>) : SearchBookUiState
    object NotSearch : SearchBookUiState
    object Error : SearchBookUiState
}


sealed interface CommonUiState {
    data class ShowMessage(val message: String) : CommonUiState
    object ShowLoading : CommonUiState
    object HideLoading : CommonUiState
}