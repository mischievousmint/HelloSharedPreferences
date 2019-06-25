package com.example.hellosharedpreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvHello;
    EditText etName;
    Button btnSave;
    String recoveredName;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHello = findViewById(R.id.tvHello);
        etName = findViewById(R.id.etName);
        btnSave = findViewById(R.id.btnSave);
        name = "you";

        //Pasamos el contexto
        MySharedPreferences.init(getApplicationContext());

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = etName.getText().toString();
                MySharedPreferences.saveName(name); //Guardamos en la BBDD
                recoveredName = MySharedPreferences.loadName(); //Cargamos el texto
                tvHello.setText("hello " + recoveredName);
            }
        });
        recoveredName = MySharedPreferences.loadName(); //Cargamos el texto
        tvHello.setText("hello " + recoveredName);
    }

}
