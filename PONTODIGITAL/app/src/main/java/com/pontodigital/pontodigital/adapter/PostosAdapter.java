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

/**
 * Created by rafael on 19/03/18.
 */

public class PostosAdapter extends ArrayAdapter<ParseUser> {

    private Context context;
    private ArrayList<ParseUser> usuarios;


    public PostosAdapter(@NonNull Context c, ArrayList<ParseUser> objetos) {
        super(c, 0, objetos);

        this.context = c;
        this.usuarios = objetos;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;

        if(v == null ){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService( context.LAYOUT_INFLATER_SERVICE );
            v = inflater.inflate(R.layout.activity_empresa, parent, false);
        }
        TextView numero = (TextView) v.findViewById(R.id.numero_cadastro);
        TextView posto = (TextView) v.findViewById(R.id.nome_posto);

        ParseUser user = usuarios.get( position );
        posto.setText( user.getUsername() );


        return v;
    }
}
