package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.quizapp.QuestionBank;


import java.util.ArrayList;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {
    Button trueButton, falseButton;


    ProgressBar quizProgress;

    ArrayList<Question> questions;

    QuestionBank questionBank;

    int questionIndex = 0;

    int quizScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);
        quizProgress = findViewById(R.id.quizProgress);

        questions = questionBank.getQuestionArrayList();

        QuestionFragment questionFragment = QuestionFragment.newInstance(questions.get(questionIndex).getQuestion(), questions.get(questionIndex).getColor());

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.frame);

        if (fragment == null) {
          Fragment tf = new Fragment();

           fm.beginTransaction().add(R.id.frame, tf).commit();
        }
        else {
            fm.beginTransaction().remove(fragment).commit();

        }






            trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questions.get(questionIndex).answer == Boolean.TRUE) {
                    quizScore++;

                    Toast.makeText(MainActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
                }
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questions.get(questionIndex).answer == Boolean.FALSE) {
                    quizScore++;
                    Toast.makeText(MainActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
    void shuffleArray(){
        Collections.shuffle(questions);
    }
}