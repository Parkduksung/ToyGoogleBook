package com.example.core_common

sealed interface CommonUiState {
    data class ShowMessage(val message: String) : CommonUiState
    object ShowLoading : CommonUiState
    object HideLoading : CommonUiState
}