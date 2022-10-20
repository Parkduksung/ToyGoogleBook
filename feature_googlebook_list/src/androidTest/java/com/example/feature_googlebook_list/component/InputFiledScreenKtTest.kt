package com.example.feature_googlebook_list.component

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.core_data.repo.GoogleBookRepository
import com.example.feature_googlebook_list.GoogleBookListViewModel
import com.example.feature_googlebook_list.base.BaseComposeUiTest
import com.example.feature_googlebook_list.di.FakeRepositoryModule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@UninstallModules(FakeRepositoryModule::class)
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class InputFiledScreenKtTest : BaseComposeUiTest() {


    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var googleBookRepository : GoogleBookRepository



    private lateinit var bookListViewModel: GoogleBookListViewModel


    @Before
    fun setUp() {
        bookListViewModel = GoogleBookListViewModel(googleBookRepository)
    }

    @Test
    fun inputFiledTextTest() {

        val mockText = "hello world"

        composeTestRule.setContent {
            InputFiledScreen(viewModel = bookListViewModel)
        }

        bookListViewModel.onInputChange(mockText)

        composeTestRule.onNodeWithText(mockText).assertIsDisplayed()

    }

}