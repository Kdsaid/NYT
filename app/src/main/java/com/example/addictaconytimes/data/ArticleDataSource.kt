package com.example.addictaconytimes.data

import com.example.addictaconytimes.domain.dto.Result
import com.example.addictaconytimes.domain.dto.api.ArticlesResponse

interface ArticleDataSource {
    suspend fun getArticles(period: Int): Result<ArticlesResponse>
}