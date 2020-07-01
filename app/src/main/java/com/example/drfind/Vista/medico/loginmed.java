package com.example.drfind.Vista.medico;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


import com.example.drfind.R;

public class loginmed extends AppCompatActivity implements View.OnClickListener {
    Button loginmedico, registromedico;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginmed);
        loginmedico=(Button)findViewById(R.id.btnloginmed);
        registromedico=(Button)findViewById(R.id.btnregismed);
        loginmedico.setOnClickListener(this);
        registromedico.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnloginmed:
                Intent i = new Intent(this, menumedico.class);
                startActivity(i);
                break;
            case R.id.btnregismed:
                Intent j = new Intent(this, regismedico.class);
                startActivity(j);
                break;
        }
    }
}
