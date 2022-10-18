package com.example.feature_googlebook_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.feature_googlebook_list.component.SearchBookListScreen

@Composable
fun GoogleBookListScreen(
    viewModel: GoogleBookListViewModel = hiltViewModel()
) {

    val input = viewModel.inputState.value

    val uiState = viewModel.uiState.value

    Box(Modifier.fillMaxSize()) {

        Column(Modifier.fillMaxSize()) {
            OutlinedTextField(
                value = input,
                onValueChange = viewModel::onInputChange,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.LightGray,
                    unfocusedBorderColor = Color.LightGray
                ),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        viewModel.searchBook()
                    }
                ),
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                label = { Text("Input Search Book Name!") }
            )

            SearchBookListScreen(viewModel = viewModel, uiState.searchBookState)
        }
    }
}


fun LazyListState.isScrolledToTheEnd() =
    layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1