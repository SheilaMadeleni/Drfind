package com.example.drfind.Vista.Fragments.FragmentsPacientes;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drfind.Controlador.Pacientes;
import com.example.drfind.Controlador.adaptadores.AdaptadoresPaciente.Adaptadorsacarcita;
import com.example.drfind.R;

import java.util.Calendar;
import java.util.Date;

public class Fragmentreservarcita extends Fragment  {
    private RecyclerView.Adapter adaptadorcitapac;
    private RecyclerView recyclerViewcitapac;
    TextView username,userpacname;
    Button btnhorasdispo, btnfechacita;
    EditText fechacita;
    Calendar c=Calendar.getInstance();
    int yy = c.get(Calendar.YEAR);
    int mm = c.get(Calendar.MONTH);
    int dd = c.get(Calendar.DAY_OF_MONTH);
    Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmentreservarcita, container, false);
        recyclerViewcitapac = view.findViewById(R.id.reciclerreservacita);
        recyclerViewcitapac.setLayoutManager(new LinearLayoutManager(getContext()));
        username=(TextView)view.findViewById(R.id.txtusernameci);
        fechacita=(EditText)view.findViewById(R.id.edtfechacita);
        Bundle bundle=this.getArguments();
        String bu= bundle.getString("usuario");
        //String us=bundle.getString("ususu");
        //userpacname.setText(us);
        username.setText(bu);
        context=view.getContext();
        btnhorasdispo=(Button)view.findViewById(R.id.btnhorasdisp);
        btnhorasdispo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pacientes cit = new Pacientes();
                Bundle userRec = getArguments();
                String users=userRec.getString("usuarito",username.getText().toString());
                String fechci=userRec.getString("fechaci",fechacita.getText().toString());
                //String userpac=userRec.getString("ususi",userpacname.getText().toString());
                adaptadorcitapac = new Adaptadorsacarcita(cit.sacarcitamodeloList(users,fechci));
                recyclerViewcitapac.setAdapter(adaptadorcitapac);
            }
        });

        fechacita= (EditText) view.findViewById(R.id.edtfechacita);
        btnfechacita=(Button)view.findViewById(R.id.btnfechacita);
        btnfechacita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtenerFecha();
            }
        });
        fechacita.setEnabled(false);

        return view;
    }
    public void obtenerFecha(){

        DatePickerDialog recogerFecha = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                int mesActual = month + 1;
                String diaFormateado = (dayOfMonth < 10)? "0" + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                String mesFormateado = (mesActual < 10)? "0" + String.valueOf(mesActual):String.valueOf(mesActual);

                fechacita.setText(diaFormateado + "/" + mesFormateado +"/"+ year);

            }
        },yy, mm, dd);
        recogerFecha.getDatePicker().setMinDate(new Date().getTime());
        recogerFecha.show();
    }
 }
