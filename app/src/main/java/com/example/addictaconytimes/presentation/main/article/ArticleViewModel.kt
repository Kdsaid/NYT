package com.example.addictaconytimes.presentation.main.article

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.addictaconytimes.data.ArticleDataSource
import com.example.addictaconytimes.domain.dto.Result
import com.example.addictaconytimes.domain.dto.api.ArticlesResponse
import com.example.addictaconytimes.presentation.base.BaseViewModel
import com.google.gson.Gson
import kotlinx.coroutines.launch

class ArticleViewModel(
    private val articleDataSource: ArticleDataSource
) : BaseViewModel() {
    private val articlesLiveData: MutableLiveData<List<ArticleDataItem>> = MutableLiveData()

    fun fetchArticles(period: Int) {
        viewModelScope.launch {
            isLoading.value = true
            when (val result = articleDataSource.getArticles(period)) {
                is Result.Success<ArticlesResponse> -> {
                    Log.d(TAG, "fetchArticles: "+Gson().toJson(result))
                    result.data.articles?.let { mapArticlesDataItem(it) }
                    isLoading.value = false
                }
                is Result.Error -> {
                    isLoading.value = false
                    showToast.value = result.message
                }
            }
        }
    }

    val articlesLiveDataLiveData: LiveData<List<ArticleDataItem>>
        get() = articlesLiveData

    init {
        fetchArticles(7)
    }

    private fun mapArticlesDataItem(articles: List<ArticlesResponse.Article>) {
        articlesLiveData.value = articles.map {
            ArticleDataItem(
                it.id,
                if (!it.media.isNullOrEmpty()) it.media?.get(0)?.mediaMetaData?.get(2)?.url else "",
                it.title,
                it.byline,
                it.abstractX,
                it.rank,
                it.publishedDate,
                it.url,
                if (!it.media.isNullOrEmpty()) it.media?.get(0)?.mediaMetaData?.get(1)?.url else ""
            )
        }
    }
}