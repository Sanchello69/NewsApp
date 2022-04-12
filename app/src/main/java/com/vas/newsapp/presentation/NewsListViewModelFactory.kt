package com.vas.newsapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vas.newsapp.domain.useCase.GetNewsListUseCase

class NewsListViewModelFactory (val getNewsListUseCase: GetNewsListUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsListViewModel::class.java)) {
            return NewsListViewModel(
                getNewsListUseCase = getNewsListUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown class name")    }
}