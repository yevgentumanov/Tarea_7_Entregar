/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tumanov_yevgen_tareaut7;

/**
 *
 * @author Euu
 */
public interface Suitable {
    
    void cabeEnParcela(int longitud, int ancho) throws AlojamientoInvalidoException;

}


class AlojamientoInvalidoException extends Exception {
        public AlojamientoInvalidoException() {
    }
    public AlojamientoInvalidoException(String mensaje) {
        super(mensaje);
    }
}