package com.example.inmobiliaria.modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Inmueble implements Serializable {
    private int IdInmueble;
    private String Direccion;
    private int CantDeAmbientes;
    private String TipoDeInmueble;
    private String TipoDeUso;
    private Double Precio;
    private Boolean Disponible;
    private int Foto;
    private int IdPropietario;
    private Propietario Propietario;


    public Inmueble() {

    }

    public Inmueble(int idInmueble,String direccion, int cantDeAmbientes, String tipoDeInmueble, String tipoDeUso, Double precio, Boolean disponible, int foto, int idPropietario,Propietario propietario) {
        IdInmueble=idInmueble;
        Direccion = direccion;
        CantDeAmbientes = cantDeAmbientes;
        TipoDeInmueble = tipoDeInmueble;
        TipoDeUso = tipoDeUso;
        Precio = precio;
        Disponible = disponible;
        Foto = foto;
        IdPropietario=idPropietario;
        Propietario=propietario;
    }

    public int getIdInmueble() {
        return IdInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        IdInmueble = idInmueble;
    }

    public com.example.inmobiliaria.modelo.Propietario getPropietario() {
        return Propietario;
    }

    public void setPropietario(com.example.inmobiliaria.modelo.Propietario propietario) {
        Propietario = propietario;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public int getCantDeAmbientes() {
        return CantDeAmbientes;
    }

    public void setCantDeAmbientes(int cantDeAmbientes) {
        CantDeAmbientes = cantDeAmbientes;
    }

    public String getTipoDeInmueble() {
        return TipoDeInmueble;
    }

    public void setTipoDeInmueble(String tipoDeInmueble) {
        TipoDeInmueble = tipoDeInmueble;
    }

    public String getTipoDeUso() {
        return TipoDeUso;
    }

    public void setTipoDeUso(String tipoDeUso) {
        TipoDeUso = tipoDeUso;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double precio) {
        Precio = precio;
    }

    public Boolean getDisponible() {
        return Disponible;
    }

    public void setDisponible(Boolean disponible) {
        Disponible = disponible;
    }

    public int getFoto() {
        return Foto;
    }

    public void setFoto(int foto) {
        Foto = foto;
    }

    static public ArrayList<String> getTipoDeInmuebles(){

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Local");
        arrayList.add("Deposito");
        arrayList.add("Casa");
        arrayList.add("Departamento");

        return arrayList;
    }

    static public ArrayList<String> getTipoDeUsos(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Comercial");
        arrayList.add("Residencial");


        return arrayList;
    }
}
