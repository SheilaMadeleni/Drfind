package com.example.drfind.Vista.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drfind.R;
import com.example.drfind.Controlador.adaptadores.RecyclerViewAdaptadorlistapacientes;
import com.example.drfind.Controlador.adaptadores.pacientemodelo;
import com.example.drfind.callback;
import com.example.drfind.modelo.conexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IniciomedicoFragment extends Fragment implements callback.callbackListener{
    private RecyclerView.Adapter adaptadorPacientes;
    private RecyclerView recyclerViewPacientes;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.iniciomedicofragment,container,false);
        recyclerViewPacientes=view.findViewById(R.id.reciclerpacientes);
        recyclerViewPacientes.setLayoutManager(new LinearLayoutManager(getContext()));
        adaptadorPacientes=new RecyclerViewAdaptadorlistapacientes(obtenerpacientebd());
        recyclerViewPacientes.setAdapter(adaptadorPacientes);
        ItemTouchHelper.SimpleCallback simpleCallback=
        new callback(0,ItemTouchHelper.LEFT,IniciomedicoFragment.this);
        new ItemTouchHelper(simpleCallback).attachToRecyclerView(recyclerViewPacientes);
        return view;
    }

    public List<pacientemodelo>obtenerpacientebd(){
        conexion db=new conexion();
        List<pacientemodelo> paciente = new ArrayList<>();
        try {
            Statement st=db.conexionbd().createStatement();
            ResultSet ob=st.executeQuery("select * from Paciente");
            while (ob.next()){
                paciente.add(new pacientemodelo((ob.getString("nombrepac")),(ob.getString("telefonopac")),(ob.getString("direccionpac"))));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return paciente;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if(viewHolder instanceof RecyclerViewAdaptadorlistapacientes.ViewHolder){
            adaptadorPacientes.notifyItemRemoved(viewHolder.getAdapterPosition());
        }
    }
}
