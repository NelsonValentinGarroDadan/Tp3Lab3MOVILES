package com.example.tp3lab3moviles.ui.Registro;


import static android.app.Activity.RESULT_OK;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tp3lab3moviles.Models.Usuario;
import com.example.tp3lab3moviles.Request.ApiClient;
import com.example.tp3lab3moviles.ui.Login.MainActivity;

import java.io.ByteArrayOutputStream;


public class RegistroActivityViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<Usuario> UsuarioM;
    private MutableLiveData<Bitmap> foto;
    public RegistroActivityViewModel(@NonNull Application application) {
        super(application);
        this.context = application;
    }
    public LiveData getMutable(){
        if(UsuarioM == null){
            UsuarioM = new MutableLiveData();
        }
        return UsuarioM;
    }
    public LiveData getFoto(){
        if(foto == null){
            foto = new MutableLiveData();
        }
        return foto;
    }
    public void tomarFoto(Bitmap bitmap){
        foto.setValue(bitmap);
    }
    public void Registrarse(boolean bol){

        Usuario user = new Usuario("","","","","");
        Bitmap bitmap = Bitmap.createBitmap(90, 90, Bitmap.Config.ARGB_8888);
        if(bol){
            user = ApiClient.leer(context);
            bitmap = ApiClient.leerFoto(context);
        }
        foto.setValue(bitmap);
        UsuarioM.setValue(user);
    }
    public void respuetaDeCamara(int requestCode, int resultCode, @Nullable Intent data, int REQUEST_IMAGE_CAPTURE) {

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            //Recupero los datos provenientes de la camara.
            Bundle extras = data.getExtras();
            //Casteo a bitmap lo obtenido de la camara.
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            //Rutina para optimizar la foto,
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
            foto.setValue(imageBitmap);

            byte[] b = baos.toByteArray();
            ApiClient.guardarFoto(context, b);
        }
    }
    public void guardar(Usuario usuario){
        //validar datos
        ApiClient.guardar(context,usuario);
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
