package com.example.drfind.Vista.Fragments.FragmentsMedico;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drfind.R;

public class IniciomedicoFragment extends Fragment{
    private RecyclerView.Adapter adaptadorPacientes;
    private RecyclerView recyclerViewPacientes;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.iniciomedicofragment,container,false);
        recyclerViewPacientes=view.findViewById(R.id.reciclerpacientes);
        recyclerViewPacientes.setLayoutManager(new LinearLayoutManager(getContext()));
        //Medicos citamed=new  Medicos();
        //Bundle datosRecuperados = getArguments();
        //String id=datosRecuperados.getString("usernam");
        return view;
    }

}
