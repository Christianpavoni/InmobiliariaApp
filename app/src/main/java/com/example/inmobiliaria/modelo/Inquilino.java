package com.example.inmobiliaria.modelo;

import java.math.BigInteger;
public class Inquilino {

    private int idInquilino;
    private String apellido;
    private String nombre;
    private BigInteger dni;
    private BigInteger telefono;
    private String email;
    private String lugarDeTranajo;
    private String nombreGarante;
    private BigInteger dniGarante;
    private BigInteger telefonoGarante;
    private String emailGarante;

    public Inquilino() {
    }

    public Inquilino(int idInquilino, String apellido, String nombre, BigInteger dni, BigInteger telefono, String email, String lugarDeTranajo, String nombreGarante, BigInteger dniGarante, BigInteger telefonoGarante, String emailGarante) {
        this.idInquilino = idInquilino;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.lugarDeTranajo = lugarDeTranajo;
        this.nombreGarante = nombreGarante;
        this.dniGarante = dniGarante;
        this.telefonoGarante = telefonoGarante;
        this.emailGarante = emailGarante;
    }

    public int getIdInquilino() {
        return idInquilino;
    }

    public void setIdInquilino(int idInquilino) {
        this.idInquilino = idInquilino;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigInteger getDni() {
        return dni;
    }

    public void setDni(BigInteger dni) {
        this.dni = dni;
    }

    public BigInteger getTelefono() {
        return telefono;
    }

    public void setTelefono(BigInteger telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLugarDeTranajo() {
        return lugarDeTranajo;
    }

    public void setLugarDeTranajo(String lugarDeTranajo) {
        this.lugarDeTranajo = lugarDeTranajo;
    }

    public String getNombreGarante() {
        return nombreGarante;
    }

    public void setNombreGarante(String nombreGarante) {
        this.nombreGarante = nombreGarante;
    }

    public BigInteger getDniGarante() {
        return dniGarante;
    }

    public void setDniGarante(BigInteger dniGarante) {
        this.dniGarante = dniGarante;
    }

    public BigInteger getTelefonoGarante() {
        return telefonoGarante;
    }

    public void setTelefonoGarante(BigInteger telefonoGarante) {
        this.telefonoGarante = telefonoGarante;
    }

    public String getEmailGarante() {
        return emailGarante;
    }

    public void setEmailGarante(String emailGarante) {
        this.emailGarante = emailGarante;
    }
}

