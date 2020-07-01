package com.example.drfind.Vista.paciente;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.drfind.Controlador.Pacientes;
import com.example.drfind.R;

import java.util.Calendar;
import java.util.Date;

public class regispaciente extends AppCompatActivity implements View.OnClickListener {
    Button registropaciente, cancelarregistropaciente, fechanaci;
    EditText nombrepaciente,apapaciente,amapaciente,usuapaciente,contrapaciente,emailpaciente,direccionpaciente,telefopaciente,fechanacimientopaciente;
    TextView resultadopac;
    Calendar c= Calendar.getInstance();
    int mdia=c.get(Calendar.DAY_OF_MONTH);
    int mmes=c.get(Calendar.MONTH);
    int maño=c.get(Calendar.YEAR);

    Calendar C=Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regispaciente);
        registropaciente=(Button)findViewById(R.id.btnregistrarpaciente);
        cancelarregistropaciente=(Button)findViewById(R.id.btncanregispaciente);
        fechanaci=(Button)findViewById(R.id.btnfechapaciente);
        registropaciente.setOnClickListener(this);
        cancelarregistropaciente.setOnClickListener(this);
        fechanaci.setOnClickListener(this);
        usuapaciente=(EditText)findViewById(R.id.edtusuapac);
        contrapaciente=(EditText)findViewById(R.id.edtcontrapac);
        nombrepaciente=(EditText)findViewById(R.id.edtnompac);
        apapaciente=(EditText)findViewById(R.id.edtappac);
        amapaciente=(EditText)findViewById(R.id.edtampac);
        direccionpaciente=(EditText)findViewById(R.id.edtdireccionpac);
        emailpaciente=(EditText)findViewById(R.id.edtemailpac);
        telefopaciente=(EditText)findViewById(R.id.edttelefonopac);
        fechanacimientopaciente=(EditText)findViewById(R.id.edtnacimientopac);
        fechanacimientopaciente.setEnabled(false);
        resultadopac=(TextView)findViewById(R.id.txtresultadopaciente);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnregistrarpaciente:
                if (usuapaciente.getText().toString().isEmpty() || contrapaciente.getText().toString().isEmpty() ||
                        nombrepaciente.getText().toString().isEmpty() || apapaciente.getText().toString().isEmpty() ||
                        amapaciente.getText().toString().isEmpty() || emailpaciente.getText().toString().isEmpty() ||
                        direccionpaciente.getText().toString().isEmpty() || telefopaciente.getText().toString().isEmpty() ||
                        fechanacimientopaciente.getText().toString().isEmpty()) {
                    resultadopac.setText("uno o mas campos estan vacios");
                } else {
                    Intent i = new Intent(this, loginpac.class);
                    startActivity(i);
                    Pacientes agrepac=new Pacientes();
                    agrepac.agregarpaciente(usuapaciente.getText().toString(),contrapaciente.getText().toString(),nombrepaciente.getText().toString(),
                            apapaciente.getText().toString(),amapaciente.getText().toString(),direccionpaciente.getText().toString(),
                            emailpaciente.getText().toString(),Integer.parseInt(telefopaciente.getText().toString()), fechanacimientopaciente.getText().toString());
                }
                break;

            case R.id.btncanregispaciente:
                Intent j = new Intent(this, loginpac.class);
                startActivity(j);
                break;

            case R.id.btnfechapaciente:

                DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        int mesActual = month + 1;
                        String diaFormateado = (dayOfMonth < 10)? "0" + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                        String mesFormateado = (mesActual < 10)? "0" + String.valueOf(mesActual):String.valueOf(mesActual);
                        fechanacimientopaciente.setText(diaFormateado + "/" + mesFormateado +"/"+ year);
                    }
                } ,mdia,mmes,maño);
                datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
                datePickerDialog.show();
                break;
        }
    }

}
