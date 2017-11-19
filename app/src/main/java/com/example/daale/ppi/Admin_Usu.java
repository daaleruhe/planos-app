package com.example.daale.ppi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin_Usu extends AppCompatActivity {

    Button btnAdmin,btnUsu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__usu);



        btnUsu = (Button)findViewById(R.id.btnUsu);
        btnAdmin    = (Button)findViewById(R.id.btnAdmin);


        btnUsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(),principal.class);
                startActivity(intent);
            }
        });

        btnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(),Principal_Ad.class);
                startActivity(intent);
            }
        });
    }
}
