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
import com.example.drfind.Vista.Fragments.Fragmentreservarcita;

import java.util.List;

public class Adaptadordetallemedico  extends RecyclerView.Adapter<Adaptadordetallemedico.ViewHolder>{
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView medico,especialidad,telefonomed,emailmed,usuariomedico;
        Button reservarcita;
        Context context;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context=itemView.getContext();
            medico=(TextView)itemView.findViewById(R.id.nombremedtxt);
            especialidad=(TextView)itemView.findViewById(R.id.especialidadtxt);
            telefonomed=(TextView)itemView.findViewById(R.id.telefonomedtxt);
            emailmed=(TextView)itemView.findViewById(R.id.emailmedtxt);
            reservarcita=(Button)itemView.findViewById(R.id.btnnuevacita);
            usuariomedico=(TextView)itemView.findViewById(R.id.usuariomedicotxt);
        }
        public  void setOnClickListeneris(){reservarcita.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Bundle datoscitEnviar = new Bundle();
            datoscitEnviar.putString("usuario",usuariomedico.getText().toString());
            AppCompatActivity activity=(AppCompatActivity)view.getContext();
            Fragment fragments=new Fragmentreservarcita();
            fragments.setArguments(datoscitEnviar);
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, fragments).commit();
        }
    }

    public List<medicodetallemodelo> medicodetalista;
    public Adaptadordetallemedico(List<medicodetallemodelo> medicodetalista){
        this.medicodetalista=medicodetalista;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listadetallemedico,parent,false);
        Adaptadordetallemedico.ViewHolder viewHolder= new Adaptadordetallemedico.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.especialidad.setText(medicodetalista.get(position).getEspecialidad());
        holder.medico.setText(medicodetalista.get(position).getNombremedi());
        holder.telefonomed.setText(medicodetalista.get(position).getTelefonomedi());
        holder.emailmed.setText(medicodetalista.get(position).getE_mailmed());
        holder.usuariomedico.setText(medicodetalista.get(position).getUsuariomed());
        holder.setOnClickListeneris();
    }

    @Override
    public int getItemCount() {
        return medicodetalista.size();
    }

}
