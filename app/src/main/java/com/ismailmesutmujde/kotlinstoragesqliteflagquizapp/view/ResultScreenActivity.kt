package com.ismailmesutmujde.kotlinstoragesqliteflagquizapp.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ismailmesutmujde.kotlinstoragesqliteflagquizapp.databinding.ActivityResultScreenBinding

class ResultScreenActivity : AppCompatActivity() {

    private lateinit var bindingResultScreen : ActivityResultScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingResultScreen = ActivityResultScreenBinding.inflate(layoutInflater)
        val view = bindingResultScreen.root
        setContentView(view)

        val correctCounter = intent.getIntExtra("correctCounter",0)
        bindingResultScreen.textViewResult.text = "$correctCounter CORRECT ${5-correctCounter} WRONG"

        bindingResultScreen.textViewPercentageResult.text = "${(correctCounter*100)/5}% SUCCESS"

        bindingResultScreen.buttonTryAgain.setOnClickListener {
            val intent = Intent(this@ResultScreenActivity, QuizScreenActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}