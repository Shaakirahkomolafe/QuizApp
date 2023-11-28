package com.example.quizapp;

import java.util.ArrayList;


public class QuestionBank {
    ArrayList<Question> questionArrayList = new ArrayList<>();


    public ArrayList<Question> getQuestionArrayList() {
        questionArrayList.add(new Question("@string/questionOne",Boolean.TRUE,R.color.blue));
        questionArrayList.add(new Question("@string/questionTwo",Boolean.FALSE,R.color.gray));
        questionArrayList.add(new Question("@string/questionThree",Boolean.TRUE,R.color.green));
        questionArrayList.add(new Question("@string/questionFour",Boolean.FALSE,R.color.teal));
        questionArrayList.add(new Question("@string/questionFive",Boolean.FALSE,R.color.lime));
        questionArrayList.add(new Question("@string/questionSix",Boolean.TRUE,R.color.navy));
        questionArrayList.add(new Question("@string/questionSeven",Boolean.FALSE,R.color.red));
        questionArrayList.add(new Question("@string/questionEight",Boolean.TRUE,R.color.fuchsia));
        questionArrayList.add(new Question("@string/questionNine",Boolean.FALSE ,R.color.yellow));
        questionArrayList.add(new Question("@string/questionTen",Boolean.TRUE,R.color.olive));


        return questionArrayList;
    }
}
