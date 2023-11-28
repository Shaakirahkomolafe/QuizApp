package com.example.quizapp;

public class Question {
    String question;
    Boolean answer;

    int color;

    public Question(String question, Boolean answer, int color){
        this.question = question;
        this.answer = answer;
        this.color = color;

    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Boolean getAnswer() {
        return answer;
    }

    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
