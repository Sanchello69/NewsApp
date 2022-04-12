package com.vas.newsapp.data.network.model

data class NewsModelApi(

    val status: String,

    val totalResults: Int,

    val articles: List<ArticleModelApi>,

    )
