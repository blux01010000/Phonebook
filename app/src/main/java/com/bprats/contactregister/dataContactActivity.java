package com.bprats.contactregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class dataContactActivity extends AppCompatActivity  {

    TextView tvName, tvFecha, tvTelefono, tvEmail, tvDescripcionContacto;
    Button regresar;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_contact);

        tvName = (TextView) findViewById(R.id.tvNombre);
        tvFecha = (TextView) findViewById(R.id.tvFN);
        tvTelefono = (TextView) findViewById(R.id.tvPhone);
        tvEmail = (TextView) findViewById(R.id.tvMail);
        tvDescripcionContacto = (TextView) findViewById(R.id.tvDescripcion);


        regresar = (Button) findViewById(R.id.btnConfirmar);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });



        Intent recibirDatos = getIntent();
        Bundle extras = recibirDatos.getExtras();
        if (extras != null) {
            String datoNombre = (String) extras.get("Nombre");
            String datoFecha = (String) extras.get("Fecha de Nacimiento");
            String datoTelefono = (String) extras.get("Telefono");
            String datoEmail = (String) extras.get("Email");
            String datoDescripcion = (String) extras.get("Descripcion");

            tvName.setText(datoNombre);
            tvFecha.setText(datoFecha);
            tvTelefono.setText(datoTelefono);
            tvEmail.setText(datoEmail);
            tvDescripcionContacto.setText(datoDescripcion);
        }

    }

}

