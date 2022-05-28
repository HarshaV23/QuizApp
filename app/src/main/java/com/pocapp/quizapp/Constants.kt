package com.pocapp.quizapp

object Constants {

        fun getQuestions() : ArrayList<Question>{
            val questionList = ArrayList<Question>()

            val que1 = Question(
                1,"What country does this flag belong to?",R.drawable.ic_flag_of_argentina
                ,"Argentina","Austria","Australia","Germany",1)

            val que2 = Question(
                2,"What country does this flag belong to?",R.drawable.ic_flag_of_australia
                ,"India","America","United Kingdom","Australia",4)
            val que3 = Question(
                3,"What country does this flag belong to?",R.drawable.ic_flag_of_belgium
                ,"Netherland","Blegium","Indonasia","Singapore",2)
            val que4 = Question(
                4,"What country does this flag belong to?",R.drawable.ic_flag_of_brazil
                ,"Brazil","Austria","India","Iran",1)
            val que5 = Question(
                5,"What country does this flag belong to?",R.drawable.ic_flag_of_denmark
                ,"Argentina","France","Denmark","Canada",3)

            questionList.add(que1)
            questionList.add(que2)
            questionList.add(que3)
            questionList.add(que4)
            questionList.add(que5)

            return questionList
        }
}