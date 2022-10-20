package com.example.feature_googlebook_list.component

import android.widget.Toast
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import com.example.core_common.CommonUiState

@Composable
fun CommonUiScreen(modifier: Modifier, commonUiState: CommonUiState) {

    when (commonUiState) {
        CommonUiState.HideLoading -> {}
        CommonUiState.ShowLoading -> {
            CircularProgressIndicator(
                modifier = modifier
                    .semantics { testTag = "progress" })
        }
        is CommonUiState.ShowMessage -> {
            Toast.makeText(LocalContext.current, commonUiState.message, Toast.LENGTH_SHORT).show()
        }
    }
}
