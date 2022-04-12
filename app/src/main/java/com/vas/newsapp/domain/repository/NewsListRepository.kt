package com.vas.newsapp.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.vas.newsapp.data.network.model.ArticleModelApi
import com.vas.newsapp.data.network.model.NewsModelApi
import com.vas.newsapp.domain.model.ArticleModel

interface NewsListRepository {
    fun getNewsList(): LiveData<PagingData<ArticleModel>>
}