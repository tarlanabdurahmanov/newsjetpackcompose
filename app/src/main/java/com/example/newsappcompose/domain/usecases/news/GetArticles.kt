package com.example.newsappcompose.domain.usecases.news

import com.example.newsappcompose.data.local.NewsDao
import com.example.newsappcompose.domain.model.Article
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetArticles @Inject constructor(
    private val newsDao: NewsDao
) {

    operator fun invoke(): Flow<List<Article>> {
        return newsDao.getArticles()
    }

}