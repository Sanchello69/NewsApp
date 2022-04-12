package com.vas.newsapp.data.pagingSources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.vas.newsapp.data.network.api.ApiInterface
import com.vas.newsapp.domain.model.ArticleModel
import retrofit2.HttpException


const val NETWORK_PAGE_SIZE = 20

class NewsListPagingSource (
    private val apiInterface: ApiInterface) :
    PagingSource<Int, ArticleModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ArticleModel> {

        val page: Int = params.key ?: 1
        val pageSize: Int = params.loadSize.coerceAtMost(NETWORK_PAGE_SIZE)

        val response = apiInterface.getNews(page = page)
        if (response.isSuccessful){
            val articles = checkNotNull(response.body()).articles.map {
                ArticleModel(
                    author = it.author,
                    title = it.title,
                    description = it.description,
                    urlToImage = it.urlToImage,
                    publishedAt = it.publishedAt
                )
            }
            val nextKey = if (articles.size < pageSize) null else page + 1
            val prevKey = if (page == 1) null else page - 1
            return LoadResult.Page(articles, prevKey, nextKey)
        } else {
            return LoadResult.Error(HttpException(response))
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ArticleModel>): Int? {
        //val anchorPosition = state.anchorPosition ?: return null
        //val page = state.closestPageToPosition(anchorPosition) ?: return null
        //return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
        return 1
    }
}