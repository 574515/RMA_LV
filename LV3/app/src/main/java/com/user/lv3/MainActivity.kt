package com.user.lv3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())

        rvView.adapter = todoAdapter
        rvView.layoutManager = LinearLayoutManager(this)

        btnAdd.setOnClickListener {
            val todoTitle = etTask.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = Task(todoTitle)
                todoAdapter.addTask(todo)
                etTask.text.clear()
            }
        }

        btnDelete.setOnClickListener { todoAdapter.deleteDone() }
    }
}