package com.pontodigital.pontodigital.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.parse.ParseUser;
import com.pontodigital.pontodigital.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafael on 19/03/18.
 */

public class PostosAdapter extends ArrayAdapter<ParseUser> {

    private Context context;
    private ArrayList<ParseUser> usuarios;

    private TextView us;
    private TextView num;

    public PostosAdapter(@NonNull Context c, @NonNull ArrayList<ParseUser> objects) {
        super(c, 0, objects);
        this.context = c;
        this.usuarios = objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;

        if(v == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            //montando a view a partir do xml
            v = inflater.inflate(R.layout.lista_usuario, parent, false);
        }

        //recupera os elementos da activity_empresa
        us = (TextView) v.findViewById(R.id.nome_posto);


        //recuperando
        ParseUser user1 = usuarios.get(position);
        us.setText( (String) user1.get("username") );



        return v;
    }
}
