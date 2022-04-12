package com.vas.newsapp.domain.useCase

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.vas.newsapp.domain.model.ArticleModel
import com.vas.newsapp.domain.repository.NewsListRepository

class GetNewsListUseCase(private val newsRepository: NewsListRepository) {

    fun execute(): LiveData<PagingData<ArticleModel>> {
        return newsRepository.getNewsList()
    }

}