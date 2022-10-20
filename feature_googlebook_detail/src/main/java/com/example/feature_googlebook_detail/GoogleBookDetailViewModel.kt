package com.example.feature_googlebook_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.core_model.GoogleBookItem
import com.example.feature_googlebook_detail.navigation.GoogleBookDetailDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GoogleBookDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val googleBookItem: GoogleBookItem? =
        checkNotNull(savedStateHandle[GoogleBookDetailDestination.googleBookArg])

    private val _uiState = mutableStateOf(
        GoogleBookDetailUiState(
            googleBookItemUiState =
            if (googleBookItem != null) GoogleBookItemUiState.GetItem(googleBookItem) else GoogleBookItemUiState.Error
        )
    )

    val uiState: State<GoogleBookDetailUiState> = _uiState

}

