package com.example.newsappcompose.presentation.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappcompose.domain.model.Article
import com.example.newsappcompose.domain.usecases.news.DeleteArticle
import com.example.newsappcompose.domain.usecases.news.GetArticle
import com.example.newsappcompose.domain.usecases.news.UpsertArticle
import com.example.newsappcompose.util.UIComponent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getArticleUseCase: GetArticle,
    private val deleteArticleUseCase: DeleteArticle,
    private val upsertArticleUseCase: UpsertArticle
) : ViewModel() {

    var sideEffect by mutableStateOf<UIComponent?>(null)
        private set

    fun onEvent(event: DetailsEvent) {
        when (event) {
            is DetailsEvent.UpsertDeleteArticle -> {
                viewModelScope.launch {
                    val article = getArticleUseCase(url = event.article.url)
                    if (article == null) {
                        upsertArticle(article = event.article)
                    } else {
                        deleteArticle(article = event.article)
                    }
                }
            }

            is DetailsEvent.RemoveSideEffect -> {
                sideEffect = null
            }
        }
    }

    private suspend fun deleteArticle(article: Article) {
        deleteArticleUseCase(article = article)
        sideEffect = UIComponent.Toast("Article deleted")
    }

    private suspend fun upsertArticle(article: Article) {
        upsertArticleUseCase(article = article)
        sideEffect = UIComponent.Toast("Article Inserted")
    }

}