/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tumanov_yevgen_tareaut7;

import java.util.Objects;

/**
 *
 * @author Euu
 */
public class Reserva {

    private Cliente cliente;
    private int idReserva;
    private int numParcela, fechaInicio, fechaFin;

    public Reserva(int idReserva, Cliente cliente, int numParcela, int fechaInicio, int fechaFin) {
        this.cliente = cliente;
        this.idReserva = idReserva;
        this.numParcela = numParcela;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getNumParcela() {
        return numParcela;
    }

    public void setNumParcela(int numParcela) {
        this.numParcela = numParcela;
    }

    public int getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(int fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(int fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reserva other = (Reserva) obj;
        if (this.numParcela != other.numParcela) {
            return false;
        }
        if (this.fechaInicio != other.fechaInicio) {
            return false;
        }
        if (this.fechaFin != other.fechaFin) {
            return false;
        }
        return Objects.equals(this.cliente, other.cliente);
    }

    @Override
    public String toString() {
        return "Reserva{" + "cliente=" + cliente + ", numParcela=" + numParcela + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + '}';
    }

}
