package com.example.newsappcompose.domain.usecases.news

import com.example.newsappcompose.data.local.NewsDao
import com.example.newsappcompose.domain.model.Article
import javax.inject.Inject


class GetArticle @Inject constructor(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(url: String): Article? {
        return newsDao.getArticle(url = url)
    }

}