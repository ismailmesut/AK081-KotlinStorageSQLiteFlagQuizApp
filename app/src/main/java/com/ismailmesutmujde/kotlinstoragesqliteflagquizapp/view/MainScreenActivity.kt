package com.ismailmesutmujde.kotlinstoragesqliteflagquizapp.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper
import com.ismailmesutmujde.kotlinstoragesqliteflagquizapp.R
import com.ismailmesutmujde.kotlinstoragesqliteflagquizapp.databinding.ActivityMainScreenBinding
import java.lang.Exception


class MainScreenActivity : AppCompatActivity() {

    private lateinit var bindingMainScreen : ActivityMainScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMainScreen = ActivityMainScreenBinding.inflate(layoutInflater)
        val view = bindingMainScreen.root
        setContentView(view)

        copyDatabase()

        bindingMainScreen.buttonStart.setOnClickListener {
            val intent = Intent(this@MainScreenActivity, QuizScreenActivity::class.java)
            startActivity(intent)
        }

    }

    fun copyDatabase() {
        val copyHelper = DatabaseCopyHelper(this)
        try {
            copyHelper.createDataBase()
            copyHelper.openDataBase()
        } catch (e:Exception) {
            e.printStackTrace()
        }
    }
}