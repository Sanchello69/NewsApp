package com.vas.newsapp.data.network.api

import com.vas.newsapp.Constants.API_KEY
import com.vas.newsapp.data.network.model.NewsModelApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {
    @GET("/v2/top-headlines")
    suspend fun getNews(
        @Query("category") category: String = "business",
        @Query("apiKey") apiKey: String = API_KEY,
        @Query("page") page: Int): Response<NewsModelApi>
}