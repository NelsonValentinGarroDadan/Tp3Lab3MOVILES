package com.example.tp3lab3moviles.ui.Login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.tp3lab3moviles.Models.Usuario;
import com.example.tp3lab3moviles.Request.ApiClient;
import com.example.tp3lab3moviles.ui.Registro.RegistroActivity;


public class MainActivityViewModel extends AndroidViewModel {
    private Context context;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.context = application;
    }
    public void login(String mail,String password){
        if(mail.length()<1 || password.length()<1){
            Toast.makeText(context, "Ambos campos son obligatorios",Toast.LENGTH_LONG).show();

        }else{
            Usuario user= ApiClient.login(context,mail,password);
            if(user == null){
                Toast.makeText(context, "Mail o Contraseña incorrecta",Toast.LENGTH_LONG).show();
            }else{
                Intent intent = new Intent(context, RegistroActivity.class);
                intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Boolean",true);
                context.startActivity(intent);
            }
        }


    }
    public void irRegistro(){
        Intent intent = new Intent(context, RegistroActivity.class);
        intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("Boolean",false);
        context.startActivity(intent);
    }
}
