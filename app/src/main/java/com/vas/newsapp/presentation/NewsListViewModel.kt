package com.vas.newsapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.vas.newsapp.domain.model.ArticleModel
import com.vas.newsapp.domain.useCase.GetNewsListUseCase

class NewsListViewModel (private val getNewsListUseCase: GetNewsListUseCase) : ViewModel() {
    val newsListData: LiveData<PagingData<ArticleModel>> = getNewsListUseCase.execute().cachedIn(viewModelScope)
}