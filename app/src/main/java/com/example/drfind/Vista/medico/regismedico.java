package com.example.drfind.Vista.medico;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.drfind.Controlador.Medicos;
import com.example.drfind.R;
import com.example.drfind.modelo.conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class regismedico extends AppCompatActivity implements View.OnClickListener {
Button registromedico, cancelarregistromedico,fechanacimed;
Spinner listespecialidad;
EditText nombremedico,apamedico,amamedico,usuamedico,contramedico,emailmedico,colegiamed,telefomed,fechanacimientomed;
TextView resultado;
ArrayList<Integer> listaespecialidades= new ArrayList<>();

    Calendar C=Calendar.getInstance();
    int mmesme=C.get(Calendar.MONTH);
    int mdiame=C.get(Calendar.DAY_OF_MONTH);
    int mañome=C.get(Calendar.YEAR);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regismedico);

        registromedico=(Button)findViewById(R.id.btnregistrarmedico);
        registromedico.setOnClickListener(this);
        cancelarregistromedico=(Button)findViewById(R.id.btncanregismedico);
        cancelarregistromedico.setOnClickListener(this);
        usuamedico=(EditText)findViewById(R.id.edtusuamed);
        contramedico=(EditText)findViewById(R.id.edtcontramed);
        nombremedico=(EditText)findViewById(R.id.edtnommed);
        apamedico=(EditText)findViewById(R.id.edtapmed);
        amamedico=(EditText)findViewById(R.id.edtammed);
        emailmedico=(EditText)findViewById(R.id.edtemailmed);
        colegiamed=(EditText)findViewById(R.id.edtcolegiamed);
        telefomed=(EditText)findViewById(R.id.edttelefonomed);
        fechanacimientomed=(EditText)findViewById(R.id.edtnacimed);
        resultado=(TextView)findViewById(R.id.txtresultado);
        listespecialidad=(Spinner)findViewById(R.id.spiespecialidad);
       fechanacimed=(Button)findViewById(R.id.btnfechamedico);
       fechanacimed.setOnClickListener(this);
        fechanacimientomed.setEnabled(false);

        lista();

    }
    public void lista(){
        conexion db=new conexion();
        listaespecialidades=new ArrayList<Integer>();
        try {
            PreparedStatement ed=db.conexionbd().prepareStatement("spinnerespecialidad");
            ResultSet ob=ed.executeQuery();

                while (ob.next()){
                    Integer nombre=ob.getInt("idespecialidad");
                    listaespecialidades.add(nombre);
                }
                Integer[] Array = listaespecialidades.toArray(new Integer[0]);
                ArrayAdapter adapter= new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaespecialidades);
                listespecialidad.setAdapter(adapter);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnregistrarmedico:
                if(usuamedico.getText().toString().isEmpty()||contramedico.getText().toString().isEmpty()||
                        nombremedico.getText().toString().isEmpty()||apamedico.getText().toString().isEmpty()||
                        amamedico.getText().toString().isEmpty()||emailmedico.getText().toString().isEmpty()||
                        colegiamed.getText().toString().isEmpty()||telefomed.getText().toString().isEmpty()||
                        fechanacimientomed.getText().toString().isEmpty()) {
                        resultado.setText("uno o mas campos estan vacios");
                }
                else {
                    Intent i = new Intent(this, loginmed.class);
                    startActivity(i);
                    Medicos agremed=new Medicos();
                    agremed.agregarmedico(usuamedico.getText().toString(),contramedico.getText().toString(),nombremedico.getText().toString(),
                            apamedico.getText().toString(),amamedico.getText().toString(),listespecialidad.getSelectedItem().toString(),
                            emailmedico.getText().toString(),Integer.parseInt(colegiamed.getText().toString()),Integer.parseInt(telefomed.getText().toString()),
                            fechanacimientomed.getText().toString());
                }
                break;

            case R.id.btncanregismedico:
                Intent j = new Intent(this, loginmed.class);
                startActivity(j);
                break;
            case R.id.btnfechamedico:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        int mesActual = month + 1;
                        String diaFormateado = (dayOfMonth < 10)? "0" + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                        String mesFormateado = (mesActual < 10)? "0" + String.valueOf(mesActual):String.valueOf(mesActual);
                        fechanacimientomed.setText(diaFormateado + "/" + mesFormateado +"/"+ year);
                    }
                } ,mdiame,mmesme,mañome);
                datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
                datePickerDialog.show();
                break;
        }
    }

}
