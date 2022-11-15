package com.example.addictaconytimes.di.module

import android.app.Application
import android.content.Context
import com.example.addictaconytimes.BuildConfig
import com.example.addictaconytimes.data.ArticleDataSource
import com.example.addictaconytimes.data.ArticleFavoritesDataSource
import com.example.addictaconytimes.data.remote.ApiService
import com.example.addictaconytimes.di.ApiInfo
import com.example.addictaconytimes.domain.repository.ArticleRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @ApiInfo
    fun provideApiKey(): String {
        return BuildConfig.API_KEY
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create<ApiService>(ApiService::class.java)
    }


    @Provides
    @Singleton
    fun provideArticleDataSource(ArticleRepository: ArticleRepository): ArticleDataSource {
        return ArticleRepository
    }



}