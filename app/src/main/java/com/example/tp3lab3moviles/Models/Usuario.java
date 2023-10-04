package com.example.tp3lab3moviles.Models;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String DNI;
    private String Nombre;
    private String Apellido;
    private String Mail;
    private String Password;


    public Usuario(String DNI, String nombre, String apellido, String mail, String password) {
        this.DNI = DNI;
        Nombre = nombre;
        Apellido = apellido;
        Mail = mail;
        Password = password;
    }




    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @NonNull
    @Override
    public String toString() {
        return  "Usuario:{DNI: "+this.DNI+
                ",Nombre: "+this.Nombre+
                ",Apellido: "+this.Apellido+
                ",Mail: "+this.Mail+
                ",Password: "+this.Password+
                "}";
    }
}
