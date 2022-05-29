package com.pocapp.quizapp

object Constants {
        const val USER_NAME = "user_name"
        const val TOTAL_QUESTIONS = "total_questions"
        const val CORRECT_ANSWERS = "correct_answers"

        fun getQuestions() : ArrayList<Question>{
            val questionList = ArrayList<Question>()

            val que1 = Question(
                1,"What country does this flag belong to?",R.drawable.ic_flag_of_argentina
                ,"Argentina","Austria","Australia","Germany",1)
            questionList.add(que1)

            val que2 = Question(
                2,"What country does this flag belong to?",R.drawable.ic_flag_of_australia
                ,"India","America","United Kingdom","Australia",4)
            questionList.add(que2)

            val que3 = Question(
                3,"What country does this flag belong to?",R.drawable.ic_flag_of_belgium
                ,"Netherland","Blegium","Indonasia","Singapore",2)
            questionList.add(que3)

            val que4 = Question(
                4,"What country does this flag belong to?",R.drawable.ic_flag_of_brazil
                ,"Brazil","Austria","India","Iran",1)
            questionList.add(que4)

            val que5 = Question(
                5,"What country does this flag belong to?",R.drawable.ic_flag_of_denmark
                ,"Argentina","France","Denmark","Canada",3)
            questionList.add(que5)

            return questionList
        }
}