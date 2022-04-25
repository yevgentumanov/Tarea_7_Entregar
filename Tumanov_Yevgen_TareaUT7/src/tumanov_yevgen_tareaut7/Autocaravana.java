/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tumanov_yevgen_tareaut7;

/**
 *
 * @author Euu
 */
public class Autocaravana extends Alojamiento {

    enum tipoAC {
        PERFILADA, CAPUCHINA, INTEGRAL
    };
    private final int anchoStd = 235;
    private tipoAC tipo;

    public Autocaravana(tipoAC tipo, String modelo, int longitud, int ancho, boolean tieneAseo) {
        super(modelo, longitud, ancho, tieneAseo);
        this.tipo = tipo;
    }

    public tipoAC getTipo() {
        return tipo;
    }

    public void setTipo(tipoAC tipo) {
        this.tipo = tipo;
    }

    @Override
    public void cabeEnParcela(int longitud, int ancho) throws AlojamientoInvalidoException {
        super.cabeEnParcela(longitud, ancho); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String toString() {
        return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
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

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public int hashCode() {
        return super.hashCode(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public int getAnchoStd() {
        return anchoStd;
    }

}
