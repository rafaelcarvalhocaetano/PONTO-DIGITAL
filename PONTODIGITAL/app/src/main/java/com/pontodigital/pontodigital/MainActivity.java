package com.pontodigital.pontodigital;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ViewGroup root = (ViewGroup) findViewById(R.id.pd);
        animation(root);


    }

    public void animation(ViewGroup v){
        TransitionManager.beginDelayedTransition(v, new Slide());
        startActivity(new Intent(MainActivity.this, Acesso.class));
        finish();
    }
}
