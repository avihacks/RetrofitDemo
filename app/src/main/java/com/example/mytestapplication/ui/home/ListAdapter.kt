package com.example.mytestapplication.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.kotlinroomdemo.Utils.CommonMethods
import com.example.mytestapplication.R
import com.example.mytestapplication.application.MyApplication
import com.example.mytestapplication.model.response.issues_response.IssuesResponseAll
import com.example.mytestapplication.model.response.issues_response.IssuesResponseAllItem
import com.example.mytestapplication.network.ApiManager

class ListAdapter(private val mList: List<IssuesResponseAll>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val listResponseAll = mList[position]


        // sets the text to the textview from our itemHolder class
        holder.name.text = "Name:  "+listResponseAll.user?.login.toString()
        holder.title.text ="Title:  "+listResponseAll.title
        holder.desc.text = "Desc:  "+listResponseAll.body
        holder.date.text = "Updated At :  "+CommonMethods.formatDateStr(""+listResponseAll.updatedAt)

        Glide.with(MyApplication.context)
            .load(listResponseAll.user?.avatarUrl)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            //  .skipMemoryCache(true)
           // .apply(requestOptions)
            .into(holder.img)
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val name: TextView = itemView.findViewById(R.id.tv_name)
        val desc: TextView = itemView.findViewById(R.id.tv_desc)
        val title: TextView = itemView.findViewById(R.id.tv_title)
        val date: TextView = itemView.findViewById(R.id.tv_date)
        val img: ImageView = itemView.findViewById(R.id.b2)
    }
}
