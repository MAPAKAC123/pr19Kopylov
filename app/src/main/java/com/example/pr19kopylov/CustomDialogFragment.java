package com.example.pr19kopylov;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.annotation.NonNull;

public class CustomDialogFragment extends DialogFragment {

    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        return builder
                .setTitle("Диалоговое окно")
                .setIcon(R.drawable.piiiinnenenene)
                .setView(R.layout.dialog)
                .setPositiveButton("OK", null)
                .setNegativeButton("Отмена", null)
                .create();
    }
}
