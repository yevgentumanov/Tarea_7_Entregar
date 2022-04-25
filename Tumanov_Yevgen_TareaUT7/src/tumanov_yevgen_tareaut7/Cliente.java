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
public class Cliente {

    private int idCliente;
    private String NombreCompleto, DNI, FechaNac;
    private Alojamiento vehiculo;

    public Cliente(String NombreCompleto, String DNI, String FechaNac, int idCliente, Alojamiento vehiculo) {
        this.NombreCompleto = NombreCompleto;
        this.DNI = DNI;
        this.FechaNac = FechaNac;
        this.idCliente = idCliente;
        this.vehiculo = vehiculo;
    }

    public String toString() {
        return "Cliente{" + "ID = " + idCliente + ", Nombre Completo = " + NombreCompleto + ", DNI = " + DNI + ", Fecha Nacimiento = "
                + FechaNac + "\nVehiculo = " + vehiculo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.idCliente;
        hash = 59 * hash + Objects.hashCode(this.NombreCompleto);
        hash = 59 * hash + Objects.hashCode(this.DNI);
        hash = 59 * hash + Objects.hashCode(this.FechaNac);
        hash = 59 * hash + Objects.hashCode(this.vehiculo);
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
        final Cliente other = (Cliente) obj;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (!Objects.equals(this.NombreCompleto, other.NombreCompleto)) {
            return false;
        }
        if (!Objects.equals(this.DNI, other.DNI)) {
            return false;
        }
        if (!Objects.equals(this.FechaNac, other.FechaNac)) {
            return false;
        }
        return Objects.equals(this.vehiculo, other.vehiculo);
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getFechaNac() {
        return FechaNac;
    }

    public void setFechaNac(String FechaNac) {
        this.FechaNac = FechaNac;
    }

    public Alojamiento getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Alojamiento vehiculo) {
        this.vehiculo = vehiculo;
    }

}
