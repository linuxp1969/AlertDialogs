package com.linuxp.alertdialogs;

import static com.linuxp.alertdialogs.AlertDialogs.mostraAlertEditText;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvText = findViewById(R.id.textView);
    }

    public void dialogCall(View view) {

        mostraAlertEditText("Inserisci un valore", "Inserisci il teso che vuoi visualizzare", "ghost",
                "", R.drawable.ic_question, MainActivity.this, new CallBackDialog() {
                    @Override
                    public void onSuccesso(String campo) {
                        tvText.setText(campo);
                    }
                });

    }
}
