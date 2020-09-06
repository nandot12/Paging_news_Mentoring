package com.udacoding.pagingnewsmentoring.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.udacoding.pagingnewsmentoring.dataSource.factory.NewsDataFactory
import com.udacoding.pagingnewsmentoring.model.ArticlesItem
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class NewsViewModel : ViewModel(){

    var exucutor : Executor
    var articleData : LiveData<PagedList<ArticlesItem>>

    init {

        exucutor = Executors.newFixedThreadPool(5)

        var newsFactory = NewsDataFactory()

        var pageListConfig = PagedList.Config.Builder()
            .setPageSize(20)
            .setInitialLoadSizeHint(10)
            .setEnablePlaceholders(false)
            .build()

        articleData = LivePagedListBuilder(newsFactory,pageListConfig)
            .setFetchExecutor(exucutor)
            .build()
    }

    fun getArticle (): LiveData<PagedList<ArticlesItem>>{
        return articleData
    }

}