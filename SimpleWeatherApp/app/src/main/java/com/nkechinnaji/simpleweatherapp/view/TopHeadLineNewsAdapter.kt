package com.nkechinnaji.simpleweatherapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nkechinnaji.simpleweatherapp.R
import com.nkechinnaji.simpleweatherapp.model.Articles

class TopHeadLineNewsAdapter(var newsList: List<Articles?>): RecyclerView.Adapter<TopHeadLineNewsAdapter.NewsHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_row, parent,false)
        var viewHolder = NewsHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
    var position = newsList.get(position)
        holder.title.text = position?.title
        holder.source.text = position?.source?.name
        holder.url.text = position?.url

    }

    override fun getItemCount(): Int {
        return newsList.size
    }



    class NewsHolder(v: View): RecyclerView.ViewHolder(v){
        var title = v.findViewById<TextView>(R.id.title)
        var url = v.findViewById<TextView>(R.id.url)
        var source = v.findViewById<TextView>(R.id.source)

    }
}