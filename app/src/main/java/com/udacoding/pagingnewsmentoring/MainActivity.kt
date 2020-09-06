package com.udacoding.pagingnewsmentoring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.udacoding.pagingnewsmentoring.adapter.NewslistAdapter
import com.udacoding.pagingnewsmentoring.viewModel.NewsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private  var viewModel : NewsViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)
        viewModel?.getArticle()

        viewModel?.articleData?.observe(this, Observer {


            val adapter = NewslistAdapter()
            adapter.submitList(it)
            listNews.adapter = adapter
        })

    }
}