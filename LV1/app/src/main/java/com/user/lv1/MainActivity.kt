package com.user.lv1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnEnter.setOnClickListener {
            val fullName = etFullName.text.toString()
            val desc = etDesc.text.toString()
            tvName.text = fullName
            tvDesc.text = desc
            etFullName.text.clear()
            etDesc.text.clear()
        }

        btnCalc.setOnClickListener {
            val height = etHeight.text.toString().toFloat()
            val weight = etWeight.text.toString().toFloat()
            val ibm = weight / ((height/100) * (height/100))
            Toast.makeText(
                applicationContext,
                "$ibm",
                Toast.LENGTH_LONG).show()
            etHeight.text.clear()
            etWeight.text.clear()
        }

    }
}