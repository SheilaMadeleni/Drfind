package com.example.drfind.Vista.Fragments.FragmentsPacientes;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drfind.Controlador.Pacientes;
import com.example.drfind.Controlador.adaptadores.AdaptadoresPaciente.Adaptadorsacarcita;
import com.example.drfind.R;

class Fragmentcit extends Fragment {
    private RecyclerView.Adapter adaptadorcitapac;
    private RecyclerView recyclerViewcitapac;
    Context context;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentcit, container, false);
        recyclerViewcitapac = view.findViewById(R.id.reciclerreservacita);
        recyclerViewcitapac.setLayoutManager(new LinearLayoutManager(getContext()));
        Pacientes cit = new Pacientes();
        Bundle userRec = getArguments();
        String users=userRec.getString("usuarito");
        String fechci=userRec.getString("fechaci");
        adaptadorcitapac = new Adaptadorsacarcita(cit.sacarcitamodeloList(users,fechci));
        recyclerViewcitapac.setAdapter(adaptadorcitapac);
        return view;
    }
}
