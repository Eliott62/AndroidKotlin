package com.example.androidkotlin.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidkotlin.R
import com.example.androidkotlin.domain.entity.Club
import kotlinx.android.synthetic.main.row_layout_club.view.*

class ClubsAdapter(private val clubs: List<Club>) : RecyclerView.Adapter<ClubsAdapter.ViewHolder>() {
        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val teamName : TextView = itemView.teamName
        // val logo : ImageView = itemView.logo
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.row_layout_club,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val club = clubs[position]
        holder.teamName.text = club.name
        //Glide.with(parent.context).load(logo).into(holder.logo)
    }

    override fun getItemCount() = clubs.size
}
