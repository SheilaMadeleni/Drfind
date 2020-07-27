package com.example.drfind.Vista.Fragments.FragmentsPacientes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drfind.Controlador.Pacientes;
import com.example.drfind.Controlador.adaptadores.AdaptadoresPaciente.Adaptadormostrarcitapa;
import com.example.drfind.R;

public class CitasPacienteFragment extends Fragment  {
    private RecyclerView.Adapter adaptadorcitaspac;
    private RecyclerView recyclerViewcitaspac;
    TextView usuci;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.citasfragment, container, false);
        recyclerViewcitaspac = view.findViewById(R.id.recyclercitas);
        recyclerViewcitaspac.setLayoutManager(new LinearLayoutManager(getContext()));
        //usuci=(TextView)view.findViewById(R.id.textciti);
        //Bundle bundle=this.getArguments();
        //String bu= bundle.getString("usuar");
        //usuci.setText(bu);

        Pacientes pacci = new Pacientes();
        Bundle userRecuperados = getArguments();
        String user=userRecuperados.getString("usuar");
        adaptadorcitaspac = new Adaptadormostrarcitapa(pacci.mostrarcitmodeloList(user));
        recyclerViewcitaspac.setAdapter(adaptadorcitaspac);
        return view;
    }
}
