package com.pontodigital.pontodigital;

import android.annotation.SuppressLint;
import android.content.Intent;
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
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.pontodigital.pontodigital.adapter.PostosAdapter;
import com.pontodigital.pontodigital.cadastro.CadastroPostoActivity;
import com.pontodigital.pontodigital.cadastro.LoginActivity;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;


/**
 * Created by rafael on 19/03/18.
 */

public class EmpresaActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private TextView user;
    private TextView cnpj;

    private TextView us;
    private TextView cn;

    private ListView lista;
    private ArrayAdapter<ParseUser> adapter;
    private ArrayList<ParseUser> usuarios;
    private ParseQuery<ParseUser> query;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa);


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toobar_pd);
        navigationView = (NavigationView) findViewById(R.id.navigation);

        //listando os postos
        usuarios = new ArrayList<>();
        lista = (ListView) findViewById(R.id.list_view_posto);
        adapter = new PostosAdapter(EmpresaActivity.this, usuarios);
        lista.setAdapter( adapter );



        getUsuario();


        //Configurando o toobar
        setSupportActionBar(toolbar);

        //Confirgurando o ActionBarDrawerToogle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener( toggle );
        toggle.syncState();

        //Configurando o navigationView e atribuindo o click no menu
        navigationView.setNavigationItemSelectedListener( this );

        //metodo responsável por atribuir valores ao textview do nav-header
        attValue();

    }

    private void getUsuario(){

        query = ParseUser.getQuery();

        //esta query elimina o usuário logado
        query.whereEqualTo("username", ParseUser.getCurrentUser().getUsername());
        query.orderByAscending("username");

        query.findInBackground(new FindCallback<ParseUser>() {
            @Override
            public void done(List<ParseUser> objects, ParseException e) {
                if(e == null){
                    //verifica se tem objetos para serem listados
                    if(objects.size() > 0){
                        //limpando a lista
                        usuarios.clear();
                        for (ParseUser u : objects){
                            usuarios.add( u );
                        }
                        adapter.notifyDataSetChanged();


                    }
                }else{
                    e.printStackTrace();
                }
            }
        });


    }

    private void attValue(){
        //Atribuindo valores aos textos dentro do nav_header, tirando do navigationView a linha do header
        View v = navigationView.inflateHeaderView(R.layout.nav_header);

        TextView t1 = (TextView) v.findViewById(R.id.nav_cnpj);
        TextView t2 = (TextView) v.findViewById(R.id.nav_nome_empresa);

        t1.setText(ParseUser.getCurrentUser().getUsername());
        t2.setText( (String) ParseUser.getCurrentUser().get("nomeempresa"));
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
                Intent i = new Intent(EmpresaActivity.this, CadastroPostoActivity.class);
                startActivity(i);
                finish();
                break;
            case R.id.menu_verifica_posto:
                Toast.makeText(this, "VERIFICAÇÃO DE POSTO", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_excluir_posto:
                Toast.makeText(this, "EXCLUSÂO DE POSTO", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_sair:
                Toast.makeText(this, "SAIR", Toast.LENGTH_SHORT).show();
                ParseUser.logOut();
                closeWindows();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START );
        return false;
    }

    private void closeWindows(){
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(i);
        finish();
    }
}
