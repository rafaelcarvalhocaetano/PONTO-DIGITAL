package com.pontodigital.pontodigital;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;


/**
 * Created by rafael on 19/03/18.
 */

public class EmpresaActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa);


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toobar_pd);
        navigationView = (NavigationView) findViewById(R.id.navigation);

        //Configurando o toobar
        setSupportActionBar(toolbar);

        //Confirgurando o ActionBarDrawerToogle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener( toggle );
        toggle.syncState();

        //Configurando o navigationView e atribuindo o click no menu
        navigationView.setNavigationItemSelectedListener( this );


    }

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.menu_cad_posto:
                Toast.makeText(this, "CADASTRAMENTO DE POSTO", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_verifica_posto:
                Toast.makeText(this, "VERIFICAÇÃO DE POSTO", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_excluir_posto:
                Toast.makeText(this, "EXCLUSÂO DE POSTO", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_sair:
                Toast.makeText(this, "SAIR", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START );
        return false;
    }
}
