package com.vas.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.vas.newsapp.app.App
import com.vas.newsapp.databinding.ActivityMainBinding
import com.vas.newsapp.presentation.NewsListAdapter
import com.vas.newsapp.presentation.NewsListViewModel
import com.vas.newsapp.presentation.NewsListViewModelFactory
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: NewsListViewModelFactory

    private var binding: ActivityMainBinding? = null
    private var viewModel: NewsListViewModel? = null

    private val pagingAdapter by lazy {
        NewsListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setupViewModel()
        setupUI()
        setupObservers()
    }

    private fun setupUI() {

        //binding?.newsRecyclerView?.addItemDecoration(itemDecorator)
        binding?.newsRecyclerView?.adapter = pagingAdapter
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(NewsListViewModel::class.java)
    }

    private fun setupObservers() {
        viewModel?.newsListData?.observe(this, Observer {
            lifecycleScope.launch {
                pagingAdapter?.submitData(it)
                Log.d("paging", it.toString())
            }
        })
    }
}