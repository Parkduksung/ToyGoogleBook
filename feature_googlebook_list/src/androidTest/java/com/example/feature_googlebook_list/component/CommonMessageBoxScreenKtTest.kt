package com.example.feature_googlebook_list.component

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import com.example.feature_googlebook_list.base.BaseComposeUiTest
import org.junit.Test


class CommonMessageBoxScreenKtTest : BaseComposeUiTest() {

    @Test
    fun textTest() {

        //given
        val mockText = "abcd"

        //when
        composeTestRule.setContent {
            CommonMessageBoxScreen(message = mockText)
        }

        //then
        composeTestRule.onNodeWithText(mockText).assertIsDisplayed()
    }
}