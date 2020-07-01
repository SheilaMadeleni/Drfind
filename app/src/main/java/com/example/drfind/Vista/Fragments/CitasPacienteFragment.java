package com.example.drfind.Vista.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drfind.Controlador.Pacientes;
import com.example.drfind.Controlador.adaptadores.adaptadorcitasverpac;
import com.example.drfind.R;

public class CitasPacienteFragment extends Fragment {
    private RecyclerView.Adapter adaptadorcitaspac;
    private RecyclerView recyclerViewcitaspac;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.citasfragment, container, false);
        recyclerViewcitaspac = view.findViewById(R.id.recyclercitas);
        recyclerViewcitaspac.setLayoutManager(new LinearLayoutManager(getContext()));
        Pacientes cit=new Pacientes();
        Bundle datoscitas = getArguments();
        String usuamed=datoscitas.getString("userito");
        adaptadorcitaspac = new adaptadorcitasverpac(cit.mostrarlistcita(usuamed));
        recyclerViewcitaspac.setAdapter(adaptadorcitaspac);
        return view;
    }
}
