package com.pontodigital.pontodigital.cadastro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.pontodigital.pontodigital.EmpresaActivity;
import com.pontodigital.pontodigital.R;


/**
 * Created by rafael on 24/01/18.
 */

public class CadastroActivity extends AppCompatActivity {

    private EditText nome;
    private EditText cnpj;
    private EditText senha;
    private EditText confirmacaoSenha;

    private Button cadastrar;

    private String sCNPJ;
    private String sNome;
    private String sSENHA;
    private String cSENHA;

    private LinearLayout ll;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_empresa);

        nome = (EditText) findViewById(R.id.edt_razao_social);
        cnpj = (EditText) findViewById(R.id.edt_cnpj);
        senha = (EditText) findViewById(R.id.edt_senha);
        confirmacaoSenha = (EditText) findViewById(R.id.edt_confirmacao_senha);

        ll = (LinearLayout) findViewById(R.id.ll);

        cadastrar = (Button) findViewById(R.id.btn_cadastrar);

        SimpleMaskFormatter SimpleCNPJ = new SimpleMaskFormatter("NN.NNN.NNN/NNNN-NN");
        MaskTextWatcher mCNPJ = new MaskTextWatcher(cnpj, SimpleCNPJ);

        cnpj.addTextChangedListener(mCNPJ);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCampos(nome) == false || isCampos(cnpj) == false || isCampos(senha) == false || isCampos(confirmacaoSenha) == false) {
                    return;
                } else if (isSenhas(senha, confirmacaoSenha) == false) {
                    Toast.makeText(CadastroActivity.this, "Verificar Senha e Confirmação de Senha", Toast.LENGTH_LONG).show();
                    return;
                } else {

                    final ParseUser user = new ParseUser();
                    final ParseObject object = new ParseObject("Empresas");

                    user.setUsername(cnpj.getText().toString().toUpperCase());
                    user.setPassword(senha.getText().toString());
                    user.put("nomeempresa", nome.getText().toString().toUpperCase());

                    // object.put("username", nome.getText().toString());
                    //object.put("nomeempresa", ParseUser.getCurrentUser().getUsername());


                    user.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {

                                object.saveInBackground();
                                Toast.makeText(CadastroActivity.this, "CADASTRADO", Toast.LENGTH_SHORT).show();
                                newScrren();
                            } else {
                                Toast.makeText(CadastroActivity.this, "ERRO NO CADASTRO" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


                }
            }
        });
    }

    @Override
    public void onBackPressed() {

        if(ll.isClickable() == false){
            Intent i = new Intent(CadastroActivity.this, LoginActivity.class);
            startActivity(i);
            finish();
        }else{
            super.onBackPressed();
        }

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
    /**
     XX.XXX.XXX/0001-XX  cnpj

     SimpleMaskFormatter smf = new SimpleMaskFormatter("NN/NN/NNNN");
     MaskTextWatcher mtw = new MaskTextWatcher(myEditText, msf)
     myEditText.addTextChangedListener(mtw);

     */
}
