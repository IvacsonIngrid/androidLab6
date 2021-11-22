package com.example.androidnavigationexample

import android.content.ClipData
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidnavigationexample.R.color.cardview_light_background
import com.example.androidnavigationexample.model.Question

class DataAdapter(
    private val list: List<Question>,
    private val listener: OnItemClickListener
    ) :
    RecyclerView.Adapter<DataAdapter.DataViewHolder>() {

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    var counter_create: Int = 0
    var counter_bind: Int = 0


    // 1. user defined ViewHolder type - Embedded class!
    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), OnClickListener {
        val textView3: ImageView = itemView.findViewById(R.id.text_view_3)
        val textView1: TextView = itemView.findViewById(R.id.text_view_1)
        val textView2: TextView = itemView.findViewById(R.id.text_view_2)

        init{
            itemView.setOnClickListener(this)
        }
        override fun onClick(p0: View?) {
            val currentPosition = this.adapterPosition
//            Log.d("xxx", "AdapterPosition: $currentPosition")
            listener.onItemClick(currentPosition)

        }
    }


    // 2. Called only a few times = number of items on screen + a few more ones
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        ++counter_create
//        Log.d("xxx", "onCreateViewHolder: $counter_create")
        return DataViewHolder(itemView)
    }


    // 3. Called many times, when we scroll the list
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val currentItem = list[position]
        holder.textView1.text = currentItem.text
        holder.textView2.text = currentItem.answers[3]
        //holder.textView3.text = "single answer"
        ++counter_bind
        Log.d("xxx", "onBindViewHolder: $counter_bind")
    }


    // 4.
    override fun getItemCount() = list.size
}
