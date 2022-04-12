package com.vas.newsapp.di

import com.vas.newsapp.domain.useCase.GetNewsListUseCase
import com.vas.newsapp.presentation.NewsListViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideNewsListViewModelFactory(getNewsListUseCase: GetNewsListUseCase): NewsListViewModelFactory{
        return NewsListViewModelFactory(getNewsListUseCase = getNewsListUseCase)
    }

}