package com.pontodigital.pontodigital.cadastro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.pontodigital.pontodigital.EmpresaActivity;
import com.pontodigital.pontodigital.R;

/**
 * Created by rafael on 16/03/18.
 */

public class CadastroPostoActivity extends AppCompatActivity {

    private EditText posto;
    private EditText senha;
    private EditText confirmacaoSenha;

    private Button btnCadastrar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_posto);

        posto = (EditText) findViewById(R.id.edit_nome);
        senha = (EditText) findViewById(R.id.edit_senha);
        confirmacaoSenha = (EditText) findViewById(R.id.edit_conf_senha);

        btnCadastrar = (Button) findViewById(R.id.btn_cadastrar_posto);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCampos(posto) == false || isCampos(senha) == false || isCampos(confirmacaoSenha) == false) {
                    return;
                } else if (isSenhas(senha, confirmacaoSenha) == false) {
                    Toast.makeText(CadastroPostoActivity.this, "Verificar Senha e Confirmação de Senha", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    ParseUser user = new ParseUser();

                    user.setUsername( posto.getText().toString().toUpperCase() );
                    user.setPassword( senha.getText().toString() );
                    user.put("nomeempresa", ParseUser.getCurrentUser().get("nomeempresa"));

                    user.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if( e == null ){
                                newScrren();
                            }else{
                                Toast.makeText(CadastroPostoActivity.this, "Erro no cadastro do posto", Toast.LENGTH_LONG).show();
                                return;
                            }
                        }
                    });
                }
            }
        });



    }

    private void newScrren() {
        Intent i = new Intent(this, EmpresaActivity.class);
        startActivity(i);
        finish();
    }

    private boolean isCampos(EditText v) {
        if (v.getText().toString().length() <= 0) {
            v.setError("Verificar Campo");
            return false;
        } else if (v.getText().toString().trim().equals("")) {
            v.setError("Colocando Espaços");
            return false;
        } else {
            return true;
        }
    }

    private boolean isSenhas(EditText s1, EditText s2) {

        int valorUma = Integer.valueOf(s1.getText().toString());
        int valorDois = Integer.valueOf(s2.getText().toString());

        if (valorUma == valorDois) {
            return true;
        } else {
            return false;
        }
    }


}
