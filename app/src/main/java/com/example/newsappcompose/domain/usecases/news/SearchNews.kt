package com.example.newsappcompose.domain.usecases.news

import androidx.paging.PagingData
import com.example.newsappcompose.domain.model.Article
import com.example.newsappcompose.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchNews @Inject constructor(private val newsRepository: NewsRepository) {

    operator fun invoke(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = sources)
    }

}