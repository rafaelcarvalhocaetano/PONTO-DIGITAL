package com.pontodigital.pontodigital;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by rafael on 24/01/18.
 */

public class CadastroActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar_empresa);

        //XX.XXX.XXX/0001-XX  cnpj
        /*
        SimpleMaskFormatter smf = new SimpleMaskFormatter("NN/NN/NNNN");
            MaskTextWatcher mtw = new MaskTextWatcher(myEditText, msf)
            myEditText.addTextChangedListener(mtw);
         */
    }
}
