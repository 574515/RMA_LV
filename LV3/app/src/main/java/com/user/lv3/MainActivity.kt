package com.user.lv3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.user.lv3.model.Task
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())

        rvView.adapter = todoAdapter
        rvView.layoutManager = LinearLayoutManager(this)

        btnAddTodo.setOnClickListener {
            val todoTitle = etTodoTitle.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = Task(todoTitle)
                todoAdapter.addTodo(todo)
                etTodoTitle.text.clear()
            }
        }
    }
}