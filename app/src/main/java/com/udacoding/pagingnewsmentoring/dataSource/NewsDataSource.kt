package com.udacoding.pagingnewsmentoring.dataSource

import androidx.paging.PageKeyedDataSource
import com.udacoding.pagingnewsmentoring.model.ArticlesItem
import com.udacoding.pagingnewsmentoring.network.NewsService
import com.udacoding.pagingnewsmentoring.network.ResApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers


class NewsDataSource : PageKeyedDataSource<Long,ArticlesItem>(){


    var api : NewsService

    init {

        api = ResApi.restApi()
    }
    override fun loadInitial(
        params: LoadInitialParams<Long>,
        callback: LoadInitialCallback<Long, ArticlesItem>
    ) {

        api.getNews("Movie","079dac74a5f94ebdb990ecf61c8854b7",1,params.requestedLoadSize)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                t ->
                t.articles?.let { callback.onResult(it,null,2L) }

            },{})
    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Long, ArticlesItem>) {
        api.getNews("Movie","7e16ba0716d5468c8828539a5f856c34",params.key,params.requestedLoadSize)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                    t ->
                t.articles?.let { callback.onResult(it,params.key + 1) }

            },{})
    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<Long, ArticlesItem>) {
    }

}