package com.example.nikeassessment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nikeassessment.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container,MainFragment()).commit()
    }
}
