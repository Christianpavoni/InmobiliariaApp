package com.example.inmobiliaria.modelo;

import java.math.BigInteger;

public class Propietario {
    private int idPropietario;
    private String nombre;
    private String apellido;
    private String email;
    private String clave;
    private String telefono;
    private String dni;

    public Propietario() {
    }

    public Propietario(int idPropietario,String nombre, String apellido, String email, String clave,String telefono,String dni) {
        this.idPropietario=idPropietario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.clave = clave;
        this.telefono=telefono;
        this.dni=dni;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
