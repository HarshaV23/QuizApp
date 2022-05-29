package com.pocapp.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startBtn : Button = findViewById(R.id.startBtn)
        val playerName : EditText = findViewById(R.id.playerName)

        startBtn.setOnClickListener {
                if(playerName.text.isEmpty()){
                    Toast.makeText(this,"Please enter a name",Toast.LENGTH_SHORT).show()
                }else{
                    val intent = Intent(this, QuizQuestionsActivity::class.java)
                    intent.putExtra(Constants.USER_NAME,playerName.text.toString())
                    startActivity(intent)
                    finish()
                }
        }
    }
}