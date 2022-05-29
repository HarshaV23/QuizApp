package com.pocapp.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Result_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

         var playerNameTv : TextView = findViewById(R.id.tvPlayerName)
         var answersTv : TextView = findViewById(R.id.tvAnswers)
         var finishBtn : Button = findViewById(R.id.finishBtn)

         var playerName = intent.getStringExtra(Constants.USER_NAME)
         var correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
         var totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,5)

        playerNameTv?.text = playerName
        answersTv?.text = "You have answered $correctAnswers out of $totalQuestions correctly!!"

        finishBtn?.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}