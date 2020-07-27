package com.example.drfind.Vista.Fragments.FragmentsMedico;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.drfind.R;
import com.example.drfind.Vista.medico.loginmed;
import com.example.drfind.modelo.conexion;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class registroMedicoHorario extends Fragment {
    TextView usuamed;
    Button registroho, cancelho;
    CheckBox h1,h2,h3,h4,h5,h6,h7,h8,h9,h10,h11,h12;
    ArrayList<String>listhora = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     View view = inflater.inflate(R.layout.fragment_registro_medico_horario, container, false);
     usuamed=(TextView)view.findViewById(R.id.textusuariomedic);
     h1=(CheckBox)view.findViewById(R.id.checkBox);
        h2=(CheckBox)view.findViewById(R.id.checkBox1);
        h3=(CheckBox)view.findViewById(R.id.checkBox2);
        h4=(CheckBox)view.findViewById(R.id.checkBox3);
        h5=(CheckBox)view.findViewById(R.id.checkBox4);
        h6=(CheckBox)view.findViewById(R.id.checkBox5);
        h7=(CheckBox)view.findViewById(R.id.checkBox6);
        h8=(CheckBox)view.findViewById(R.id.checkBox7);
        h9=(CheckBox)view.findViewById(R.id.checkBox8);
        h10=(CheckBox)view.findViewById(R.id.checkBox9);
        h11=(CheckBox)view.findViewById(R.id.checkBox10);
        h12=(CheckBox)view.findViewById(R.id.checkBox11);
     registroho=(Button)view.findViewById(R.id.btnguardarhoras);
     registroho.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

             if(h1.isChecked()){
                 String c1="9:00-9:30";
                 listhora.add(c1);
             }
             if(h2.isChecked()){
                 String c2="9:30-10:00";
                 listhora.add(c2);
             }
             if(h3.isChecked()){
                 String c3="10:00-10:30";
                 listhora.add(c3);
             }
             if(h4.isChecked()){
                 String c4="10:30-11:00";
                 listhora.add(c4);
             }
             if(h5.isChecked()){
                 String c5="11:00-11:30";
                 listhora.add(c5);
             }
             if(h6.isChecked()){
                 String c6="11:30-12:00";
                 listhora.add(c6);
             }
             if(h7.isChecked()){
                 String c7="14:30-15:00";
                 listhora.add(c7);
             }
             if(h8.isChecked()){
                 String c8="15:00-15:30";
                 listhora.add(c8);
             }
             if(h9.isChecked()){
                 String c9="15:30-16:00";
                 listhora.add(c9);
             }
             if(h10.isChecked()){
                 String c10="16:00-16:30";
                 listhora.add(c10);
             }
             if(h11.isChecked()){
                 String c11="16:30-17:00";
                 listhora.add(c11);
             }
             if(h12.isChecked()){
                 String c12="17:00-17:30";
                 listhora.add(c12);
             }
             addbasedatos();
             Intent j = new Intent(getActivity(), loginmed.class);
             startActivity(j);
         }
     });
     cancelho=(Button)view.findViewById(R.id.btnsatras1);
     cancelho.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent i = new Intent(getActivity(), registroMedico.class);
             startActivity(i);
         }
     });
     Bundle bundle=this.getArguments();
     String bu= bundle.getString("usernamecito");
     usuamed.setText(bu);
     return view;
    }
public void addbasedatos(){
    conexion db=new conexion();
        for (int x=0;x<listhora.size();x++){
            try {
                PreparedStatement pst=db.conexionbd().prepareStatement("insert_horario ?,?");
                pst.setString(1,usuamed.getText().toString());
                pst.setString(2,listhora.get(x));
                pst.executeUpdate();
            } catch (SQLException e) {
                e.getMessage();
            }
        }
}

}
