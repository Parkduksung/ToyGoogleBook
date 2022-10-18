package com.example.feature_googlebook_list

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.core_common.constant.DEFAULT_MAX_RESULTS
import com.example.core_common.result.Result
import com.example.core_common.result.asResult
import com.example.core_data.repo.GoogleBookRepository
import com.example.core_model.GoogleBookItem
import com.example.core_model.response.asGoogleBookItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class GoogleBookListViewModel @Inject constructor(private val googleBookRepository: GoogleBookRepository) :
    ViewModel() {

    private val googleBookLinkedHashMap = LinkedHashMap<String, GoogleBookItem>()

    private val _inputState = mutableStateOf("")
    val inputState: State<String> = _inputState


    private val getSearchBook = { query: String, startIndex: Int ->
        googleBookRepository.getSearchBookResponse(query, startIndex, DEFAULT_MAX_RESULTS)
            .asResult()
    }

    private val _uiState = mutableStateOf(GoogleBookListUiState(SearchBookUiState.UnDefine))
    val uiState: State<GoogleBookListUiState> = _uiState

    private var startIndex = 1
    private var isEndPosition = false

    private fun getBookSearch(query: String, startInt: Int) {
        getSearchBook(query, startInt).onEach { result ->
            when (result) {
                is Result.Success -> {

                    val toGoogleBookItem = result.data.items.map { item ->
                        Pair(item.volumeInfo.title.orEmpty(), item.volumeInfo.asGoogleBookItem())
                    }
                    googleBookLinkedHashMap.putAll(toGoogleBookItem)

                    Log.d("결과", googleBookLinkedHashMap.size.toString())

                    _uiState.value = _uiState.value.copy(
                        searchBookState = SearchBookUiState.Success(googleBookLinkedHashMap.map { it.value })
                    )
                    isEndPosition = false
                }
                is Result.Error -> {

                }
                Result.Loading -> {}
            }
        }.launchIn(CoroutineScope(Dispatchers.IO))
    }

    fun onInputChange(input: String) {
        _inputState.value = input
    }

    fun searchBook() {
        if (_inputState.value.isNotEmpty()) {
            clear()
            getBookSearch(_inputState.value, startIndex)
        }
    }

    /**
     * @see DEFAULT_MAX_RESULTS
     */
    fun nextPage() {
        if (!isEndPosition) {
            isEndPosition = true

            if (googleBookLinkedHashMap.isNotEmpty()) {
                startIndex += DEFAULT_MAX_RESULTS
                getBookSearch(_inputState.value, startIndex)
            }
        }
    }

    private fun clear() {
        startIndex = 1
        googleBookLinkedHashMap.clear()
        isEndPosition = false
    }
}
