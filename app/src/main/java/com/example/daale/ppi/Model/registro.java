package com.example.daale.ppi.Model;

import java.io.Serializable;

/**
 * Created by daale on 25/10/2017.
 */

public class registro implements Serializable{
    private int id, Documento, fecha_N, Celular;
    private String nombre, apellido, correo, usuario, contraseña;

    public registro(int anInt, int string, int cursorInt){}

    public registro(int id, int Documento, String Nombre, String Apellido, int Fecha_nacimiento, int celular, String correo, String Usuario, String contraseña) {
        this.id = id;
        this.Documento = Documento;
        this.nombre = Nombre;
        this.apellido = Apellido;
        this.fecha_N = Fecha_nacimiento;
        this.Celular = celular;
        this.correo = correo;
        this.usuario = Usuario;
        this.contraseña = contraseña;
    }

    public int getId() {
        return id;
    }

    public int getDocumento() {
        return Documento;
    }

    public int getFecha_N() {
        return fecha_N;
    }

    public int getCelular() {
        return Celular;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    @Override
    public String toString() {
        return "id = " + id +
                "\nnombre = " + nombre +
                "\napellido = " + apellido + "";
    }

}
