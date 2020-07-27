package com.example.drfind.Controlador.adaptadores.AdaptadoresPaciente;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drfind.Controlador.Pacientes;
import com.example.drfind.R;
import com.example.drfind.Vista.Fragments.FragmentsPacientes.CitasPacienteFragment;

import java.util.List;

public class Adaptadormostrarcitapa extends RecyclerView.Adapter<Adaptadormostrarcitapa.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView nombreme,usuame,fechaci,horaci,usuapa;
        Button eliminarcitapa;
        Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreme=(TextView)itemView.findViewById(R.id.nombremedci);
            usuame=(TextView)itemView.findViewById(R.id.usuamedico);
            horaci=(TextView)itemView.findViewById(R.id.horacit);
            fechaci=(TextView)itemView.findViewById(R.id.fechaci);
            usuapa=(TextView)itemView.findViewById(R.id.usuapaccit);
            eliminarcitapa=(Button)itemView.findViewById(R.id.elimcitpac);
        }
        public  void setOnClickListenereli(){eliminarcitapa.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            Pacientes elimci=new Pacientes();
            elimci.eliminarcitapac(usuame.getText().toString(),fechaci.getText().toString(),horaci.getText().toString(),
                    usuapa.getText().toString());
            Bundle datosAEnviar = new Bundle();
            datosAEnviar.putString("usuar",usuapa.getText().toString());
            AppCompatActivity activity=(AppCompatActivity)view.getContext();
            Fragment fragment=new CitasPacienteFragment();
            fragment.setArguments(datosAEnviar);
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }
    }
    public List<mostrarcitmodelo>mostrarcitmodeloList;
    public Adaptadormostrarcitapa(List<mostrarcitmodelo>mostrarcitmodeloList){
        this.mostrarcitmodeloList=mostrarcitmodeloList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listcitaspaciente,parent,false);
        Adaptadormostrarcitapa.ViewHolder viewHolder= new Adaptadormostrarcitapa.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nombreme.setText(mostrarcitmodeloList.get(position).getNombremed());
        holder.usuame.setText(mostrarcitmodeloList.get(position).getUsuariomed());
        holder.horaci.setText(mostrarcitmodeloList.get(position).getHoracita());
        holder.fechaci.setText(mostrarcitmodeloList.get(position).getFechacita());
        holder.usuapa.setText(mostrarcitmodeloList.get(position).getUsuariopa());
        holder.setOnClickListenereli();
    }

    @Override
    public int getItemCount() {
        return mostrarcitmodeloList.size();
    }


}
