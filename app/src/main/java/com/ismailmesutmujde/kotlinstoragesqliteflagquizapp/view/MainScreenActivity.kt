package com.ismailmesutmujde.kotlinstoragesqliteflagquizapp.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ismailmesutmujde.kotlinstoragesqliteflagquizapp.R
import com.ismailmesutmujde.kotlinstoragesqliteflagquizapp.databinding.ActivityMainScreenBinding


class MainScreenActivity : AppCompatActivity() {

    private lateinit var bindingMainScreen : ActivityMainScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMainScreen = ActivityMainScreenBinding.inflate(layoutInflater)
        val view = bindingMainScreen.root
        setContentView(view)

        bindingMainScreen.buttonStart.setOnClickListener {
            val intent = Intent(this@MainScreenActivity, QuizScreenActivity::class.java)
            startActivity(intent)
        }

    }
}