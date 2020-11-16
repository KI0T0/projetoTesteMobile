package com.example.projetoteste;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.projetoteste.database.ConnectionClass;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ActMain extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
              public void onClick(View view) {

            }


        });*/
    }
    public void checkConnection(){
        try {
            Toast.makeText(this, "TEST", Toast.LENGTH_SHORT).show();
            if (ConnectionClass.con == null) { //Checando se existe conexão
                new ConnectionClass().setConnection();
            }
            if (ConnectionClass.con != null) { //Se existir, faça...
                Statement stmt = ConnectionClass.con.createStatement();
                String sql = "select * from cliente"; //Atribuindo query a uma variavel chamada "sql"
                ResultSet rs = stmt.executeQuery(sql); //Atribuindo o resultado dessa query a uma variavel chamada "rs"
                Log.e("ASK", "----------------");
                while (rs.next()) { //"ENQUANTO TIVER ITENS PARA SEREM LIDOS..."
                    Log.e("ASK", rs.getString("cpfClient") + " " + rs.getString("nmClient"));
                }
                Log.e("ASK", "------------------");
                Toast.makeText(getApplicationContext(), R.string.msg_pesquisa_sucesso, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), R.string.msg_pesquisa_falhou, Toast.LENGTH_LONG).show();
            }
        }
        catch(Exception e){
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            Log.e("ASK", e.getMessage());//Mostra o erro no log
            }
    }


    public void cadastrar(View view){
        Intent it = new Intent(ActMain.this, ActCadCliente.class);
        startActivity(it);
        checkConnection();
    }
}