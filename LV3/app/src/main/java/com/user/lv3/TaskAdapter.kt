package com.user.lv3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.user.lv3.model.Task

class TodoAdapter(
    private val todos: MutableList<Task>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item,
                parent,
                false
            )
        )
    }

    fun addTodo(todo: Task) {
        todos.add(todo)
        notifyItemInserted(todos.size - 1)
    }


    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return todos.size
    }
}
