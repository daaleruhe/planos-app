package com.example.daale.ppi;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


public class registro extends AppCompatActivity {

    private static final String TAG = "registro";
    private TextView mDisplayDate_x;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private Button btnCrear_cuenta;
    private EditText eNombre, eApellidos, eDucumento, eCelular,eCorreo, eUsuario, eContraseña;
    private TextView tvFecha, Resultado;

    private String S_nombre = "", S_Apellido = "",S_Fecha = "", S_Documento = "", S_Celular = "",S_correo, S_Usuario = "", S_Contraseña = "";

    SQLiteDatabase db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mDisplayDate_x = (TextView) findViewById(R.id.tvFecha_x);

        mDisplayDate_x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        registro.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                mDisplayDate_x.setText(date);
            }
        };

        ////////////////////////////////////////////////////////////////////////////////////////////

        btnCrear_cuenta = (Button) findViewById(R.id.btnCrear_cuenta);

        eNombre = (EditText) findViewById(R.id.eNombre);
        eApellidos = (EditText) findViewById(R.id.eApellidos);
        eDucumento  = (EditText) findViewById(R.id.eDocumento);
        eCelular = (EditText) findViewById(R.id.eCelular);
        eCorreo =  (EditText) findViewById(R.id.eCorreo);
        eUsuario = (EditText) findViewById(R.id.eUsuario);
        eContraseña = (EditText) findViewById(R.id.eContraseña);

        Resultado = (TextView) findViewById(R.id.txtResultado);

        S_nombre = eNombre.getText().toString();
        S_Apellido = eApellidos.getText().toString();
        S_Fecha = mDisplayDate_x.getText().toString();
        S_Documento = eDucumento.getText().toString();
        // int s_documento = Integer.parseInt(S_Documento);
        S_correo = eCorreo.getText().toString();
        S_Celular = eCelular.getText().toString();
        S_Usuario = eUsuario.getText().toString();
        S_Contraseña = eContraseña.getText().toString();


        dbregistro usuario = new dbregistro(this);
        db = usuario.getWritableDatabase();

        if (db != null) {

            for (int i = 1; i <= 2; i++) {
                String nombre = "nombre"+i;
                String apellido = "apellido"+i;
                int documento = i;
                int celular = i;
                String correo = "correo" + i;
                String n_usuario = "Usuario" + i;
                String contrasena = "contrasena" + i;
                db.execSQL("INSERT INTO Usuarios(nombre,apellido, documento, celular, correo, usuario, contrasena)"
                        + "VALUES('" + nombre + "', '" + apellido + "', " + documento + ", " + celular + ",'" + correo + "' , '" + n_usuario + "','" + contrasena + "' )");
            }
        }

        Ver_Tabla();


        btnCrear_cuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*String nombre=eNombre.getText().toString();
                String apellido=eNombre.getText().toString();

                ContentValues nuevoRegistro = new ContentValues();
                nuevoRegistro.put("nombre", nombre);
                nuevoRegistro.put("apellido", apellido);

                db.insert("Usuarios", null, nuevoRegistro);
                Ver_Tabla();*/

                Campos_vacios();
            }
        });
    }
    private void mostrarMensaje(String s) {
        Toast.makeText(registro.this, s, Toast.LENGTH_SHORT).show();

    }
    private void Campos_vacios () {

        S_nombre = eNombre.getText().toString();
        S_Apellido = eApellidos.getText().toString();
        S_Documento = eDucumento.getText().toString();
        S_Celular = eCelular.getText().toString();
        S_correo = eCorreo.getText().toString();
        S_Usuario = eUsuario.getText().toString();
        S_Contraseña = eContraseña.getText().toString();

        if(S_nombre.isEmpty() && S_Apellido.isEmpty() && S_Fecha.isEmpty() && S_Documento.isEmpty() && S_Celular.isEmpty() && S_Usuario.isEmpty() && S_Contraseña.isEmpty() ){
            mostrarMensaje("Por favor ingrese todos los datos");
        }else if(S_nombre.isEmpty()){
            mostrarMensaje("Por favor ingrese el nombre.");
        }else if (S_Apellido.isEmpty()){
            mostrarMensaje("Por favor ingrese el apellido.");/*
        }else if (S_Fecha.isEmpty()){
            mostrarMensaje("Por favor selecione la fecha.");
        }else if (S_Documento.isEmpty()){
            mostrarMensaje("Por favor ingrese su documento de identidad.");
        }else if (S_Celular.isEmpty()){
            mostrarMensaje("Por favor ingrese su telefono celular");
        }else if (S_correo.isEmpty()){
            mostrarMensaje("Por favor ingrese su correo");
        }else if (S_Usuario.isEmpty()){
            mostrarMensaje("Por favor ingrese su nombre de usuario");
        }else if (S_Contraseña.isEmpty()){
            mostrarMensaje("Por favor ingrese una contraseña.");*/
        }else{
            final Dialog confirmar = new Dialog(registro.this);

            confirmar.requestWindowFeature(Window.FEATURE_NO_TITLE);

            confirmar.setContentView(R.layout.aceptar_cancelar);

            TextView titulo = (TextView) confirmar.findViewById(R.id.textView12);
            titulo.setText("Confirmación de registro de"+ "\n" + S_nombre);

            TextView titulo1 = (TextView) confirmar.findViewById(R.id.textView13);
            titulo1.setText("¡Que bien! \nEstas a punto de registrarte " +
                    "\nen plano's.app " +
                    "\n¿Desea registrarte?");

            Button aceptar = (Button) confirmar.findViewById(R.id.button8);
            aceptar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String nombre=eNombre.getText().toString();
                    String apellido=eApellidos.getText().toString();
                    String documento = eDucumento.getText().toString();

                    ContentValues nuevoRegistro = new ContentValues();
                    nuevoRegistro.put("nombre", nombre);
                    nuevoRegistro.put("apellido", apellido);
                    nuevoRegistro.put("documento", documento);
                    //nuevoRegistro.put("fecha", fecha);

                    db.insert("Usuarios", null, nuevoRegistro);

                    Ver_Tabla();

                    confirmar.dismiss();
                    /*startActivity(new Intent(registro.this, regi.class));
                    registro.this.finish();*/
                }
            });
            Button cancelar = (Button) confirmar.findViewById(R.id.button9);
            cancelar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    confirmar.dismiss();
                }
            });

            confirmar.show();

        }
    }

    protected void Ver_Tabla() {
        //PAra mostrar todos los campos de la tabla
        Cursor c = db.rawQuery("SELECT id, nombre, apellido, documento, celular, correo, usuario, contrasena FROM Usuarios", null);

        Resultado.setText("");
        if (c.moveToFirst())
            do {
                String codigo = c.getString(0);
                String nombre = c.getString(1);
                String apellido = c.getString(2);
                int documento = c.getInt(3);
                int celular = c.getInt(4);
                String correo = c.getString(5);
                String Usuario = c.getString(6);
                String contraseña = c.getString(7);
                Resultado.append(" " + codigo + "-" + nombre + "-" + apellido + "-" + documento + "-" + celular +"-" + correo +"-" + Usuario +"-" + contraseña +"\n");

            }while (c.moveToNext());
    }
}

