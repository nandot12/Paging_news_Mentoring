package com.udacoding.pagingnewsmentoring.dataSource.factory

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.udacoding.pagingnewsmentoring.dataSource.NewsDataSource
import com.udacoding.pagingnewsmentoring.model.ArticlesItem

class NewsDataFactory : DataSource.Factory<Long,ArticlesItem>() {

    var mutableLivedata : MutableLiveData<NewsDataSource>
    var newsDataSource : NewsDataSource

    init {
        mutableLivedata = MutableLiveData()
        newsDataSource = NewsDataSource()
    }
    override fun create(): DataSource<Long, ArticlesItem> {
        mutableLivedata.postValue(newsDataSource)
        return newsDataSource

    }

    fun getMutableLiveData():MutableLiveData<NewsDataSource>{
        return mutableLivedata
    }
}