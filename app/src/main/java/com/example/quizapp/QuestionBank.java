package com.example.quizapp;

import android.content.Context;

import java.util.ArrayList;


public class QuestionBank {
    Context context;
    ArrayList<Question> questionArrayList = new ArrayList<>();


    public ArrayList<Question> getQuestionArrayList(Context c) {
        context = c;
        questionArrayList.add(new Question(context.getResources().getString(R.string.questionOne),Boolean.TRUE,R.color.blue));
        questionArrayList.add(new Question(context.getResources().getString(R.string.questionTwo),Boolean.FALSE,R.color.gray));
        questionArrayList.add(new Question(context.getResources().getString(R.string.questionThree),Boolean.TRUE,R.color.green));
        questionArrayList.add(new Question(context.getResources().getString(R.string.questionFour),Boolean.FALSE,R.color.teal));
        questionArrayList.add(new Question(context.getResources().getString(R.string.questionFive),Boolean.FALSE,R.color.lime));
        questionArrayList.add(new Question(context.getResources().getString(R.string.questionSix),Boolean.TRUE,R.color.navy));
        questionArrayList.add(new Question(context.getResources().getString(R.string.questionSeven),Boolean.FALSE,R.color.red));
        questionArrayList.add(new Question(context.getResources().getString(R.string.questionEight),Boolean.TRUE,R.color.fuchsia));
        questionArrayList.add(new Question(context.getResources().getString(R.string.questionNine),Boolean.FALSE ,R.color.yellow));
        questionArrayList.add(new Question(context.getResources().getString(R.string.questionTen),Boolean.TRUE,R.color.olive));


        return questionArrayList;
    }
}
