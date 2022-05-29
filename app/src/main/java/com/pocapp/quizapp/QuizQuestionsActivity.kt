package com.pocapp.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import java.util.*
import kotlin.collections.ArrayList

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

   private var mCurrentPosition : Int = 1
   private var mQuestionArrayList : ArrayList<Question>? = null
   private var mSelectedOption : Int = 0
   private var mPlayerName : String? = null
   private var mCorrectAnwers : Int? = null


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
         mPlayerName = intent.getStringExtra(Constants.USER_NAME)

         progressBar = findViewById(R.id.progressBar)
         tvProgressBar = findViewById(R.id.tvProgressBar)
         tvQuestion = findViewById(R.id.tvQuestion)
         iVQuestionFlag = findViewById(R.id.iVFlag)
         submitButton = findViewById(R.id.submitButton)
         option1 = findViewById(R.id.tv_option_one)
         option2 = findViewById(R.id.tv_option_two)
         option3 = findViewById(R.id.tv_option_three)
         option4 = findViewById(R.id.tv_option_four)

         option1?.setOnClickListener(this)
         option2?.setOnClickListener(this)
         option3?.setOnClickListener(this)
         option4?.setOnClickListener(this)
         submitButton?.setOnClickListener(this)

         mQuestionArrayList = Constants.getQuestions()
         mCorrectAnwers = mQuestionArrayList!!.size
         setQuestion()


     }

    private fun setQuestion() {
        defaultOptionsView()
        val question: Question = mQuestionArrayList!![mCurrentPosition - 1]
        progressBar?.progress = mCurrentPosition
        tvProgressBar?.text = "$mCurrentPosition/${progressBar?.max}"
        iVQuestionFlag?.setImageResource(question?.image)
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
        var options = ArrayList<TextView>()
        option1?.let {
            options.add(0,it)
        }

       option2?.let {
            options.add(1,it)
        }

        option3?.let {
            options.add(2,it)
        }

        option4?.let {
            options.add(3,it)
        }

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_border
            )
        }
    }

    private fun selectedOptionView(tv : TextView, selectedOptionNum : Int){
        defaultOptionsView()
        mSelectedOption = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363a43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.question_select_border
        )

    }

    override fun onClick(view : View?) {
        when(view?.id){
            R.id.tv_option_one ->{
                option1?.let {
                    selectedOptionView(it,1)
                }
            }
            R.id.tv_option_two ->{
                option2?.let {
                    selectedOptionView(it,2)
                }
            }
            R.id.tv_option_three ->{
                option3?.let {
                    selectedOptionView(it,3)
                }
            }
            R.id.tv_option_four ->{
                option4?.let {
                    selectedOptionView(it,4)
                }
            }
            R.id.submitButton ->{
                if(mSelectedOption == 0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionArrayList!!.size -> {
                            setQuestion()
                        }else->{
                            var intent = Intent(this,Result_Activity::class.java)
                            intent.putExtra(Constants.USER_NAME,mPlayerName)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionArrayList?.size)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnwers)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question = mQuestionArrayList?.get(mCurrentPosition-1)
                    if(question!!.correctAnswer != mSelectedOption){
                        answerView(mSelectedOption,R.drawable.wrong_answer_border)
                        mCorrectAnwers= mCorrectAnwers?.minus(1)
                    }
                    answerView(question.correctAnswer, R.drawable.correct_answer_border)

                    if(mCurrentPosition == mQuestionArrayList!!.size){
                        submitButton?.text = "Finish!"
                    }else{
                        submitButton?.text = "Go to next Question!!"
                    }

                    mSelectedOption = 0
                }

            }
        }
    }

    private fun answerView(answer : Int, drawableView : Int){
        when(answer){
            1 -> {
                option1?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                option2?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                option3?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                option4?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
}