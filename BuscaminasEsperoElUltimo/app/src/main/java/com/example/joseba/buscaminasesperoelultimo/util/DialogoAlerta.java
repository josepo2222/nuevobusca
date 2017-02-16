package com.example.joseba.buscaminasesperoelultimo.util;

/**
 * Created by Joseba on 16/02/2017.
 */
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

public class DialogoAlerta extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        builder.setMessage("Por el momento se juega igual que el buscaaminas clasico.")
                .setTitle("Instrucciones")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        return builder.create();
    }
//http://www.sgoliver.net/blog/notificaciones-en-android-iii-dialogos/
//    public void show(FragmentManager fragmentManager, String tagInstrucciones) {
 //   }
}
