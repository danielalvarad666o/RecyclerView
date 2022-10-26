package com.gasca1234.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.gasca1234.recyclerview.Adaptadores.Adaptadorpersona;
import com.gasca1234.recyclerview.modelos.Persona;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Persona> persons = new ArrayList<Persona>();

        persons.add(new Persona("Daniel","8721371167"));
        persons.add(new Persona("luis","8721689583"));
        persons.add(new Persona("Pablo","8721465541"));
        persons.add(new Persona("diego","8729746523"));
        persons.add(new Persona("yordi","8729846213"));
        persons.add(new Persona("luis","8724598126"));
        persons.add(new Persona("jose","8728465129"));
        persons.add(new Persona("mnuel","8728564299"));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        Adaptadorpersona adapter = new Adaptadorpersona(persons);
        recyclerView.setAdapter(adapter);

    }
}