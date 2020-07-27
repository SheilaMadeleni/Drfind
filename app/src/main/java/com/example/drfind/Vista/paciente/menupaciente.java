package com.example.drfind.Vista.paciente;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.drfind.R;
import com.example.drfind.Vista.Fragments.FragmentsPacientes.CitasPacienteFragment;
import com.example.drfind.Vista.Fragments.FragmentsPacientes.InicioPacienteFragment;
import com.example.drfind.Vista.Fragments.FragmentsPacientes.UbicacionFragment;
import com.google.android.material.navigation.NavigationView;

public class menupaciente extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Bundle da;
    TextView juju;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menupaciente);
        toolbar=findViewById(R.id.toolbari);
        setSupportActionBar(toolbar);
        drawerLayout=findViewById(R.id.drawer);
        navigationView=findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

        da=getIntent().getExtras();
        String datos=da.getString("usu");
        juju=(TextView)findViewById(R.id.juju);
        juju.setText(datos);

        Bundle datosAEnviar = new Bundle();
        datosAEnviar.putString("usu",juju.getText().toString());
        Fragment fragmenti=new InicioPacienteFragment();
        fragmenti.setArguments(datosAEnviar);
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, fragmenti);
        fragmentTransaction.commit();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if(item.getItemId()==R.id.inicio){
            Bundle datosAEnviar = new Bundle();
            datosAEnviar.putString("usuar",juju.getText().toString());
            Fragment fragmentis=new InicioPacienteFragment();
            fragmentis.setArguments(datosAEnviar);
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragmentis);
            fragmentTransaction.commit();
        }
        if(item.getItemId()==R.id.citas){
            Bundle datosAEnviar = new Bundle();
            datosAEnviar.putString("usuar",juju.getText().toString());
            Fragment fragment=new CitasPacienteFragment();
            fragment.setArguments(datosAEnviar);
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }
        if(item.getItemId()==R.id.ubicacion){
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, new UbicacionFragment());
            fragmentTransaction.commit();
        }

        return false;
    }
}
