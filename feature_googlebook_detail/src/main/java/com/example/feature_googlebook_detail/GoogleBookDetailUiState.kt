package com.example.feature_googlebook_detail

import com.example.core_model.GoogleBookItem

data class GoogleBookDetailUiState(
    val googleBookItemUiState: GoogleBookItemUiState
)

sealed interface GoogleBookItemUiState {
    data class GetItem(val item: GoogleBookItem) : GoogleBookItemUiState
    object Error : GoogleBookItemUiState
}
