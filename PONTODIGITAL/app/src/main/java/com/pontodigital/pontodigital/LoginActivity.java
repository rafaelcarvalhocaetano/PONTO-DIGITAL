package com.pontodigital.pontodigital;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;


/**
 * Created by rafael on 21/01/18.
 */

public class LoginActivity extends AppCompatActivity {

    private TextView cadastrar;
    private EditText cnpj;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        cadastrar = (TextView) findViewById(R.id.cadastrar_empresa);
        cnpj = (EditText) findViewById(R.id.edit_cnpj);

        SimpleMaskFormatter SimpleCNPJ = new SimpleMaskFormatter("NN.NNN.NNN/NNNN-NN");
        MaskTextWatcher mCNPJ = new MaskTextWatcher(cnpj, SimpleCNPJ);

        cnpj.addTextChangedListener( mCNPJ );


        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, CadastroActivity.class));
                finish();
            }
        });







    }
}
