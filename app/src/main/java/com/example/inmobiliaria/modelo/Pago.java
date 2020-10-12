package com.example.inmobiliaria.modelo;

import java.util.Date;

public class Pago {

    private int idPago;
    private double importe;
    private Date fechaDePago;
    private int idContrato;
    private Contrato contrato;


    private Pago() {}

    public Pago(int idPago, double importe, Date fechaDePago, int idContrato, Contrato contrato) {
        this.idPago = idPago;
        this.importe = importe;
        this.fechaDePago = fechaDePago;
        this.idContrato = idContrato;
        this.contrato = contrato;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Date getFechaDePago() {
        return fechaDePago;
    }

    public void setFechaDePago(Date fechaDePago) {
        this.fechaDePago = fechaDePago;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
}
