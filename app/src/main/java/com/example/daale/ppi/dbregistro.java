package com.example.daale.ppi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by willo on 02/05/2016.
 */
public class dbregistro extends SQLiteOpenHelper {

    private static final String DATA_BASE_NAME="planosdb";
    private static final int DATA_VERSION=1;

    //Sentencia SQL Para crear una tabla
    String sqlCreate = "CREATE TABLE Usuarios(id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nombre TEXT NOT NULL," +
            " apellido TEXT NOT NULL," +
            //"fecha DATE NOT NULL, +" +
            "documento INTEGER NOT NULL," +
            "celular INTEGER NOT NULL," +
            "correo TEXT NOT NULL," +
            "usuario TEXT NOT NULL," +
            "contrasena TEXT NOT NULL)";

    public dbregistro(Context contexto) {
        super(contexto, DATA_BASE_NAME, null, DATA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Se ejecuta la sentencia SQL de creación de la tabla
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS Usuarios");
        //Se crea la nueva versión de la tabla
        db.execSQL(sqlCreate);
    }
}