package com.udacoding.pagingnewsmentoring.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.udacoding.pagingnewsmentoring.R
import com.udacoding.pagingnewsmentoring.model.ArticlesItem
import kotlinx.android.synthetic.main.item_news.view.*

class NewslistAdapter : PagedListAdapter<ArticlesItem,RecyclerView.ViewHolder>(ArticlesItem().DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //https://pastebin.com/ZeiHC6GV
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)

        return NewsHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if(holder is NewsHolder){
            holder.bindTo(getItem(position))
        }
    }

    class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindTo(item: ArticlesItem?) {

            itemView.item_title.text = item?.title
            itemView.item_desc.text = item?.description
            itemView.item_time.text = item?.publishedAt
            Picasso.get().load(item?.urlToImage).into(itemView.item_image)

        }

    }
}