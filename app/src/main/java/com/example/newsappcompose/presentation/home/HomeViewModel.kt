package com.example.newsappcompose.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.newsappcompose.domain.usecases.news.GetNews
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getNews: GetNews
) : ViewModel() {


    val news = getNews(
        sources = listOf("bbc-news", "abc-news", "al-jazeera-english")
    ).cachedIn(viewModelScope)

}