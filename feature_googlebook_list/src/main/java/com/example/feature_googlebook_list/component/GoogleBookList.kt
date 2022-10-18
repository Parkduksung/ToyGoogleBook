package com.example.feature_googlebook_list.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core_model.GoogleBookItem
import com.example.feature_googlebook_list.GoogleBookListViewModel
import com.example.feature_googlebook_list.SearchBookUiState
import com.example.feature_googlebook_list.isScrolledToTheEnd

@Composable
fun SearchBookListScreen(
    viewModel: GoogleBookListViewModel,
    searchBookUiState: SearchBookUiState
) {

    val listState = rememberLazyListState()



    when (searchBookUiState) {

        is SearchBookUiState.UnDefine->{}
        is SearchBookUiState.Success -> {
            LazyColumn(
                state = listState,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                items(searchBookUiState.items) { item: GoogleBookItem ->
                    GoogleBookItem(item)
                }
            }
        }

        is SearchBookUiState.Error -> {
            //todo
        }
    }



    if (listState.isScrolledToTheEnd()) {
        viewModel.nextPage()
    }
}