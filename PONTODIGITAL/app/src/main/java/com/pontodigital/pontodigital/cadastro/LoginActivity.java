package com.pontodigital.pontodigital.cadastro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.pontodigital.pontodigital.EmpresaActivity;
import com.pontodigital.pontodigital.R;


/**
 * Created by rafael on 21/01/18.
 */

public class LoginActivity extends AppCompatActivity {

    private TextView cadastrar;
    private EditText cnpj;
    private EditText posto;
    private EditText senhaPosto;
    private EditText senhaEmpresa;

    private CheckBox cbEmpresa;
    private CheckBox cbPosto;

    private Button btnEmpresa;
    private Button btnPosto;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        cadastrar = (TextView) findViewById(R.id.cadastrar_empresa);
        cnpj = (EditText) findViewById(R.id.edit_cnpj);
        senhaEmpresa = (EditText) findViewById(R.id.edit_senha_empresa);
        posto = (EditText) findViewById(R.id.edit_nome_posto);
        senhaPosto = (EditText) findViewById(R.id.edit_senha_posto);

        cbEmpresa = (CheckBox) findViewById(R.id.ck1);
        cbPosto = (CheckBox) findViewById(R.id.ck2);

        btnEmpresa = (Button) findViewById(R.id.btn_login_empresa);
        btnPosto = (Button) findViewById(R.id.btn_login_posto);


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

        btnEmpresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Intent i = new Intent(LoginActivity.this, EmpresaActivity.class);
                startActivity(i);
                finish();
                */
               String user = cnpj.getText().toString();
               String pass = senhaEmpresa.getText().toString();

                ParseUser.logInInBackground(user, pass, new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {

                        if(e == null){
                            windows();
                        }
                    }
                });
            }
        });




    }

    private void windows(){
        Intent i = new Intent(getApplicationContext(), EmpresaActivity.class);
        startActivity(i);
        finish();
    }
}
