package com.example.drfind.Controlador.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drfind.R;
import com.example.drfind.Vista.Fragments.CitasPacienteFragment;

import java.util.List;

public class adaptadorcitasverpac extends RecyclerView.Adapter<adaptadorcitasverpac.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView nombremedici,especialidadmedci,fechaci,horaci;
        Context context;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context=itemView.getContext();
            nombremedici=(TextView)itemView.findViewById(R.id.nombremedci);
            especialidadmedci=(TextView)itemView.findViewById(R.id.especialidadcit);
            fechaci=(TextView)itemView.findViewById(R.id.fechacit);
            horaci=(TextView)itemView.findViewById(R.id.horacit);
        }
        @Override
        public void onClick(View view) {
            AppCompatActivity activity=(AppCompatActivity)view.getContext();
            Fragment fragments=new CitasPacienteFragment();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, fragments).commit();
        }
    }

    public List<citadetalle> citadetalleList;
    public adaptadorcitasverpac(List<citadetalle> citadetalleList){
        this.citadetalleList=citadetalleList;
    }
    @NonNull
    @Override
    public adaptadorcitasverpac.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listacitapaciente,parent,false);
        adaptadorcitasverpac.ViewHolder viewHolder= new adaptadorcitasverpac.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull adaptadorcitasverpac.ViewHolder holder, int position) {
        holder.nombremedici.setText(citadetalleList.get(position).getNombremedi());
        holder.especialidadmedci.setText(citadetalleList.get(position).getEspecialidad());
        holder.fechaci.setText(citadetalleList.get(position).getFechacita());
        holder.horaci.setText(citadetalleList.get(position).getHoracita());
    }

    @Override
    public int getItemCount() {
        return citadetalleList.size();
    }
}
