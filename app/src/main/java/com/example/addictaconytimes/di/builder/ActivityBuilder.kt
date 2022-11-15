package com.example.addictaconytimes.di.builder

import com.example.addictaconytimes.presentation.main.MainActivity
import com.example.addictaconytimes.presentation.main.article.ArticleFragmentProvider
import com.example.addictaconytimes.presentation.main.article_details.ArticleDetailsFragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [ArticleFragmentProvider::class, ArticleDetailsFragmentProvider::class])
    abstract fun bindMainActivity(): MainActivity
}