package com.pontodigital.pontodigital;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;

import com.github.rtoshiro.util.format.MaskFormatter;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

/**
 * Created by rafael on 24/01/18.
 */

public class CadastroActivity extends AppCompatActivity {

    private TextInputEditText cnpj;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar_empresa);

        cnpj = (TextInputEditText) findViewById(R.id.cnpj);

        //XX.XXX.XXX/0001-XX  cnpj
        /*
        SimpleMaskFormatter smf = new SimpleMaskFormatter("NN/NN/NNNN");
            MaskTextWatcher mtw = new MaskTextWatcher(myEditText, msf)
            myEditText.addTextChangedListener(mtw);
         */

        SimpleMaskFormatter SimpleCNPJ = new SimpleMaskFormatter("NN.NNN.NNN/NNNN-NN");
        MaskTextWatcher mCNPJ = new MaskTextWatcher(cnpj, SimpleCNPJ);

        cnpj.addTextChangedListener( mCNPJ );
    }
}
