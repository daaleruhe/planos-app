package com.example.daale.ppi;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class mreservas extends Fragment {

    private ListView listView;
    private TextView Resultado;
private Button btn;
    private View mr;
    private EditText ecodigo;

    SQLiteDatabase db;
    public mreservas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mr = inflater.inflate(R.layout.fragment_mreservas, container, false);




        /*Resultado = (TextView) mr.findViewById(R.id.txtResultado);
        btn = (Button) mr.findViewById(R.id.button2);
        ecodigo = (EditText) mr.findViewById(R.id.codigo);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String id = ecodigo.getText().toString();
                String[] campos = new String[]{"codigo", "nombre", "edad"};
                String[] args = new String[]{id};

                Cursor c = db.query("Usuarios", campos, "codigo=?", args, null, null, null);


                //Nos aseguramos de que existe al menos un registro
                if (c.moveToFirst()) {
                    Resultado.setText("");
                    //Recorremos el cursor hasta que no encontrar mas registros
                    do {
                        String codigo = c.getString(0);
                        String nombre = c.getString(1);
                        String apellido = c.getString(2);

                        Resultado.append(" " + codigo + " - " + nombre + " - " + apellido + "\n");
                    } while (c.moveToNext());
                }
            }
        });

*/

        return mr;
    }
/*
    protected void Ver_Tabla() {
        //PAra mostrar todos los campos de la tabla
        Cursor c = db.rawQuery("SELECT id,nombre,apellido FROM Usuarios", null);

        Resultado.setText("");
        if (c.moveToFirst())
            do {
                String codigo = c.getString(0);
                String nombre = c.getString(1);
                String apellido = c.getString(2);

                Resultado.append(" " + codigo + " -- " + nombre + " -- " + apellido + "\n");

            } while (c.moveToNext());*/

}
