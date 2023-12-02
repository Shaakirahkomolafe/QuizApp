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
        void saveNewAttempt();
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
                .setPositiveButton(getString(R.string.save), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.saveNewAttempt();
                    }
                })
                .setNegativeButton(getString(R.string.ok),null).create();


    }
}
