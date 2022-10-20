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
import com.example.feature_googlebook_list.component.InputFiledScreen
import com.example.feature_googlebook_list.component.SearchBookListScreen

@Composable
fun GoogleBookListScreen(
    viewModel: GoogleBookListViewModel = hiltViewModel(),
    navigationToGoogleBookDetail: (String) -> Unit
) {

    val uiState = viewModel.uiState.value

    Box(Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize()) {
            InputFiledScreen(viewModel)
            SearchBookListScreen(
                viewModel = viewModel,
                uiState.searchBookState,
                navigationToGoogleBookDetail
            )
        }
        CommonUiScreen(
            modifier = Modifier.align(Alignment.Center),
            commonUiState = uiState.commonUiState
        )
    }
}


fun LazyListState.isScrolledToTheEnd() =
    layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1