package com.example.feature_googlebook_list.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.feature_googlebook_list.GoogleBookListViewModel

@Composable
fun InputFiled(viewModel: GoogleBookListViewModel) {

    val input = viewModel.inputState.value

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

}