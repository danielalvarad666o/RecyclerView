package com.gasca1234.recyclerview.Adaptadores;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.gasca1234.recyclerview.R;
import com.gasca1234.recyclerview.modelos.Persona;

import java.util.List;

public class Adaptadorpersona extends RecyclerView.Adapter<Adaptadorpersona.viewholder> {
    List<Persona> LP;
    int request_code = 200;

    public Adaptadorpersona(List<Persona> LP) {
        this.LP = LP;
    }

    @NonNull
    @Override
    public Adaptadorpersona.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main,parent,false);
        return new viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptadorpersona.viewholder holder, int position) {

        holder.setData(LP.get(position));

    }

    @Override
    public int getItemCount() {
        return LP.size();
    }

    public class viewholder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txtname;
        TextView txtphone;
        Persona personaholder;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            txtname = (TextView) itemView.findViewById(R.id.txtname);
            txtphone = (TextView) itemView.findViewById(R.id.txtphone);
            itemView.setOnClickListener(this::onClick);
        }

        public void setData(Persona p) {
            personaholder = p;
            txtname.setText(p.getName());
            txtphone.setText(p.getPhone());
        }

        @Override
        public void onClick(View view) {
            llamada();
        }
        public void llamada() {
            String phone = "tel:" + txtphone.getText();
            if (ContextCompat.checkSelfPermission(itemView.getContext(),
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions((Activity) itemView.getContext(),
                        new String[]{Manifest.permission.CALL_PHONE}, request_code);
            } else {
                String dial = phone;
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(dial));
                itemView.getContext().startActivity(intent);
            }
        }
    }

}



