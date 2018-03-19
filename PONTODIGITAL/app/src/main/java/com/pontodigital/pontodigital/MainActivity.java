package com.pontodigital.pontodigital;


import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

//config. parse

import com.parse.Parse;
import com.pontodigital.pontodigital.cadastro.LoginActivity;

public class MainActivity extends AppCompatActivity {

    private TextView btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Parse.initialize(this);

        Handler temp = new Handler();

        temp.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity( i );
                finish();
            }
        }, 1200);
    }


}
