package com.example.win2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.win2.model.Termin

class Holder(val list: ArrayList<Termin>, context: Context): RecyclerView.Adapter<Holder.MainHolder>(){
    val context = context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_termens, parent, false)
        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(list[position].title)
        holder.itemView.setOnClickListener {
            val intent = Intent(context, InfoActivity::class.java)
            intent.putExtra("title", list[position].title)
            intent.putExtra("text", list[position].text)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MainHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        private val tvTitle = itemView.findViewById<TextView>(R.id.title)
        fun bind(title: String){
            tvTitle.text = title
        }
    }




}