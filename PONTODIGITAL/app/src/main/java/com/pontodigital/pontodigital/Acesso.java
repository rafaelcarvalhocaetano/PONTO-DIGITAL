package com.pontodigital.pontodigital;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;


/**
 * Created by rafael on 21/01/18.
 */

public class Acesso extends AppCompatActivity {


    private TextView cadastro;
    private CardView card_empresa;
    private CardView card_posto;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acesso);


        card_empresa = (CardView) findViewById(R.id.card_empresa);
        card_posto = (CardView) findViewById(R.id.card_posto);


        card_empresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Acesso.this, EmpresaActivity.class));
                finish();
            }
        });
        card_posto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Acesso.this, PostoActivity.class));
                finish();
            }
        });


        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Acesso.this, CadastroActivity.class));
            }
        });


    }
}
