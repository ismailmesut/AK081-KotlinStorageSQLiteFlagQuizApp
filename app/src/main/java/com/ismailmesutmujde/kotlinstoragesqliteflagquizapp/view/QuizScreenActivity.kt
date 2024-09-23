package com.ismailmesutmujde.kotlinstoragesqliteflagquizapp.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ismailmesutmujde.kotlinstoragesqliteflagquizapp.dao.FlagsDao
import com.ismailmesutmujde.kotlinstoragesqliteflagquizapp.database.DatabaseHelper
import com.ismailmesutmujde.kotlinstoragesqliteflagquizapp.databinding.ActivityQuizScreenBinding
import com.ismailmesutmujde.kotlinstoragesqliteflagquizapp.model.Flags

class QuizScreenActivity : AppCompatActivity() {

    private lateinit var bindingQuizScreen : ActivityQuizScreenBinding

    private lateinit var questions:ArrayList<Flags>
    private lateinit var wrongOptions:ArrayList<Flags>
    private lateinit var correctQuestion:Flags
    private lateinit var allOptions:HashSet<Flags>
    private lateinit var dbh:DatabaseHelper

    private var questionCounter = 0
    private var correctCounter = 0
    private var wrongCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingQuizScreen = ActivityQuizScreenBinding.inflate(layoutInflater)
        val view = bindingQuizScreen.root
        setContentView(view)

        dbh = DatabaseHelper(this)

        questions = FlagsDao().getRandomly5Flags(dbh)

        questionUpload()

        bindingQuizScreen.buttonA.setOnClickListener {
            correctControl(bindingQuizScreen.buttonA)
            questionCounterControl()
        }
        bindingQuizScreen.buttonB.setOnClickListener {
            correctControl(bindingQuizScreen.buttonB)
            questionCounterControl()
        }
        bindingQuizScreen.buttonC.setOnClickListener {
            correctControl(bindingQuizScreen.buttonC)
            questionCounterControl()

        }
        bindingQuizScreen.buttonD.setOnClickListener {
            correctControl(bindingQuizScreen.buttonD)
            questionCounterControl()
        }

    }

    fun questionUpload() {
        bindingQuizScreen.textViewQuestionNumber.text = "Question ${questionCounter + 1}"

        correctQuestion = questions.get(questionCounter)

        bindingQuizScreen.imageViewFlag.setImageResource(resources.getIdentifier(correctQuestion.flag_image, "drawable", packageName))

        wrongOptions = FlagsDao().getRandomly3WrongOptions(dbh, correctQuestion.flag_id)

        allOptions = HashSet()
        allOptions.add(correctQuestion)
        allOptions.add(wrongOptions.get(0))
        allOptions.add(wrongOptions.get(1))
        allOptions.add(wrongOptions.get(2))
        bindingQuizScreen.buttonA.text = allOptions.elementAt(0).flag_name
        bindingQuizScreen.buttonB.text = allOptions.elementAt(1).flag_name
        bindingQuizScreen.buttonC.text = allOptions.elementAt(2).flag_name
        bindingQuizScreen.buttonD.text = allOptions.elementAt(3).flag_name
    }

    fun questionCounterControl() {
        questionCounter++

        if(questionCounter != 5) {
            questionUpload()
        } else {
            val intent = Intent(this@QuizScreenActivity, ResultScreenActivity::class.java)
            intent.putExtra("correctCounter",correctCounter)
            startActivity(intent)
            finish()
        }
    }

    fun correctControl(button: Button) {
        val buttonText = button.text.toString()
        val correctAnswer = correctQuestion.flag_name

        if (buttonText == correctAnswer) {
            correctCounter++
        } else {
            wrongCounter++
        }
        bindingQuizScreen.textViewCorrect.text = "Correct : $correctCounter"
        bindingQuizScreen.textViewWrong.text = "Wrong : $wrongCounter"
    }
}