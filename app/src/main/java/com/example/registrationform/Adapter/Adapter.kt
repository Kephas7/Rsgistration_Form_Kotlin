package com.example.registrationform.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.registrationform.R

class Adapter(
    private val context: Context,
    private val imageList: List<Int>,
    private val nameList: List<String>,
    private val descList: List<String>
) : RecyclerView.Adapter<Adapter.RecycleViewHolder>() {

    class RecycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.image)
        val title: TextView = itemView.findViewById(R.id.name)
        val desc: TextView = itemView.findViewById(R.id.description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_view_design, parent, false)
        return RecycleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return nameList.size
    }

    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        holder.title.text = nameList[position]
        holder.desc.text = descList[position]
        holder.image.setImageResource(imageList[position])
    }
}
