package com.example.drfind.Controlador.adaptadores;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drfind.Controlador.Pacientes;
import com.example.drfind.R;
import com.example.drfind.Vista.Fragments.CitasPacienteFragment;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class adaptersacacita extends RecyclerView.Adapter<adaptersacacita.ViewHolder>{
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private TextView usuarmedici;
        Button btnsacacita, btnfechacita,btnhoritacita;
        EditText fechacita,horitacita;
        TextView resultcita;
        Calendar c=Calendar.getInstance();
        int yy = c.get(Calendar.YEAR);
        int mm = c.get(Calendar.MONTH);
        int dd = c.get(Calendar.DAY_OF_MONTH);
        int hou=c.get(Calendar.HOUR_OF_DAY);
        int minute=c.get(Calendar.MINUTE);
        Context context;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context=itemView.getContext();
            usuarmedici=(TextView)itemView.findViewById(R.id.txtiduser);
            btnsacacita=(Button)itemView.findViewById(R.id.btnreservar);
            btnfechacita=(Button)itemView.findViewById(R.id.btnfechacita);
            horitacita=(EditText)itemView.findViewById(R.id.edthoracita);
            resultcita=(TextView)itemView.findViewById(R.id.txtresultadocita);
            btnhoritacita=(Button)itemView.findViewById(R.id.btnhoracita);
            btnhoritacita.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    obtenerhora();
                }
            });
            fechacita= (EditText) itemView.findViewById(R.id.edtfechacita);
            btnfechacita.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    obtenerFecha();
                }
            });
            fechacita.setEnabled(false);
            horitacita.setEnabled(false);
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
        public void obtenerhora(){
            TimePickerDialog recogerHora = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourofday, int minuto) {

                    horitacita.setText(hourofday+ ":" + minuto);
                }
            },hou, minute,false);

            recogerHora.show();
        }
        public  void setOnClickListeners(){btnsacacita.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            if(fechacita.getText().toString().isEmpty()||horitacita.getText().toString().isEmpty()){
                resultcita.setText("No se pueden guardar campos vacios");
            }else {
                Pacientes agrepac=new Pacientes();
                agrepac.agregarcita(fechacita.getText().toString(),horitacita.getText().toString());
                resultcita.setText("Guardado correctamente");
                Bundle datosmedEnviar = new Bundle();
                datosmedEnviar.putString("userito",usuarmedici.getText().toString());
                AppCompatActivity activity=(AppCompatActivity)view.getContext();
                Fragment fragment=new CitasPacienteFragment();
                fragment.setArguments(datosmedEnviar);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
            }
        }
    }
    public List<sacacita> sacacitaList;
    public adaptersacacita(List<sacacita> sacacitaList){
        this.sacacitaList=sacacitaList;
    }
    @NonNull
    @Override
    public adaptersacacita.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listreservacita,parent,false);
        adaptersacacita.ViewHolder viewHolder= new adaptersacacita.ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.usuarmedici.setText(sacacitaList.get(position).getUsuariomed());
        holder.setOnClickListeners();
    }
    @Override
    public int getItemCount() {
        return sacacitaList.size();
    }

}
