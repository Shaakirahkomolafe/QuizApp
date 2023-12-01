package com.example.quizapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

public class AlertDialogueFragment extends DialogFragment {
  public interface saveButtonClickListener {
        void saveNewAttempt(Integer quizScore);
    }

    saveButtonClickListener listener;


    static  String msg;
    public static AlertDialogueFragment newInstance(String m){
            msg = m;
        return new AlertDialogueFragment();
    }

    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new AlertDialog.Builder(requireContext())
                .setMessage(msg)
                .setTitle("Result")
                .setPositiveButton(getString(R.string.save), (DialogInterface.OnClickListener) listener)
                .setNegativeButton(getString(R.string.ok),null).create();


    }
}
