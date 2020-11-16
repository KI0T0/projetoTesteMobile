package com.example.projetoteste.database;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionClass {

    //Essa é a classe de conexão
    public static Connection con;

    public void setConnection(){
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String ip = "192.168.0.111";//Insira seu ip aqui
            String ConnURL = "jdbc:jtds:sqlserver://"+ip+";instance=SQLEXPRESS;user=sa;password=S3cr3t@10!;databasename=dbPIM;";//String de conexão (demorei 1 dia para conectar o banco pois estava colocando errado "jbdc" em vez de "jdbc"
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();//Cria classe
            con = DriverManager.getConnection(ConnURL);//Cria conexão
            Log.e("ASK","Connection Called");

        }
        catch (Exception e){
            Log.e("ASK","EXCEPTION "+e.getMessage());
        }
    }




}
