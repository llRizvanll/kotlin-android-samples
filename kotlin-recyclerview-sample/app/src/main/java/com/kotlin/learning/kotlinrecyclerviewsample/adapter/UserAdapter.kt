package com.kotlin.learning.kotlinrecyclerviewsample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.learning.kotlinrecyclerviewsample.R
import com.kotlin.learning.kotlinrecyclerviewsample.model.UserData

class UserAdapter(private val userData : ArrayList<UserData>) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){


    class ViewHolder(row : View) : RecyclerView.ViewHolder(row){
        var itemTextNameView : TextView? = row.findViewById(R.id.item_name)
        var itemTextPlaceView : TextView? = row.findViewById(R.id.item_place)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent?.context)
            .inflate(R.layout.list_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return userData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var userItem : UserData = userData[position]
        holder.itemTextNameView?.text = userItem.name
        holder.itemTextPlaceView?.text = userItem.place
    }

}