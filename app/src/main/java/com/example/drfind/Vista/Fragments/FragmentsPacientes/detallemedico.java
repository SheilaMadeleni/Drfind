package com.example.drfind.Vista.Fragments.FragmentsPacientes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drfind.Controlador.Medicos;
import com.example.drfind.Controlador.adaptadores.AdaptadoresPaciente.Adaptadordetallemedico;
import com.example.drfind.R;

public class detallemedico extends Fragment {
    private RecyclerView.Adapter adaptadordetamedico;
    private RecyclerView recyclerViewdetamedico;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_detallemedico, container, false);
        recyclerViewdetamedico = view.findViewById(R.id.recyclerdetallemedico);
        recyclerViewdetamedico.setLayoutManager(new LinearLayoutManager(getContext()));

        Medicos medico = new Medicos();
        Bundle userRecuperados = getArguments();
        String user=userRecuperados.getString("user");
        adaptadordetamedico = new Adaptadordetallemedico(medico.mostrardetallemedi(user));
        recyclerViewdetamedico.setAdapter(adaptadordetamedico);

        return view;
    }
}
