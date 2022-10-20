package com.example.feature_googlebook_list

import com.example.core_common.CommonUiState
import com.example.core_model.GoogleBookItem

/**
 * @see CommonUiState
 */
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
