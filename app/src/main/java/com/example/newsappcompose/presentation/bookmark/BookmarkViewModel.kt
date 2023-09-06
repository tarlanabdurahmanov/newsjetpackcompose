package com.example.newsappcompose.presentation.bookmark

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappcompose.domain.usecases.news.GetArticles
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(
    private val getArticlesUseCase: GetArticles
) : ViewModel() {

    private val _state = mutableStateOf(BookmarkState())
    val state: State<BookmarkState> = _state

    init {
        getArticles()
    }

    private fun getArticles() {
        getArticlesUseCase().onEach {
            _state.value = _state.value.copy(articles = it)
        }.launchIn(viewModelScope)
    }
}