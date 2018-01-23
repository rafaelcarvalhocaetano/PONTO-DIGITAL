package com.pontodigital.pontodigital;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;


/**
 * Created by rafael on 21/01/18.
 */

public class Acesso extends AppCompatActivity {


    private CardView cv;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acesso);

        cv = (CardView) findViewById(R.id.card);

        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Acesso.this, AcessoPosto.class);
                startActivity(i);
                finish();
            }
        });
    }
}
