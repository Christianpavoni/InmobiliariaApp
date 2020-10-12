package com.example.inmobiliaria.modelo;

import java.io.Serializable;
import java.util.Date;

public class Contrato implements Serializable {
    private int idContrato;
    private String detalle;
    private Date fechaDeInicio;
    private Date fechaDeFinalizacion;
    private double monto;
    private int idInquilino;
    private Inquilino inquilino;
    private int idInmueble;
    private Inmueble inmueble;

    public Contrato() {
    }

    public Contrato(int idContrato, String detalle, Date fechaDeInicio, Date fechaDeFinalizacion, double monto, int idInquilino, Inquilino inquilino, int idInmueble, Inmueble inmueble) {
        this.idContrato = idContrato;
        this.detalle = detalle;
        this.fechaDeInicio = fechaDeInicio;
        this.fechaDeFinalizacion = fechaDeFinalizacion;
        this.monto = monto;
        this.idInquilino = idInquilino;
        this.inquilino = inquilino;
        this.idInmueble = idInmueble;
        this.inmueble = inmueble;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Date getFechaDeInicio() {
        return fechaDeInicio;
    }

    public void setFechaDeInicio(Date fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }

    public Date getFechaDeFinalizacion() {
        return fechaDeFinalizacion;
    }

    public void setFechaDeFinalizacion(Date fechaDeFinalizacion) {
        this.fechaDeFinalizacion = fechaDeFinalizacion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getIdInquilino() {
        return idInquilino;
    }

    public void setIdInquilino(int idInquilino) {
        this.idInquilino = idInquilino;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public int getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        this.idInmueble = idInmueble;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }
}
