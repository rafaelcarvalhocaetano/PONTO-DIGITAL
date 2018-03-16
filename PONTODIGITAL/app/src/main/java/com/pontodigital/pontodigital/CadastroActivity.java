package com.pontodigital.pontodigital;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.rtoshiro.util.format.MaskFormatter;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import bolts.Task;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar_empresa);

        nome = (EditText) findViewById(R.id.edt_razao_social);
        cnpj = (EditText) findViewById(R.id.edt_cnpj);
        senha = (EditText) findViewById(R.id.edt_senha);
        confirmacaoSenha = (EditText) findViewById(R.id.edt_confirmacao_senha);

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
                }else{
                   ParseUser user = new ParseUser();


                   user.setUsername(cnpj.getText().toString());
                   user.setPassword(senha.getText().toString());

                   user.signUpInBackground(new SignUpCallback() {
                       @Override
                       public void done(ParseException e) {
                           if(e == null){
                               ParseObject oo = new ParseObject("Empresas");
                               oo.put("nome", nome.getText().toString());
                               oo.put("cnpj", cnpj.getText().toString());
                               oo.saveInBackground();
                               Toast.makeText(CadastroActivity.this, "Cadastrado Com sucesso", Toast.LENGTH_LONG).show();
                           }else{
                               Toast.makeText(CadastroActivity.this, "Erro no Cadastro "+e.getMessage(), Toast.LENGTH_LONG).show();
                           }
                       }
                   });




                }
            }
        });
    }

    private boolean isCampos(EditText v){
        if(v.getText().toString().length() <= 0){
            v.setError("Verificar Campo");
            return false;
        }else if(v.getText().toString().trim().equals("")){
            v.setError("Colocando Espaços");
            return false;
        }else{
            return true;
        }
    }

    private boolean isSenhas(EditText s1, EditText s2){

        int valorUma = Integer.valueOf( s1.getText().toString() );
        int valorDois = Integer.valueOf( s2.getText().toString() );

        if( valorUma == valorDois ){
            return true;
        }else{
            return false;
        }
    }
    /**
     * private boolean isCampos(EditText valor){
     boolean resultado = (TextUtils.isEmpty( valor.toString() ) || valor.toString().trim().isEmpty() );
     return resultado;
     }

     final int value = Integer.valueOf(num);

     Agora você tem uma váriavel chamada value que contém o valor digitado no EditText como um inteiro.

     Agora você pode fazer a validação como inteiros, segue um exemplo:

     if (value == 0) {
     validar = false;
     edtNum.setError(getString(R.string.valEdtNum));
     }

     * */



    /**
     *

     XX.XXX.XXX/0001-XX  cnpj

     SimpleMaskFormatter smf = new SimpleMaskFormatter("NN/NN/NNNN");
     MaskTextWatcher mtw = new MaskTextWatcher(myEditText, msf)
     myEditText.addTextChangedListener(mtw);


     */
    }
