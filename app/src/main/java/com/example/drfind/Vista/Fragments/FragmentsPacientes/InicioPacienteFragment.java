package com.example.drfind.Vista.Fragments.FragmentsPacientes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drfind.Controlador.adaptadores.AdaptadoresPaciente.Adaptadorlistaespecialidad;
import com.example.drfind.Controlador.especialidad;
import com.example.drfind.R;

public class InicioPacienteFragment extends Fragment {
    private RecyclerView.Adapter adaptadorespeci;
    private RecyclerView recyclerViewespeci;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.iniciopacientefragment, container, false);
        recyclerViewespeci=view.findViewById(R.id.recyclerespecialidades);
        especialidad espe=new especialidad();
        Bundle userRecuperados = getArguments();
        String user=userRecuperados.getString("usuar");
        recyclerViewespeci.setLayoutManager(new LinearLayoutManager(getContext()));
        adaptadorespeci=new Adaptadorlistaespecialidad(espe.mostrar(user));
        recyclerViewespeci.setAdapter(adaptadorespeci);
        return view;
    }



}
