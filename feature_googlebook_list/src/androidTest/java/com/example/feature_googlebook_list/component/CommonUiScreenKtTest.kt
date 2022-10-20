package com.example.feature_googlebook_list.component

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import com.example.core_common.CommonUiState
import com.example.feature_googlebook_list.base.BaseComposeUiTest
import org.junit.Test

class CommonUiScreenKtTest : BaseComposeUiTest() {


    @Test
    fun commonUiShowLoadingTest() {

        val commonUiState = CommonUiState.ShowLoading

        composeTestRule.setContent {
            CommonUiScreen(modifier = Modifier, commonUiState = commonUiState)
        }

        composeTestRule.onNodeWithTag("progress").assertIsDisplayed()
    }

    @Test
    fun commonUiHideLoadingTest() {

        val commonUiState = CommonUiState.HideLoading

        composeTestRule.setContent {
            CommonUiScreen(modifier = Modifier, commonUiState = commonUiState)
        }

        composeTestRule.onNodeWithTag("progress").assertDoesNotExist()
    }

    @Test
    fun commonUiShowToastMessageTest() {
        val commonUiState = CommonUiState.ShowMessage("test")

        composeTestRule.setContent {
            CommonUiScreen(modifier = Modifier, commonUiState = commonUiState)
        }
        //todo Toast Message 체킹하는법 확인할 것.

        composeTestRule.onNodeWithTag("progress").assertDoesNotExist()

    }

}