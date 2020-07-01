package com.example.drfind.Vista.paciente;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.drfind.R;

public class loginpac extends AppCompatActivity implements View.OnClickListener {
    Button loginpaciente, registropaciente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpac);
        loginpaciente=(Button)findViewById(R.id.btnloginpaciente);
        loginpaciente.setOnClickListener(this);
        registropaciente=(Button)findViewById(R.id.btnregispaciente);
        registropaciente.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnloginpaciente:
                Intent i = new Intent(this, menupaciente.class);
                startActivity(i);
                break;
            case R.id.btnregispaciente:
                Intent o = new Intent(this, regispaciente.class);
                startActivity(o);
                break;
        }
    }
}
