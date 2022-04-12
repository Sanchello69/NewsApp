package com.vas.newsapp.presentation

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.vas.newsapp.R
import com.vas.newsapp.databinding.NewsItemBinding
import com.vas.newsapp.domain.model.ArticleModel

class NewsListAdapter /*(private val newsClickListener: () -> Unit)*/ :
    PagingDataAdapter<ArticleModel, NewsListAdapter.ViewHolder>(DiffUtilCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<NewsItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.news_item,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class ViewHolder(private val binding: NewsItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private val context = binding.root.context

//        init {
//            binding.root.setOnClickListener {
//                val newsItem = getItem(absoluteAdapterPosition)
//                newsItem?.let { newsClickListener(it) }
//            }
//        }

        fun bind(item: ArticleModel) {
            with(binding) {
                newsItem = item
                //title.visibility = if (item.title != null) View.VISIBLE else View.GONE
                description.visibility = if (item.description != null) View.VISIBLE else View.GONE
                //author.visibility = if (item.author != null) View.VISIBLE else View.GONE
            }

            Glide
                .with(context)
                .load(item.urlToImage)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        return true
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        return false
                    }

                })
                .into(binding.imageViewUrl)
        }
    }

    object DiffUtilCallBack : DiffUtil.ItemCallback<ArticleModel>() {
        override fun areItemsTheSame(oldItem: ArticleModel, newItem: ArticleModel): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: ArticleModel, newItem: ArticleModel): Boolean {
            return oldItem == newItem
        }
    }
}
