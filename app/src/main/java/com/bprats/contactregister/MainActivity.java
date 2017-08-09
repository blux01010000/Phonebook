package com.bprats.contactregister;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    private static final String TAG = "MainActivity";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    private Button next;
    private EditText name, tel, email, descripcion;
    private TextView date;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next = (Button) findViewById(R.id.btnNext);
        date = (TextView) findViewById(R.id.tvDate);
        name = (EditText) findViewById(R.id.etName);
        tel = (EditText) findViewById(R.id.etTel);
        email = (EditText) findViewById(R.id.etEmail);
        descripcion = (EditText) findViewById(R.id.etDescrip);

        next.setOnClickListener(this);

        mDisplayDate = (TextView) findViewById(R.id.tvDate);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {



                Calendar cal = Calendar.getInstance();
                int day = cal.get(Calendar.DAY_OF_MONTH);
                int month = cal.get(Calendar.MONTH);
                int year = cal.get(Calendar.YEAR);

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_Material_Dialog, mDateSetListener, day, month, year);
                dialog.getWindow();
                dialog.show();


            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: dd/mm/yyyy: " + day + "/" + month + "/" + year);

                String date = day + "/" + month + "/" + year;
                mDisplayDate.setText(date);
            }
        };

    }


    @Override
    public void onClick(View view) {
        Intent pasarDatos;

        pasarDatos = new Intent(MainActivity.this, dataContactActivity.class);
        String nombre = name.getText().toString();
        String telefono = tel.getText().toString();
        String mail = email.getText().toString();
        String descripContact = descripcion.getText().toString();
        String fecha = date.getText().toString();

        pasarDatos.putExtra("Nombre", nombre);
        pasarDatos.putExtra("Fecha de Nacimiento", fecha);
        pasarDatos.putExtra("Telefono", telefono);
        pasarDatos.putExtra("Email", mail);
        pasarDatos.putExtra("Descripcion", descripContact);

        startActivity(pasarDatos);
    }
}
