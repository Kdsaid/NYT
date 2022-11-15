package com.example.addictaconytimes.presentation.main.article

import com.example.addictaconytimes.presentation.main.article.ArticleFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ArticleFragmentProvider {
    @ContributesAndroidInjector
    abstract fun provideArticleFragmentFactory(): ArticleFragment
}