package com.example.inmobiliaria.modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Inmueble implements Serializable {
    private int idInmueble;
    private String direccion;
    private int cantDeAmbientes;
    private String tipoDeInmueble;
    private String tipoDeUso;
    private int precio;
    private String estado;
    private String foto;
    private int idPropietario;




    public Inmueble() {

    }

    public Inmueble(int idInmueble,String direccion, int cantDeAmbientes, String tipoDeInmueble, String tipoDeUso, int precio, String estado, String foto, int idPropietario) {
        this.idInmueble=idInmueble;
        this.direccion = direccion;
        this.cantDeAmbientes = cantDeAmbientes;
        this.tipoDeInmueble = tipoDeInmueble;
        this.tipoDeUso = tipoDeUso;
        this.precio = precio;
        this.estado = estado;
        this.foto = foto;
        this.idPropietario=idPropietario;

    }

    public int getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        this.idInmueble = idInmueble;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCantDeAmbientes() {
        return cantDeAmbientes;
    }

    public void setCantDeAmbientes(int cantDeAmbientes) {
        this.cantDeAmbientes = cantDeAmbientes;
    }

    public String getTipoDeInmueble() {
        return tipoDeInmueble;
    }

    public void setTipoDeInmueble(String tipoDeInmueble) {
        this.tipoDeInmueble = tipoDeInmueble;
    }

    public String getTipoDeUso() {
        return tipoDeUso;
    }

    public void setTipoDeUso(String tipoDeUso) {
        this.tipoDeUso = tipoDeUso;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
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
