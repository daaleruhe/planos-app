package com.example.daale.ppi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.daale.ppi.R;

public class Principal_Ad extends AppCompatActivity {

    Button iniciarAmdin, crearAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal__ad);

        iniciarAmdin = (Button)findViewById(R.id.btnIniciarAdmin);
        crearAdmin = (Button)findViewById(R.id.btnCrear_cuenta);

        Toast.makeText(getApplicationContext(), "Administrador", Toast.LENGTH_SHORT).show();

        /*iniciarAmdin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

        /*crearAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
    }
}
