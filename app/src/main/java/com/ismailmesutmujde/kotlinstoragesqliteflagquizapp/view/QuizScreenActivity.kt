package com.ismailmesutmujde.kotlinstoragesqliteflagquizapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ismailmesutmujde.kotlinstoragesqliteflagquizapp.databinding.ActivityQuizScreenBinding

class QuizScreenActivity : AppCompatActivity() {

    private lateinit var bindingQuizScreen : ActivityQuizScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingQuizScreen = ActivityQuizScreenBinding.inflate(layoutInflater)
        val view = bindingQuizScreen.root
        setContentView(view)

    }
}