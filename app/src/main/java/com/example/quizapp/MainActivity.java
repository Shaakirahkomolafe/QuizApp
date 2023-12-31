package com.example.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.quizapp.QuestionBank;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import java.util.ArrayList;
import java.util.Collections;


public class MainActivity extends AppCompatActivity implements AlertDialogueFragment.saveButtonClickListener{
    Button trueButton, falseButton;


    ProgressBar quizProgress;

    ArrayList<Question> questions;

    QuestionBank questionBank;

    int questionIndex = 0;

    int quizScore = 0;

    ArrayList<Integer> attempts = new ArrayList<Integer>();

    FileStorage fs;


    FragmentManager fm = getSupportFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);
        quizProgress = findViewById(R.id.quizProgress);
        questionBank = new QuestionBank();


        fs = new FileStorage();


        questions = questionBank.getQuestionArrayList(MainActivity.this);

        shuffleArray();
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.frame);
    ;

        QuestionFragment questionFragment = QuestionFragment.newInstance(
                questions.get(questionIndex).getQuestion(),
                questions.get(questionIndex).getColor());



        if (fragment != null) {
            fm.beginTransaction().remove(fragment).commit();
        }
        getSupportFragmentManager().beginTransaction().add(R.id.frame,questionFragment).commit();



            trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questions.get(questionIndex).answer == Boolean.TRUE) {
                    quizScore++;
                    quizProgress.setProgress(questionIndex);

                    Toast.makeText(MainActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(MainActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
                    quizProgress.setProgress(questionIndex);

                }
                questionIndex++;
                if(questionIndex == questions.size() ) {
                    shuffleArray();
                    questionIndex = 0;
                    quizProgress.setProgress(questionIndex);

                    AlertDialogueFragment AF = AlertDialogueFragment.newInstance( getString( R.string.score ) +  quizScore  + getString( R.string.out ) + questions.size() );
                    AF.listener = MainActivity.this;
                    AF.show(getSupportFragmentManager(),"Alert");



                }
                QuestionFragment questionFragment = QuestionFragment.newInstance(questions.get(questionIndex).getQuestion(), questions.get(questionIndex).getColor());
                Fragment fragment = fm.findFragmentById(R.id.frame);
                if (fragment != null) {
                    fm.beginTransaction().remove(fragment).commit();
                }
                getSupportFragmentManager().beginTransaction().add(R.id.frame,questionFragment).commit();

            }


            });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questions.get(questionIndex).answer == Boolean.FALSE) {
                    quizScore++;
                    quizProgress.setProgress(questionIndex);

                    Toast.makeText(MainActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
                    quizProgress.setProgress(questionIndex);

                }
                questionIndex++;
                if (questionIndex == questions.size()) {
                    shuffleArray();

                    questionIndex = 0;
                    quizProgress.setProgress(questionIndex);
                    AlertDialogueFragment AF = AlertDialogueFragment.newInstance(getString( R.string.score ) + quizScore  +  getString( R.string.out ) + questions.size() );
                    AF.listener = MainActivity.this;
                    AF.show(getSupportFragmentManager(),"Alert");




                }
                QuestionFragment questionFragment = QuestionFragment.newInstance(questions.get(questionIndex).getQuestion(), questions.get(questionIndex).getColor());

                Fragment fragment = fm.findFragmentById(R.id.frame);
                if (fragment != null) {
                    fm.beginTransaction().remove(fragment).commit();
                }
                getSupportFragmentManager().beginTransaction().add(R.id.frame,questionFragment).commit();

            }

        });
    }
    void shuffleArray(){
        Collections.shuffle(questions);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.average:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);


                ArrayList<Integer> list = fs.getAllAttempts(this);
                if (list.isEmpty()){
                    builder.setMessage( getString( R.string.noattemt ));
                    builder.show();

                } else {
                    int sum = 0;
                    for (int lis : list) {
                        sum += lis;
                    }
                    int average = sum / list.size();


                    builder.setMessage(getString(R.string.your) + average + getString(R.string.out) + list.size() + getString(R.string.attempt));
                    builder.setPositiveButton(getString(R.string.ok), null);
                    builder.show();


                }

        case R.id.number:

            case R.id.reset:
                fs.deleteAllScores(this);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void saveNewAttempt(){
       /* attempts.add(quizScore);*/

        fs.writeScore(MainActivity.this, quizScore);
        quizScore = 0;

    }

}