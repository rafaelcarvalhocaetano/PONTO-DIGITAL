package com.pontodigital.pontodigital;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.parse.ParseUser;

/**
 * Created by rafael on 16/03/18.
 */

public class DadosRecuperadosActivity extends AppCompatActivity {

    private TextView nome;

    private String uname;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_recuperados);

        nome = (TextView) findViewById(R.id.nome_empresa);


        /*
         * recuperando dados de FeedUsuario
            Intent intent = getIntent();
            String user = intent.getStringExtra("nomeempresa");
         *
         */

         //nome.setText((String) ParseUser.getCurrentUser().get("nomeempresa"));
         nome.setText((String) ParseUser.getCurrentUser().get("nomeempresa"));






    }

}
