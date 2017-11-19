package com.example.daale.ppi;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class reservas extends Fragment {
    String estado = "disponible", estado2, n_mesa;
    int nmesa = 0;
    private Button consulta, btnreserva_m;
    private ImageButton img1, img2, img3, img4, img5, img6, img7, img8,img9;
    //private EditText eMesa;
    private TextView eHora,efecha,eMesa;
    private Spinner spiner;
    private String S_Hora, S_FechaR, S_Npersona, S_Nmesa;
    private double n_person;

    private static final String TAG = "reserva";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    private static final String TAGE = "Hora";
    private TextView mDisplayTime;
    private TimePickerDialog.OnTimeSetListener mTimesetListener;
    private View fecha;

    public reservas() {
        // Required empty public constructor
    }

    final String[] lista = {"0", "8", "4", "3", "2"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fecha = inflater.inflate(R.layout.fragment_reservas, container, false);

        mDisplayDate = (TextView) fecha.findViewById(R.id.tvDate);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        reservas.this.getActivity(),
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
                mDisplayDate.setText(date);
            }
        };


        mDisplayTime = (TextView) fecha.findViewById(R.id.tvTime);
        mDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int hour = cal.get(Calendar.HOUR_OF_DAY);
                int minute = cal.get(Calendar.MINUTE);

                TimePickerDialog dialog = new TimePickerDialog(reservas.this.getActivity(), mTimesetListener, hour, minute, true);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mTimesetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                Log.d(TAGE, "onTimeSet: H/M " + hour + ":" + minute);

                String time = hour + ":" + minute;
                mDisplayTime.setText(time);
            }
        };

        ////////////////////////////////

        consulta = (Button) fecha.findViewById(R.id.btnconsul);
        consulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comproba_estado();
            }
        });


        /////////////////////////
        img1 = (ImageButton) fecha.findViewById(R.id.mesa_1);
        img2 = (ImageButton) fecha.findViewById(R.id.mesa_2);
        img3 = (ImageButton) fecha.findViewById(R.id.mesa_3);
        img4 = (ImageButton) fecha.findViewById(R.id.mesa_4);
        img5 = (ImageButton) fecha.findViewById(R.id.mesa_5);
        img6 = (ImageButton) fecha.findViewById(R.id.mesa_6);
        img7 = (ImageButton) fecha.findViewById(R.id.mesa_7);
        img8 = (ImageButton) fecha.findViewById(R.id.mesa_8);
        img9 = (ImageButton) fecha.findViewById(R.id.mesa_9);

        eMesa = (TextView) fecha.findViewById(R.id.N_mesa);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eMesa.setText("1");
                n_mesa = eMesa.getText().toString();
                btn_reservar(n_mesa);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eMesa.setText("2");
                n_mesa = eMesa.getText().toString();
                btn_reservar(n_mesa);
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eMesa.setText("3");
                n_mesa = eMesa.getText().toString();
                btn_reservar(n_mesa);
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eMesa.setText("4");
                n_mesa = eMesa.getText().toString();
                btn_reservar(n_mesa);
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eMesa.setText("5");
                n_mesa = eMesa.getText().toString();
                btn_reservar(n_mesa);
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eMesa.setText("6");
                n_mesa = eMesa.getText().toString();
                btn_reservar(n_mesa);
            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eMesa.setText("7");
                n_mesa = eMesa.getText().toString();
                btn_reservar(n_mesa);
            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eMesa.setText("8");
                n_mesa = eMesa.getText().toString();
                btn_reservar(n_mesa);
            }
        });
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eMesa.setText("9");
                n_mesa = eMesa.getText().toString();
                btn_reservar(n_mesa);
            }
        });

        spiner = (Spinner) fecha.findViewById(R.id.editText);

        final ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(reservas.this.getActivity(),
                        android.R.layout.simple_spinner_item, lista);
        spiner.setAdapter(adapter);

        spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
                String selected = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(adapterView.getContext(), selected, Toast.LENGTH_SHORT).show();
                n_person = Double.parseDouble(selected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        btnreserva_m = (Button) fecha.findViewById(R.id.btnreserva_m);

        n_mesa = eMesa.getText().toString();
        btn_reservar(n_mesa);

        efecha = (TextView) fecha.findViewById(R.id.tvDate);
        eHora = (TextView) fecha.findViewById(R.id.tvTime);


        btnreserva_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Campos_vacios();
            }
        });

        return fecha;
    }

    public void comproba_estado() {
        if (estado == "disponible" & n_person >= 2 & n_person <= 3) {
            final ImageView imagen_Appbar = (ImageView) fecha.findViewById(R.id.mesa_3);
            imagen_Appbar.setImageResource(R.drawable.mesas_3_v);
            img3.setEnabled(true);
        } else {
            final ImageView imagen_Appbar = (ImageView) fecha.findViewById(R.id.mesa_3);
            imagen_Appbar.setImageResource(R.drawable.mesas_3_r);
            img3.setEnabled(false);
        }

        if (estado == "disponible" & n_person >= 2 & n_person <= 3) {
            final ImageView imagen_Appbar = (ImageView) fecha.findViewById(R.id.mesa_4);
            imagen_Appbar.setImageResource(R.drawable.mesas_4_v);
            img4.setEnabled(true);
        } else {
            final ImageView imagen_Appbar = (ImageView) fecha.findViewById(R.id.mesa_4);
            imagen_Appbar.setImageResource(R.drawable.mesas_4_r);
            img4.setEnabled(false);
        }
        if ((estado == "disponible" & n_person >= 2 & n_person <= 3)) {
            final ImageView imagen_Appbar = (ImageView) fecha.findViewById(R.id.mesa_5);
            imagen_Appbar.setImageResource(R.drawable.mesas_5_v);
            img5.setEnabled(true);
        } else {
            final ImageView imagen_Appbar = (ImageView) fecha.findViewById(R.id.mesa_5);
            imagen_Appbar.setImageResource(R.drawable.mesas_5_r);
            img5.setEnabled(false);
        }
        if ((estado == "disponible" & n_person >= 2 & n_person <= 4)) {
            final ImageView imagen_Appbar = (ImageView) fecha.findViewById(R.id.mesa_6);
            imagen_Appbar.setImageResource(R.drawable.mesas_6_v);
            img6.setEnabled(true);
        } else {
            final ImageView imagen_Appbar = (ImageView) fecha.findViewById(R.id.mesa_6);
            imagen_Appbar.setImageResource(R.drawable.mesas_6_r);
            img6.setEnabled(false);
        }
        if ((estado == "disponible" & n_person >= 2 & n_person <= 4)) {
            final ImageView imagen_Appbar = (ImageView) fecha.findViewById(R.id.mesa_7);
            imagen_Appbar.setImageResource(R.drawable.mesas_7_v);
            img7.setEnabled(true);
        } else {
            final ImageView imagen_Appbar = (ImageView) fecha.findViewById(R.id.mesa_7);
            imagen_Appbar.setImageResource(R.drawable.mesas_7_r);
            img7.setEnabled(false);
        }
        if ((estado == "disponible" & n_person == 2 )) {
            final ImageView imagen_Appbar = (ImageView) fecha.findViewById(R.id.mesa_1);
            imagen_Appbar.setImageResource(R.drawable.mesas_1_v);
            img1.setEnabled(true);
        } else {
            final ImageView imagen_Appbar = (ImageView) fecha.findViewById(R.id.mesa_1);
            imagen_Appbar.setImageResource(R.drawable.mesas_1_r);
            img1.setEnabled(false);
        }
        if ((estado == "disponible" & n_person >= 2 & n_person <= 4)) {
            final ImageView imagen_Appbar = (ImageView) fecha.findViewById(R.id.mesa_8);
            imagen_Appbar.setImageResource(R.drawable.mesas_8_v);
            img8.setEnabled(true);
        } else {
            final ImageView imagen_Appbar = (ImageView) fecha.findViewById(R.id.mesa_8);
            imagen_Appbar.setImageResource(R.drawable.mesas_8_r);
            img8.setEnabled(false);
        }
        if ((estado == "disponible" & n_person == 2 )) {
            final ImageView imagen_Appbar = (ImageView) fecha.findViewById(R.id.mesa_2);
            imagen_Appbar.setImageResource(R.drawable.mesas_2_v);
            img2.setEnabled(true);
        } else {
            final ImageView imagen_Appbar = (ImageView) fecha.findViewById(R.id.mesa_2);
            imagen_Appbar.setImageResource(R.drawable.mesas_2_r);
            img2.setEnabled(false);
        }

        if ((estado == "disponible" & n_person >4 & n_person <= 8)) {
            final ImageView imagen_Appbar = (ImageView) fecha.findViewById(R.id.mesa_9);
            imagen_Appbar.setImageResource(R.drawable.mesas_9_v);
            img9.setEnabled(true);
        } else {
            final ImageView imagen_Appbar = (ImageView) fecha.findViewById(R.id.mesa_9);
            imagen_Appbar.setImageResource(R.drawable.mesas_9_r);
            img9.setEnabled(false);
        }

        }



    public void btn_reservar(String mesa){
        if (mesa != null && !mesa.isEmpty()) {
            int n = 0;
            try {
                n=Integer.parseInt(mesa);
            }catch (NumberFormatException e){
                System.out.println("not a number");
            }

            if (n < 10 && n > 0) {
                btnreserva_m.setVisibility(View.VISIBLE);
            }
        }
    }

    private void Campos_vacios () {

        S_FechaR = efecha.getText().toString();
        S_Hora = eHora.getText().toString();
        S_Npersona = String.valueOf(n_person);
        S_Nmesa = String.valueOf(n_mesa);


        if(S_FechaR.isEmpty() && S_Hora.isEmpty() && S_Npersona.isEmpty() && S_Nmesa.isEmpty() ){
            mostrarMensaje("Por favor ingrese todos los datos.");
        }else if(S_FechaR.isEmpty()){
            mostrarMensaje("Por favor selecione la fecha.");
        }else if (S_Hora.isEmpty()){
            mostrarMensaje("Por favor selecione la hora.");
        }else if (S_Npersona.isEmpty() || n_person == 0){
            mostrarMensaje("Por favor selecione el numero de personas.");
        }else if (S_Nmesa.isEmpty()){
            mostrarMensaje("Por favor ingrese su documento de identidad.");
        }else{


            final Dialog confirmar = new Dialog(reservas.this.getActivity());

            confirmar.requestWindowFeature(Window.FEATURE_NO_TITLE);

            confirmar.setContentView(R.layout.aceptar_cancelar);

            TextView titulo = (TextView) confirmar.findViewById(R.id.textView12);
            titulo.setText("Confirmación de reserva");

            TextView titulo1 = (TextView) confirmar.findViewById(R.id.textView13);
            titulo1.setText("Estas a punto reservar " +
                    "\nla mesa " + S_Nmesa +
                    "\n¿Desea registrarla?");

            Button aceptar = (Button) confirmar.findViewById(R.id.button8);
            aceptar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    /*DB_registro registro = new DB_registro(registro.this);
                    if (registro.insertarRegistro(S_Documento,S_nombre,S_Apellido,S_Fecha,S_Celular,S_correo, S_Usuario,S_Contraseña)!= 0)
                        mostrarMensaje("Regitro realizado exitosamente.");
                    else
                        mostrarMensaje("Plano´s lo lamenta\n" +
                                "pero  algo salio mal");*/
                    mostrarMensaje("Reserva realizada exitosamente.");
                    confirmar.dismiss();
                    startActivity(new Intent(reservas.this.getActivity(), MainActivity.class));
                    reservas.this.getActivity().finish();

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

    private void mostrarMensaje(String s) {
        Toast.makeText(getActivity(),s,Toast.LENGTH_SHORT).show();
    }
}