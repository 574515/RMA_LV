package com.user.lv3

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class TodoAdapter(private val todos: MutableList<Task>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }

    fun addTask(todo: Task) {
        todos.add(todo)
        notifyItemInserted(todos.size - 1)
    }

    fun deleteDone() {
        todos.removeAll { todo -> todo.isChecked }
    }

    private fun strikeThrough(tvTodoTitle: TextView, isChecked: Boolean) {
        if(isChecked) tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        else tvTodoTitle.paintFlags = tvTodoTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currentTask = todos[position]
        holder.itemView.apply {
            tvTask.text = currentTask.task
            cbDone.isChecked = currentTask.isChecked
            strikeThrough(tvTask, currentTask.isChecked)
            cbDone.setOnCheckedChangeListener { _, isChecked ->
                strikeThrough(tvTask, isChecked)
                currentTask.isChecked = !currentTask.isChecked
            }
        }
    }

    override fun getItemCount(): Int { return todos.size }
}