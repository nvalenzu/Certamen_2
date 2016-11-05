package com.multimedios.proyecto.certamen2_2016;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.multimedios.proyecto.certamen2_2016.Presenters.GitSearch;

public class MainActivity extends AppCompatActivity {

    private EditText txtUser;
    private Button btnBuscar;
    private GitSearch mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtenemos una referencia a los controles de la interfaz
        txtUser = (EditText)findViewById(R.id.editText);
        btnBuscar = (Button)findViewById(R.id.button_buscar);

        mPresenter = new GitSearch(this);

    }




}
