package com.example.appbancodedadosmeusclientes.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.appbancodedadosmeusclientes.database.AppDataBase;
import com.example.appbancodedadosmeusclientes.model.Cliente;
import com.example.appbancodedadosmeusclientes.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}