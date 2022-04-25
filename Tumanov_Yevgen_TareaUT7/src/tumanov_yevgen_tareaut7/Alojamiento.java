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
public abstract class Alojamiento implements Suitable {

    private String modelo;
    private int longitud;
    private int ancho;
    private boolean tieneAseo;

    public Alojamiento(String modelo, int longitud, int ancho, boolean tieneAseo) {
        this.modelo = modelo;
        this.longitud = longitud;
        this.ancho = ancho;
        this.tieneAseo = tieneAseo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.modelo);
        hash = 41 * hash + this.longitud;
        hash = 41 * hash + this.ancho;
        hash = 41 * hash + (this.tieneAseo ? 1 : 0);
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
        final Alojamiento other = (Alojamiento) obj;
        if (this.longitud != other.longitud) {
            return false;
        }
        if (this.ancho != other.ancho) {
            return false;
        }
        if (this.tieneAseo != other.tieneAseo) {
            return false;
        }
        return Objects.equals(this.modelo, other.modelo);
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public boolean isTieneAseo() {
        return tieneAseo;
    }

    public void setTieneAseo(boolean tieneAseo) {
        this.tieneAseo = tieneAseo;
    }

    @Override
    public String toString() {
        return "Alojamiento{" + "modelo=" + modelo + ", longitud=" + longitud + ", ancho=" + ancho + ", tieneAseo=" + tieneAseo + '}';
    }

    @Override
    public void cabeEnParcela(int longitud, int ancho) throws AlojamientoInvalidoException {
        int longitudParcela = 1000;
        int anchuraParcela = 500;
        if (longitudParcela < longitud) {
            throw new AlojamientoInvalidoException("El alojamiento no cabe en la parcela.");
        }
        if (anchuraParcela < ancho) {
            throw new AlojamientoInvalidoException("El alojamiento no cabe en la parcela.");
        }
    }
}

class AlojamientoInvalidoException extends Exception {

    public AlojamientoInvalidoException() {
    }

    public AlojamientoInvalidoException(String mensaje) {
        super(mensaje);
    }
}
