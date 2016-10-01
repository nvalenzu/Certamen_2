package com.multimedios.proyecto.certamen2_2016;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txtUser;
    private Button btnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtenemos una referencia a los controles de la interfaz
        txtUser = (EditText)findViewById(R.id.editText);
        btnBuscar = (Button)findViewById(R.id.button_buscar);

        //Implementamos el evento click del botón
        btnBuscar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Creamos el Intent
                Intent intent = new Intent(MainActivity.this, ListFragment.class);

                //Creamos la información a pasar entre actividades
               // Bundle b = new Bundle();
                //b.putString("USER", txtUser.getText().toString());

                //Añadimos la información al intent
                intent.putExtra("USER", txtUser.getText().toString());

                //Iniciamos la nueva actividad
                startActivity(intent);



            }

        });
    }




}
