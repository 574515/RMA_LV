package com.user.lv3

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.user.lv3.model.Task

class TaskAdapter(private val context : Context,  private val dataSet : List<Task>) : RecyclerView.Adapter<TaskAdapter.ItemViewHolder>() {

    class ItemViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val textView: TextView? = view.findViewById(R.id.textView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemViewHolder = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(itemViewHolder)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val task = dataSet[position]
        holder.textView!!.text = context.resources.getString(task.stringResId)
    }

    override fun getItemCount(): Int {
        Log.d("TaskAdapter", "getItemCount: " + dataSet.size)
        return dataSet.size
    }

}