package com.example.drfind.Controlador.adaptadores;

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

import com.example.drfind.R;
import com.example.drfind.Vista.Fragments.detallemedico;

import java.util.List;

public class RecyclerViewAdaptadorlistamedico extends RecyclerView.Adapter<RecyclerViewAdaptadorlistamedico.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView medico,especialidad,telefonomed,usuariomed;
        Button btndetalle;
        Context context;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context=itemView.getContext();
            medico=(TextView)itemView.findViewById(R.id.nombremedtxt);
            especialidad=(TextView)itemView.findViewById(R.id.especialidadtxt);
            telefonomed=(TextView)itemView.findViewById(R.id.telefonomedtxt);
            usuariomed=(TextView)itemView.findViewById(R.id.usuariomedtxt);
            btndetalle=(Button)itemView.findViewById(R.id.btndetalle);
        }
        public  void setOnClickListeners(){btndetalle.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Bundle datosmedEnviar = new Bundle();
            datosmedEnviar.putString("user",usuariomed.getText().toString());
            AppCompatActivity activity=(AppCompatActivity)view.getContext();
            Fragment fragment=new detallemedico();
            fragment.setArguments(datosmedEnviar);
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }
    }

    public List<medicomodelo> medicolista;
    public RecyclerViewAdaptadorlistamedico(List<medicomodelo> medicolista){
        this.medicolista=medicolista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listamedicos,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.especialidad.setText(medicolista.get(position).getEspecialidad());
        holder.medico.setText(medicolista.get(position).getNombremedi());
        holder.telefonomed.setText(medicolista.get(position).getTelefonomedi());
        holder.usuariomed.setText(medicolista.get(position).getUsuariomed());
        holder.setOnClickListeners();
    }

    @Override
    public int getItemCount() {
        return medicolista.size();
    }


}
