package com.example.drfind.Vista.medico;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.drfind.R;
import com.example.drfind.modelo.conexion;

import java.sql.ResultSet;
import java.sql.Statement;

public class loginmed extends AppCompatActivity implements View.OnClickListener {
    Button loginmedico, registromedico;
    EditText usuariomed,passmed;
    TextView resulmed;
    CheckBox mantendamed;
    private SharedPreferences preferencesmed;
    private SharedPreferences.Editor medceditor;
    String username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginmed);
        loginmedico=(Button)findViewById(R.id.btnloginmed);
        resulmed=(TextView)findViewById(R.id.resulmedlog);
        registromedico=(Button)findViewById(R.id.btnregismed);
        loginmedico.setOnClickListener(this);
        registromedico.setOnClickListener(this);
        usuariomed=(EditText) findViewById(R.id.edtusuariomed);
        passmed=(EditText) findViewById(R.id.edtpassmedico);
        mantendamed=(CheckBox)findViewById(R.id.checkBoxusermed);
        preferencesmed= PreferenceManager.getDefaultSharedPreferences(this);
        medceditor=preferencesmed.edit();
        SharedPreference();
    }

    private void SharedPreference() {
        String checkboxmed= preferencesmed.getString(getString(R.string.checkBoxusermed),"False");
        String namemed=preferencesmed.getString(getString(R.string.edtusuariomed),"");
        String passwordmed=preferencesmed.getString(getString(R.string.edtpassmed),"");
        usuariomed.setText(namemed);
        passmed.setText(passwordmed);
        if(checkboxmed.equals("True")){
            mantendamed.setChecked(true);
        }else {
            mantendamed.setChecked(false);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnloginmed:
                if(usuariomed.getText().toString().isEmpty()||passmed.getText().toString().isEmpty()){
                    resulmed.setText("uno o mas campos estan vacios");
                }else {
                    username=usuariomed.getText().toString();
                    password=passmed.getText().toString();
                    CheckLogin checkLogin=new CheckLogin();
                    checkLogin.execute("");

                }
                break;
            case R.id.btnregismed:
                Intent j = new Intent(this, regismedico.class);
                startActivity(j);
                break;
        }
    }
    public class CheckLogin extends AsyncTask<String,String,String>{
        String z="";
        Boolean isSuccess=false;

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(loginmed.this,s,Toast.LENGTH_SHORT).show();
            if(isSuccess){
                Toast.makeText(loginmed.this,"Inicio correcto",Toast.LENGTH_LONG).show();
            }
        }

        @Override
        protected String doInBackground(String... strings) {
            if(username.trim().equals("")||password.trim().equals(""))
                z="Ingrese usuario y contraseña";
            else {
                conexion db=new conexion();
                try {
                    Statement stm=db.conexionbd().createStatement();
                    ResultSet resultSet=stm.executeQuery("SELECT * FROM medico where usuariomed= '"+username.toString()+"'and contraseña='"+password.toString()+"'");
                    if(resultSet.next()){
                        z="Inicio exitoso";
                        isSuccess=true;
                        Intent f = new Intent(loginmed.this, menumedico.class);
                        startActivity(f);
                    }else {
                        z="Inicio invalido";
                        isSuccess=false;
                        Intent m = new Intent(loginmed.this, loginmed.class);
                        startActivity(m);
                    }
                }catch (Exception e){
                    isSuccess=false;
                    z=e.getMessage();
                }
            }return z;
        }
    }
}
