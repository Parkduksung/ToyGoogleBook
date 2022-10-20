package com.example.feature_googlebook_list.base

import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule

abstract class BaseComposeUiTest {

    @get: Rule
    val composeTestRule = createComposeRule()

}