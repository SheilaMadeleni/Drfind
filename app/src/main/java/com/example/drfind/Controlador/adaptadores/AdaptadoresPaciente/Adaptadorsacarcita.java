package com.example.drfind.Controlador.adaptadores.AdaptadoresPaciente;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drfind.Controlador.Pacientes;
import com.example.drfind.R;

import java.util.List;

public class Adaptadorsacarcita extends RecyclerView.Adapter<Adaptadorsacarcita.ViewHolder>{
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView horacita,usuamed,fechacita,id;
        Button buticit;
        Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            horacita = (TextView) itemView.findViewById(R.id.txthoracita);
            usuamed = (TextView)itemView.findViewById(R.id.txtusuariomed);
            fechacita=(TextView)itemView.findViewById(R.id.txtfechacita);
            id=(TextView)itemView.findViewById(R.id.txtidcita);
            buticit=(Button)itemView.findViewById(R.id.btnhoritacit);
        }
        public void setOnClickLi(){
            buticit.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Pacientes agecit =new Pacientes();
            agecit.agregarcita(Integer.parseInt(id.getText().toString()),fechacita.getText().toString(),
                    horacita.getText().toString(),usuamed.getText().toString());
        }
        }

    public List<sacarcitamodelo> sacarcitamodeloList;
    public Adaptadorsacarcita(List<sacarcitamodelo> sacarcitamodeloList){
        this.sacarcitamodeloList = sacarcitamodeloList;
    }
    @NonNull
    @Override
    public Adaptadorsacarcita.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listreservacita,parent,false);
        Adaptadorsacarcita.ViewHolder viewHolder= new Adaptadorsacarcita.ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.usuamed.setText(sacarcitamodeloList.get(position).getUsuarioname());
        holder.horacita.setText(sacarcitamodeloList.get(position).getHoracita());
        holder.fechacita.setText(sacarcitamodeloList.get(position).getFechacita());
        holder.id.setText(sacarcitamodeloList.get(position).getId());
        holder.setOnClickLi();
    }
    @Override
    public int getItemCount() {
        return sacarcitamodeloList.size();
    }

}
