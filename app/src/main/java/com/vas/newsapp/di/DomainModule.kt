package com.vas.newsapp.di

import com.vas.newsapp.domain.repository.NewsListRepository
import com.vas.newsapp.domain.useCase.GetNewsListUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetNewsUseCase(newsListRepository: NewsListRepository): GetNewsListUseCase{
        return GetNewsListUseCase(newsRepository = newsListRepository)
    }

}