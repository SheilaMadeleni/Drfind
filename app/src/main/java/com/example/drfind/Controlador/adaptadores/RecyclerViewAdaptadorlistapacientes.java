package com.example.drfind.Controlador.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drfind.R;

import java.util.List;

public class RecyclerViewAdaptadorlistapacientes extends RecyclerView.Adapter<RecyclerViewAdaptadorlistapacientes.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView paciente, direccion, telefono;
        public RelativeLayout viewf;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            paciente=(TextView)itemView.findViewById(R.id.nombrepactxt);
            direccion=(TextView)itemView.findViewById(R.id.direccionpactxt);
            telefono=(TextView)itemView.findViewById(R.id.telefonopactxt);
            viewf=(RelativeLayout)itemView.findViewById(R.id.aborrar);
        }
    }
    public void removeItem(int position){
        pacientelista.remove(position);
        notifyItemRemoved(position);
    }

public List<pacientemodelo> pacientelista;
    public RecyclerViewAdaptadorlistapacientes(List<pacientemodelo> pacientelista){
        this.pacientelista=pacientelista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listapacientes,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.paciente.setText(pacientelista.get(position).getNombre());
        holder.direccion.setText(pacientelista.get(position).getDireccion());
        holder.telefono.setText(pacientelista.get(position).getTelefono());
    }

    @Override
    public int getItemCount() {
        return pacientelista.size();
    }
}
