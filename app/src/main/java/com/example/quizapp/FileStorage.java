package com.example.quizapp;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class FileStorage {
    String fileName = "quiz_result.txt";

    void writeScore(Context context, int Score){
        try {
            FileOutputStream fos = context.openFileOutput(fileName, Context.MODE_APPEND);
            fos.write(String.valueOf(Score + "\n").getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void deleteAllScores(Context context){
        try {
            FileOutputStream fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            fos.write("".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /* void updateAttemptFile(Context context, ArrayList<Integer> updateAttempts){

        deleteAllScores(context);
        try {
            FileOutputStream fos = context.openFileOutput(fileName, Context.MODE_APPEND);
            for (int i = 0 ; i< updateAttempts.size(); i++) {
                fos.write(updateAttempts.get(i).toString().getBytes());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    ArrayList<Integer> getAllAttempts(Context context) {
        ArrayList<Integer> list = new ArrayList<>(0);
        try {
            FileInputStream fis = context.openFileInput(fileName);
            InputStreamReader inputStreamReader =
                    new InputStreamReader(fis, StandardCharsets.UTF_8);
            try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
                String line = reader.readLine();

                while (line != null) {
                    list.add(new Integer(line));
                    line = reader.readLine();
                }
            }  catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

}


