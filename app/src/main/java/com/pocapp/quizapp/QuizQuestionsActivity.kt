package com.pocapp.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import java.util.*

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

   private var mCurrentPosition : Int = 1
   private var mQuestionArrayList : ArrayList<Question>? = null
   private var mSelectedOption : Int = 0

   private var progressBar : ProgressBar? = null
   private var tvProgressBar : TextView? = null
   private var tvQuestion : TextView? = null
   private var iVQuestionFlag : ImageView? = null
   private var submitButton : Button? = null

   private var option1: TextView? = null
   private var option2: TextView? = null
   private var option3: TextView? = null
   private var option4: TextView? = null

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

         progressBar = findViewById(R.id.progressBar)
         tvProgressBar = findViewById(R.id.tvProgressBar)
         tvQuestion = findViewById(R.id.tvQuestion)
         iVQuestionFlag = findViewById(R.id.iVFlag)
         submitButton = findViewById(R.id.submitButton)
         option1 = findViewById(R.id.tv_option_one)
         option2 = findViewById(R.id.tv_option_two)
         option3 = findViewById(R.id.tv_option_three)
         option4 = findViewById(R.id.tv_option_four)

         mQuestionArrayList = Constants.getQuestions()
         setQuestion()


     }

    private fun setQuestion() {

        val question: Question = mQuestionArrayList!![mCurrentPosition - 1]
        progressBar?.progress = mCurrentPosition
        tvProgressBar?.text = "$mCurrentPosition/${progressBar?.max}"
        iVQuestionFlag?.setImageResource(R.drawable.ic_flag_of_argentina)
        tvQuestion?.text = question.question
        option1?.text = question.optionOne
        option2?.text = question.optionTwo
        option3?.text = question.optionThree
        option4?.text = question.optionFour

        if(mCurrentPosition == mQuestionArrayList!!.size){
            submitButton?.text = "Finish!"
        }else{
            submitButton?.text = "Submit!"
        }
    }

    private fun defaultOptionsView(){

    }

    override fun onClick(p0: View?) {

    }
}