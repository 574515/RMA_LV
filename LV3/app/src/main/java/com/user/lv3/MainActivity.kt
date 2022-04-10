package com.user.lv3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.user.lv3.R
import com.user.lv3.data.DataSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataSet = DataSource().loadTasks()
        val recyclerView =  findViewById<RecyclerView>(R.id.recyclerView)
        Log.d("TaskAdapter", "getItemCount: " + dataSet.size)

        recyclerView.adapter =  TaskAdapter(this, dataSet)

        //dodati edit text i button Add, i to ga dodaje na listu
    }
}