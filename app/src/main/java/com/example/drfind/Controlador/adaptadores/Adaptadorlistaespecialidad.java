package com.example.drfind.Controlador.adaptadores;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drfind.R;
import com.example.drfind.Vista.Fragments.ListaMedicosfragment;

import java.util.ArrayList;
import java.util.List;

public class Adaptadorlistaespecialidad extends RecyclerView.Adapter<Adaptadorlistaespecialidad.ViewHolder>{

    Context context;
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView especialidadnombre, idespeci;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            especialidadnombre=(TextView)itemView.findViewById(R.id.txtespecialidad);
            idespeci=(TextView)itemView.findViewById(R.id.idespeci);
        }
        public void setOnClickListeners(){
            especialidadnombre.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Bundle datosAEnviar = new Bundle();
            datosAEnviar.putInt("id",Integer.parseInt(idespeci.getText().toString()));
            AppCompatActivity activity=(AppCompatActivity)view.getContext();
            Fragment fragment=new ListaMedicosfragment();
            fragment.setArguments(datosAEnviar);
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();

        }
    }

    public List<especimodelo> especilista;
    public Adaptadorlistaespecialidad(List<especimodelo> especilista){
        this.especilista=especilista;
    }

    LayoutInflater inflater;
    ArrayList<especimodelo>model;
    private View.OnClickListener listener;
    public Adaptadorlistaespecialidad(Context context, ArrayList<especimodelo>model){
        this.inflater= LayoutInflater.from(context);
        this.model=model;
        this.context=context;
    }
    @NonNull
    @Override
    public Adaptadorlistaespecialidad.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listaespecialidades,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);

        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.especialidadnombre.setText(especilista.get(position).getListespeci());
        holder.idespeci.setText(String.valueOf(especilista.get(position).getIdespeci()));
        holder.setOnClickListeners();
    }
    @Override
    public int getItemCount() {
        return especilista.size();
    }


}
