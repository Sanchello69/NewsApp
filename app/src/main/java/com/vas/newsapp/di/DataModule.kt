package com.vas.newsapp.di

import com.vas.newsapp.data.network.api.ApiInterface
import com.vas.newsapp.data.network.api.RetrofitClient
import com.vas.newsapp.data.repository.NewsListRepositoryImpl
import com.vas.newsapp.domain.repository.NewsListRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule{

    @Provides
    fun provideApiInterface(): ApiInterface{
        return RetrofitClient.apiInterface
    }

    @Provides
    fun provideNewsListRepository(apiInterface: ApiInterface): NewsListRepository{
        return NewsListRepositoryImpl(apiInterface = apiInterface)
    }

}