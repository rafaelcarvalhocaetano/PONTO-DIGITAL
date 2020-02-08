package com.pontodigital.pontodigital;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.parse.ParseUser;
import com.pontodigital.pontodigital.cadastro.LoginActivity;

/**
 * Created by rafael on 19/03/18.
 */

public class PostoActivity extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posto);

        btn = (Button) findViewById(R.id.btn_logout);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOut();
                Intent i = new Intent(PostoActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
