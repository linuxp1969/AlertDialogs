package com.linuxp.alertdialogs;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;

public class AlertDialogs {

    public static void mostraAlertEditText (String titolo, String messaggio, String campo, String hintmessaggio, int icona, Activity contesto, final CallBackDialog callbackDialog) {
        AlertDialog.Builder builder = new AlertDialog.Builder(contesto);
        LayoutInflater inflater = contesto.getLayoutInflater();
        View view = inflater.inflate(R.layout.alert_dialog, null);

        final EditText etCampo = view.findViewById(R.id.etCampo);
        etCampo.setText(campo);
        etCampo.setHint(hintmessaggio);
        builder.setView(view)
                .setTitle(titolo)
                .setMessage(messaggio)
                .setIcon(icona)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        callbackDialog.onSuccesso (etCampo.getText().toString());
                        dialogInterface.dismiss();
                    }
                });

        AlertDialog dialogo = builder.create();
        dialogo.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        dialogo.show();
    }
}
