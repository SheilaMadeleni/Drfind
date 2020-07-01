package com.example.drfind.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.drfind.R;
import com.example.drfind.Vista.medico.loginmed;
import com.example.drfind.Vista.paciente.loginpac;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button medicosi, pacientesi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        medicosi= (Button)findViewById(R.id.btnmedico);
        pacientesi= (Button)findViewById(R.id.btnpaciente);
        medicosi.setOnClickListener(this);
        pacientesi.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnmedico:
                Intent i = new Intent(this, loginmed.class);
                startActivity(i);
                break;
            case R.id.btnpaciente:
                Intent j = new Intent(this, loginpac.class);
                startActivity(j);
                break;
        }
    }
}
