/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tumanov_yevgen_tareaut7;

/**
 *
 * @author Euu
 */
public class Caravana extends Alojamiento {

    private int longitudTotal;
    private boolean tieneMover;

    public Caravana(int longitudTotal, boolean tieneMover, String modelo, int longitud, int ancho, boolean tieneAseo) {
        super(modelo, longitud, ancho, tieneAseo);
        this.longitudTotal = longitudTotal;
        this.tieneMover = tieneMover;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.longitudTotal;
        hash = 79 * hash + (this.tieneMover ? 1 : 0);
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
        final Caravana other = (Caravana) obj;
        if (this.longitudTotal != other.longitudTotal) {
            return false;
        }
        return this.tieneMover == other.tieneMover;
    }

    @Override
    public String toString() {
        return "Caravana{" + "Modelo = " + super.getModelo() + ", Longitud = " + super.getLongitud() + ", Longitud Total = "
                + longitudTotal + ", Ancho = " + super.getAncho() + ", Tiene Aseo = " + (super.isTieneAseo() ? "Si" : "No")
                + ", Tiene Mover = " + (tieneMover ? "Si" : "No") + '}';
    }

    public int getLongitudTotal() {
        return longitudTotal;
    }

    public void setLongitudTotal(int longitudTotal) {
        this.longitudTotal = longitudTotal;
    }

    public boolean isTieneMover() {
        return tieneMover;
    }

    public void setTieneMover(boolean tieneMover) {
        this.tieneMover = tieneMover;
    }

    @Override
    public void cabeEnParcela(int longitud, int ancho) throws AlojamientoInvalidoException {
        super.cabeEnParcela(longitud, ancho); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setTieneAseo(boolean tieneAseo) {
        super.setTieneAseo(tieneAseo); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public boolean isTieneAseo() {
        return super.isTieneAseo(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setAncho(int ancho) {
        super.setAncho(ancho); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public int getAncho() {
        return super.getAncho(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setLongitud(int longitud) {
        super.setLongitud(longitud); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public int getLongitud() {
        return super.getLongitud(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setModelo(String modelo) {
        super.setModelo(modelo); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String getModelo() {
        return super.getModelo(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
