package com.example.feature_googlebook_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.feature_googlebook_list.component.CommonUiScreen
import com.example.feature_googlebook_list.component.InputFiled
import com.example.feature_googlebook_list.component.SearchBookListScreen

@Composable
fun GoogleBookListScreen(
    viewModel: GoogleBookListViewModel = hiltViewModel()
) {

    val uiState = viewModel.uiState.value

    Box(Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize()) {
            InputFiled(viewModel)
            SearchBookListScreen(viewModel = viewModel, uiState.searchBookState)
        }
        CommonUiScreen(
            modifier = Modifier.align(Alignment.Center),
            commonUiState = uiState.commonUiState
        )
    }
}


fun LazyListState.isScrolledToTheEnd() =
    layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1