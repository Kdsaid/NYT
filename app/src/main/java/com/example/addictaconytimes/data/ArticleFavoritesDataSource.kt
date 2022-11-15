package com.example.addictaconytimes.data

import androidx.lifecycle.LiveData
import com.example.addictaconytimes.domain.dto.api.ArticlesResponse

interface ArticleFavoritesDataSource {
    fun getAllFavorites(): LiveData<List<ArticlesResponse.Article>>
}