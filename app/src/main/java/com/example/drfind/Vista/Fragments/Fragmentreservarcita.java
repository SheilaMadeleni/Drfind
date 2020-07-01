package com.example.drfind.Vista.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drfind.Controlador.Medicos;
import com.example.drfind.Controlador.adaptadores.adaptersacacita;
import com.example.drfind.R;

public class Fragmentreservarcita extends Fragment  {
    private RecyclerView.Adapter adaptadorcitapac;
    private RecyclerView recyclerViewcitapac;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmentreservarcita, container, false);
        recyclerViewcitapac = view.findViewById(R.id.reciclerreservacita);
        recyclerViewcitapac.setLayoutManager(new LinearLayoutManager(getContext()));
        Medicos cit = new Medicos();
        Bundle userRec = getArguments();
        String users=userRec.getString("usuario");
        adaptadorcitapac = new adaptersacacita(cit.mostarcita(users));
        recyclerViewcitapac.setAdapter(adaptadorcitapac);
        return view;
    }
 }
