package com.example.inmobiliaria.modelo;

import java.math.BigInteger;

public class Propietario {
    private int idPropietario;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private BigInteger telefono;

    public Propietario() {
    }

    public Propietario(int idPropietario,String nombre, String apellido, String email, String password,BigInteger telefono) {
        this.idPropietario=idPropietario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.telefono=telefono;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public BigInteger getTelefono() {
        return telefono;
    }

    public void setTelefono(BigInteger telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
