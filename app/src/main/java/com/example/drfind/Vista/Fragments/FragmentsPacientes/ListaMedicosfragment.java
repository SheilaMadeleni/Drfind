package com.example.drfind.Vista.Fragments.FragmentsPacientes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drfind.Controlador.Medicos;
import com.example.drfind.Controlador.adaptadores.AdaptadoresPaciente.Adaptadorlistamedico;
import com.example.drfind.R;


public class ListaMedicosfragment extends Fragment  {

    private RecyclerView.Adapter adaptadorMedico;
    private RecyclerView recyclerViewMedico;
    TextView usupa;
    Bundle da;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_medicosfragment, container, false);
        recyclerViewMedico = view.findViewById(R.id.reciclermedicos);
        recyclerViewMedico.setLayoutManager(new LinearLayoutManager(getContext()));
        Medicos medico = new Medicos();
        Bundle datosRecuperados = getArguments();
        int id=datosRecuperados.getInt("id");
        adaptadorMedico = new Adaptadorlistamedico(medico.mostrarlistmedi(id));
        recyclerViewMedico.setAdapter(adaptadorMedico);
        da=getActivity().getIntent().getExtras();
        String datos=da.getString("usus");
        usupa=(TextView)view.findViewById(R.id.textusupaci);
        usupa.setText(datos);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.filtros,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        switch (id){
            case R.id.itemnombre:
                return true;
            case R.id.itemcalificacion:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
