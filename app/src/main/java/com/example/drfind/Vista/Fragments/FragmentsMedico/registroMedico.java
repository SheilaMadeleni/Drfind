package com.example.drfind.Vista.Fragments.FragmentsMedico;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.drfind.Controlador.Medicos;
import com.example.drfind.R;
import com.example.drfind.Vista.medico.loginmed;
import com.example.drfind.modelo.conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class registroMedico extends Fragment implements View.OnClickListener{
    Button siguiente, cancelarregistromedico,fechanacimed;
    Spinner listespecialidad;
    EditText nombremedico,apamedico,amamedico,usuamedico,contramedico,emailmedico,colegiamed,telefomed,fechanacimientomed;
    TextView resultado;
    ArrayList<Integer> listaespecialidades= new ArrayList<>();

    Calendar C=Calendar.getInstance();
    int mmesme=C.get(Calendar.MONTH);
    int mdiame=C.get(Calendar.DAY_OF_MONTH);
    int mañome=C.get(Calendar.YEAR);
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registro_medico, container, false);
        siguiente=(Button)view.findViewById(R.id.btnsiguiente);
        cancelarregistromedico=(Button)view.findViewById(R.id.btncanregismedico);
        cancelarregistromedico.setOnClickListener(this);
        usuamedico=(EditText)view.findViewById(R.id.edtusuamed);
        contramedico=(EditText)view.findViewById(R.id.edtcontramed);
        nombremedico=(EditText)view.findViewById(R.id.edtnommed);
        apamedico=(EditText)view.findViewById(R.id.edtapmed);
        amamedico=(EditText)view.findViewById(R.id.edtammed);
        emailmedico=(EditText)view.findViewById(R.id.edtemailmed);
        colegiamed=(EditText)view.findViewById(R.id.edtcolegiamed);
        telefomed=(EditText)view.findViewById(R.id.edttelefonomed);
        fechanacimientomed=(EditText)view.findViewById(R.id.edtnacimed);
        resultado=(TextView)view.findViewById(R.id.txtresultado);
        listespecialidad=(Spinner)view.findViewById(R.id.spiespecialidad);
        fechanacimed=(Button)view.findViewById(R.id.btnfechamedico);
        fechanacimed.setOnClickListener(this);
        fechanacimientomed.setEnabled(false);
        usuamedico.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void afterTextChanged(Editable editable) {
                String valordato=editable.toString();
                conexion db = new conexion();
                try {
                    PreparedStatement ed = db.conexionbd().prepareStatement("consulta ?");
                    ed.setString(1,valordato);
                    ResultSet ob = ed.executeQuery();

                    while (ob.next()) {
                        String nombre = ob.getString("usuariomed");
                        if(nombre!=null){
                            usuamedico.setError("usuario ya usado");
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        });
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(usuamedico.getText().toString().isEmpty()||contramedico.getText().toString().isEmpty()||
                        nombremedico.getText().toString().isEmpty()||apamedico.getText().toString().isEmpty()||
                        amamedico.getText().toString().isEmpty()||emailmedico.getText().toString().isEmpty()||
                        colegiamed.getText().toString().isEmpty()||telefomed.getText().toString().isEmpty()||
                        fechanacimientomed.getText().toString().isEmpty()) {

                    resultado.setText("uno o mas campos estan vacios");
                }
                else {
                    Bundle bundle=new Bundle();
                    bundle.putString("usernamecito",usuamedico.getText().toString());
                    registroMedicoHorario newregis=new registroMedicoHorario();
                    newregis.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.contenedor,newregis).commit();
                    Medicos agremed=new Medicos();
                    agremed.agregarmedico(usuamedico.getText().toString(),contramedico.getText().toString(),nombremedico.getText().toString(),
                          apamedico.getText().toString(),amamedico.getText().toString(),listespecialidad.getSelectedItem().toString(),
                        emailmedico.getText().toString(),Integer.parseInt(colegiamed.getText().toString()),Integer.parseInt(telefomed.getText().toString()),
                      fechanacimientomed.getText().toString());
                }
            }
        });


        lista();
        return view;
    }
    public void lista() {
        conexion db = new conexion();
        listaespecialidades = new ArrayList<Integer>();
        try {
            PreparedStatement ed = db.conexionbd().prepareStatement("spinnerespecialidad");
            ResultSet ob = ed.executeQuery();

            while (ob.next()) {
                Integer nombre = ob.getInt("idespecialidad");
                listaespecialidades.add(nombre);
            }
            Integer[] Array = listaespecialidades.toArray(new Integer[0]);
            ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, listaespecialidades);
            listespecialidad.setAdapter(adapter);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btncanregismedico:
                Intent j = new Intent(getContext(), loginmed.class);
                startActivity(j);
                break;
            case R.id.btnfechamedico:
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {

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
