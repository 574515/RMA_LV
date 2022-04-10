package com.user.lv3.data

import com.user.lv3.R
import com.user.lv3.model.Task

class DataSource {

    fun loadTasks() : List<Task>{

        return listOf<Task>(
            Task(R.string.task1),
            Task(R.string.task2),
            Task(R.string.task3)
        )

    }

}