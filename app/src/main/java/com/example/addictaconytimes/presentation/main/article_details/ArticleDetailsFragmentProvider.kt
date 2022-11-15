package com.example.addictaconytimes.presentation.main.article_details

import com.example.addictaconytimes.presentation.main.article_details.ArticleDetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ArticleDetailsFragmentProvider {
    @ContributesAndroidInjector
    abstract fun provideArticleDetailsFragmentFactory(): ArticleDetailsFragment
}