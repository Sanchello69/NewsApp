package com.vas.newsapp.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.vas.newsapp.data.network.api.ApiInterface
import com.vas.newsapp.data.pagingSources.NETWORK_PAGE_SIZE
import com.vas.newsapp.data.pagingSources.NewsListPagingSource
import com.vas.newsapp.domain.model.ArticleModel
import com.vas.newsapp.domain.repository.NewsListRepository

class NewsListRepositoryImpl (private val apiInterface: ApiInterface) : NewsListRepository {

    override fun getNewsList(): LiveData<PagingData<ArticleModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                NewsListPagingSource(apiInterface = apiInterface)
            }
        ).liveData
    }
}