package com.example.viewmodel_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        val plusBtn = findViewById<Button>(R.id.btn_plus)
        val minusBtn = findViewById<Button>(R.id.btn_min)
        val resultArea = findViewById<TextView>(R.id.result)

        resultArea.text = viewModel.countValue.toString()
        plusBtn.setOnClickListener{
            viewModel.plus()
            resultArea.text = viewModel.countValue.toString()
        }

        minusBtn.setOnClickListener {
            viewModel.minus()
            resultArea.text = viewModel.countValue.toString()
        }
    }
}