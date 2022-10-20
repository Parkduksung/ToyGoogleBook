package com.example.feature_googlebook_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.core_common.CommonUiState
import com.example.core_common.constant.DEFAULT_MAX_RESULTS
import com.example.core_common.result.Result
import com.example.core_common.result.asResult
import com.example.core_data.repo.GoogleBookRepository
import com.example.core_model.GoogleBookItem
import com.example.core_model.response.Item
import com.example.core_model.response.asGoogleBookItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Inject

@HiltViewModel
class GoogleBookListViewModel @Inject constructor(private val googleBookRepository: GoogleBookRepository) :
    ViewModel() {

    private val googleBookLinkedHashMap = LinkedHashMap<String, GoogleBookItem>()
    private var startIndex = 1
    private var isEndPosition = AtomicBoolean(false)


    private val _uiState = mutableStateOf(
        GoogleBookListUiState(
            commonUiState = CommonUiState.HideLoading,
            searchBookState = SearchBookUiState.Idle
        )
    )
    val uiState: State<GoogleBookListUiState> = _uiState

    private val _inputState = mutableStateOf("")
    val inputState: State<String> = _inputState

    private val getSearchBook = { query: String, startIndex: Int ->
        googleBookRepository.getSearchBookResponse(query, startIndex, DEFAULT_MAX_RESULTS)
            .asResult()
    }

    private fun getBookSearch(query: String, startInt: Int) {
        getSearchBook(query, startInt).onEach { result ->
            when (result) {
                is Result.Success -> {
                    showBookProcess(result.data.items)
                }
                is Result.Error -> {
                    _uiState.value = _uiState.value.copy(
                        commonUiState = CommonUiState.HideLoading,
                        searchBookState = SearchBookUiState.Error
                    )
                }
                Result.Loading -> {
                    _uiState.value = _uiState.value.copy(
                        commonUiState = CommonUiState.ShowLoading
                    )
                }
            }
        }.launchIn(CoroutineScope(Dispatchers.IO))
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
        if (!isEndPosition.get()) {
            isEndPosition.set(true)
            if (googleBookLinkedHashMap.isNotEmpty()) {
                startIndex += DEFAULT_MAX_RESULTS
                getBookSearch(_inputState.value, startIndex)
            }
        }
    }

    private fun showBookProcess(list: List<Item>?) {

        //검색 리스트 결과가 없을 경우
        if (list.isNullOrEmpty()) {
            //페이징이 끝난 경우
            if (googleBookLinkedHashMap.isNotEmpty()) {
                onChangedUiState(
                    _uiState.value.copy(
                        commonUiState = CommonUiState.ShowMessage("더이상 찾을 수 없습니다.")
                    )
                )
            }
            //검색 리스트를 아예 못찾는 경우
            else {
                onChangedUiState(
                    _uiState.value.copy(
                        commonUiState = CommonUiState.HideLoading,
                        searchBookState = SearchBookUiState.NotSearch
                    )
                )
            }
        }
        //검색 리스트 결과가 있는 경우
        else {
            val toGoogleBookItem = list.map { item ->
                Pair(
                    item.volumeInfo.title.orEmpty(),
                    item.volumeInfo.asGoogleBookItem()
                )
            }
            googleBookLinkedHashMap.putAll(toGoogleBookItem)

            onChangedUiState(
                _uiState.value.copy(
                    commonUiState = CommonUiState.HideLoading,
                    searchBookState = SearchBookUiState.Success(googleBookLinkedHashMap.map { it.value })
                )
            )
            isEndPosition.set(false)
        }
    }

    fun onInputChange(input: String) {
        _inputState.value = input
    }

    private fun onChangedUiState(uiState: GoogleBookListUiState) {
        _uiState.value = uiState
    }


    private fun clear() {
        startIndex = 1
        googleBookLinkedHashMap.clear()
        isEndPosition.set(false)
    }
}
