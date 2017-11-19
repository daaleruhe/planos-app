package com.example.daale.ppi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class principal extends AppCompatActivity {
    Button iniciarUsu, crearUsu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        iniciarUsu = (Button)findViewById(R.id.btnIniciarUsu);
        crearUsu = (Button)findViewById(R.id.btncrearUsu);

        Toast.makeText(getApplicationContext(), "Usuario", Toast.LENGTH_SHORT).show();

        iniciarUsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(),inicio_de_sesion_usu.class);
                startActivity(intent);
            }
        });

        crearUsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(),registro.class);
                startActivity(intent);
            }
        });
    }
}
