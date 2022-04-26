package tumanov_yevgen_tareaut7;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Tumanov_Yevgen_TareaUT7 {

    public static void main(String[] args) {
        // TODO code application logic here
        // Declaramos las variables
        int opcionMenu;
        int parcelasDias[][] = new int[6][32];
        int numParcela = 0;
        HashMap<Integer, Cliente> listaClientes = new HashMap<>(); // lista clientes
        HashMap<Integer, Alojamiento> listaAlojamientos = new HashMap<>(); // lista alojamientos
        HashMap<Integer, Reserva> listaReservas = new HashMap<>(); // lista reservas
        do {
            System.out.println(menu());
            System.out.print("Opcion elegida: ");
            opcionMenu = intInput(1, 9);
            switch (opcionMenu) {
                case 1:
                    System.out.println("1. Ver clientes");
                    mostrarListaClientes(listaClientes, listaAlojamientos);
                    mostrarDatosCliente(listaClientes, listaAlojamientos);
                    break;
                case 2:
                    System.out.println("2. Dar de alta un cliente");
                    darDeAltaUnCliente(listaClientes, listaAlojamientos);
                    break;

                case 3:
                    System.out.println("3. Dar de baja un cliente");
                    darDeBajaUnCliente(listaClientes, listaAlojamientos);
                    break;
                case 4:
                    System.out.println("4. Mostrar el número de parcelas libres para un día");
                    visualizarParcelasParaDia(parcelasDias);
                    break;
                case 5:
                    System.out.println("5. Mostrar los días libres para una parcela");
                    visualizarDiasParaParcela(parcelasDias);
                    break;
                case 6:
                    System.out.println("6. Ver reservas");
                    mostrarReservas(listaReservas);
                    break;
                case 7:
                    System.out.println("7. Realizar una reserva");
                    realizarReserva(listaReservas, listaClientes, parcelasDias);
                    break;
                case 8:
                    System.out.println("8. Eliminar una reserva");
                    eliminarReservas(listaReservas, listaClientes, parcelasDias);
                    break;
                case 9:
                    System.out.println("9. Salir");
                    break;
                default:
                    throw new AssertionError();
            }
        } while (opcionMenu != 9);
    }

    static int idCliente = 1;
    static int idReserva = 1;

    public static String menu() {
        return "Elige una opcion: \n "
                + "CLIENTES\n"
                + "\t 1. Ver clientes\n"
                + "\t 2. Dar de alta un cliente\n"
                + "\t 3. Dar de baja un cliente\n"
                + "PARCELAS\n"
                + "\t 4. Mostrar el número de parcelas libres para un día\n"
                + "\t 5. Mostrar los días libres para una parcela\n"
                + "RESERVAS\n"
                + "\t 6. Ver reservas\n"
                + "\t 7. Realizar una reserva\n"
                + "\t 8. Eliminar una reserva\n"
                + "SALIR\n"
                + "\t 9. Salir";
    }

    public static void darDeAltaUnCliente(HashMap<Integer, Cliente> listaClientes, HashMap<Integer, Alojamiento> listaAlojamientos) {
        String NombreCompleto, FechaNac, DNI, modelo;
        String tipoAcaravana = "";
        int opcionAlojamiento, ancho, longitud, longitudTotal, opcionElegdia;
        int idCCrear = idCliente;
        boolean tieneAseo = false;
        boolean tieneMover = false;
        Scanner inAlta = new Scanner(System.in);
        System.out.print("Introduzca el nombre del cliente: ");
        NombreCompleto = inAlta.nextLine();
        System.out.print("Introduzca la fecha de nacimiento: ");
        FechaNac = inAlta.nextLine();
        System.out.print("Introduzca el DNI: ");
        DNI = inAlta.nextLine();
        System.out.print("Eliga el tipo de alojamiento del cliente:\n"
                + "\t1. Caravana \n\t2. Autocaravana \n"
                + "Tipo: ");
        opcionAlojamiento = intInput(1, 2);
        System.out.print("Introduzca el modelo: ");
        modelo = inAlta.nextLine();
        System.out.print("Introduzca la longitud: ");
        longitud = intInput();
        System.out.print("Introduzca el ancho: ");
        ancho = intInput();
        System.out.print("Tiene aseo 1. Si 2. No: ");
        opcionElegdia = intInput(1, 2);
        if (opcionElegdia == 1) {
            tieneAseo = true;
        }
        if (opcionElegdia == 2) {
            tieneAseo = false;
        }
        try {
            // =================== CARAVANA ====================================
            if (opcionAlojamiento == 1) { // Cuando el tipo de alojamiento es una caravana
                System.out.print("Tiene moover 1. Si 2. No: ");
                opcionElegdia = intInput(1, 2);
                if (opcionElegdia == 1) {
                    tieneMover = true;
                }
                if (opcionElegdia == 2) {
                    tieneMover = false;
                }
                System.out.print("Introduzca la longitud total, coche + caravana: ");
                longitudTotal = intInput();
                listaAlojamientos.put(idCCrear, new Caravana(longitudTotal, tieneMover, modelo, longitud, ancho, tieneAseo));
                listaAlojamientos.get(idCCrear).cabeEnParcela(longitudTotal, ancho);
            }
            // =================== AUTO CARAVANA ====================================
            if (opcionAlojamiento == 2) { // Cuando el tipo de alojamiento es una Autocaravana
                System.out.print("Elige el tipo de la Autocaravana:\n1. PERFILADA, 2. CAPUCHINA, 3.INTEGRAL:");
                opcionElegdia = intInput(1, 3);
                if (opcionElegdia == 1) {
                    tipoAcaravana = "PERFILADA";
                }
                if (opcionElegdia == 2) {
                    tipoAcaravana = "CAPUCHINA";
                }
                if (opcionElegdia == 3) {
                    tipoAcaravana = "INTEGRAL";
                }
                listaAlojamientos.put(idCCrear, new Autocaravana(Autocaravana.tipoAC.INTEGRAL, modelo, longitud, ancho, tieneAseo));
                listaAlojamientos.get(idCCrear).cabeEnParcela(longitud, ancho);
            }
        } catch (AlojamientoInvalidoException ex) {
            System.out.println("EL ALOJAMIENTO ES DEMASIADO GRANDE Y NO VA A CABER EN LA PARCELA");
        }
        listaClientes.put(idCCrear, new Cliente(NombreCompleto, DNI, FechaNac, idCCrear, listaAlojamientos.get(idCCrear)));
        System.out.println("Se ha creado un cliente con ID: " + idCCrear + "\nNombre: "
                + NombreCompleto + "\nFecha de nacimiento: " + FechaNac + "\nDNI: " + DNI + "\nAlojamiento: " + listaAlojamientos.get(idCCrear).toString());
        idCliente++;
    }

    public static void darDeBajaUnCliente(HashMap<Integer, Cliente> listaClientes, HashMap<Integer, Alojamiento> listaAlojamientos) {
        int idCEliminar;
        if (listaClientes.size() != 0) {
            try {
                for (Map.Entry<Integer, Cliente> e : listaClientes.entrySet()) {
                    System.out.println("ID:" + e.getValue().getIdCliente() + " Nombre Completo: " + e.getValue().getNombreCompleto());
                }
                System.out.print("Introduzca el ID del cliente para eliminar: ");
                idCEliminar = intInput();
                System.out.println("Se ha eliminado el cliente con ID: " + listaClientes.get(idCEliminar).getIdCliente() + "\nNombre: "
                        + listaClientes.get(idCEliminar).getNombreCompleto() + "\nFecha de nacimiento: " + listaClientes.get(idCEliminar).getFechaNac()
                        + "\nDNI: " + listaClientes.get(idCEliminar).getDNI() + "\nAlojamiento: " + listaAlojamientos.get(idCEliminar).toString());
                listaClientes.remove(idCEliminar);
                listaAlojamientos.remove(idCEliminar);
            } catch (Exception e) {
                System.out.println("No se ha podido eliminar dicho cliente porque no exite");
            }
        } else {
            System.out.println("La lista de clientes esta vacia, cree alguno para empezar.");
        }
    }

    public static void mostrarListaClientes(HashMap<Integer, Cliente> listaClientes, HashMap<Integer, Alojamiento> listaAlojamientos) {
        if (listaClientes.size() != 0) {
            for (Map.Entry<Integer, Cliente> e : listaClientes.entrySet()) {
                System.out.println("ID:" + e.getValue().getIdCliente() + " Nombre Completo: " + e.getValue().getNombreCompleto());
            }
        } else {
            System.out.println("La lista de clientes esta vacia, cree alguno para empezar.");
        }
    }

    public static void mostrarDatosCliente(HashMap<Integer, Cliente> listaClientes, HashMap<Integer, Alojamiento> listaAlojamientos) {
        int idCMostrar;
        if (listaClientes.size() != 0) {
            System.out.print("Introduzca el ID del cliente para ver la informacion sobre el: ");
            try {
                idCMostrar = intInput();
                System.out.println(listaClientes.get(idCMostrar).toString());
                System.out.println("");
            } catch (Exception e) {
                System.out.println("No se han podido mostrar datos del cliente porque no exite");
            }
        }
    }

    public static boolean rangeCheck(int min, int max, int num) {
        return num >= min && num <= max;
    }

    public static int intInput(int min, int max) {
        Scanner in = new Scanner(System.in);
        boolean error;
        int numeroInt = 0;
        do {
            try {
                error = false;
                numeroInt = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Debes introducir un numero entero, vuelva a introducirlo: ");
                error = true;
                in.nextLine();
            }
            if (rangeCheck(min, max, numeroInt)) {
                error = false;
            } else {
                System.out.print("El numero esta fuera de rango, vuelva a introducirlo: ");
                error = true;
            }
        } while (error);
        return numeroInt;
    }

    public static int intInput() {
        Scanner in = new Scanner(System.in);
        boolean error;
        int numeroInt = 0;
        do {
            try {
                error = false;
                numeroInt = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Debes introducir un numero entero, vuelva a introducirlo: ");
                error = true;
                in.nextLine();
            }
        } while (error);
        return numeroInt;
    }

    public static void imprimirMatriz(int m[][]) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] < 10) {
                    System.out.print(m[i][j] + "   ");
                } else {
                    System.out.print(m[i][j] + "  ");
                }
            }
            System.out.println("");
        }
    }

    public static void visualizarParcelasParaDia(int m[][]) {
        System.out.print("Introduzca el dia: ");
        int numDia = intInput(1, 31);
        int auxInt = 0;
        String cadAux = "";
        System.out.println("Leyenda: "
                + "\n\tNumero: es el numero del cliente que tiene reservada esa parcela para ese dia."
                + "\n\tLibre: significa que la parcela esta libre este dia.");
        for (int i = 1; i <= 5; i++) {
            auxInt = m[i][numDia];
            cadAux = Integer.toString(auxInt);
            System.out.println("Parcela " + i + ": " + cadAux.replace("0", "Libre"));
        }
        System.out.println("");
    }

    public static void visualizarDiasParaParcela(int m[][]) {
        System.out.print("Introduzca el numero de parcela: ");
        int numParcela = intInput(1, 5);
        System.out.println("");
        for (int i = 1; i < m[0].length; i++) {
            if (m[0][i] < 10) {
                System.out.print(m[0][i] + " ");
            } else {
                System.out.print(m[0][i] + "  ");
            }
        }
        System.out.println("");
        for (int i = 1; i < m[numParcela].length; i++) {
            if (m[0][i] < 10) {
                System.out.print(m[numParcela][i] + " ");
            } else {
                System.out.print(m[numParcela][i] + "   ");
            }
        }
        System.out.println("");
        System.out.println("");
    }

    public static void realizarReserva(HashMap<Integer, Reserva> listaReservas, HashMap<Integer, Cliente> listaClientes, int parcelasDias[][]) {
        boolean error = true;
        int idClientQueReserva = 0;
        int idResRealizada = idReserva;
        int numParcela, fechaInicio, fechaFin;
        if (!listaClientes.isEmpty()) {
            for (Map.Entry<Integer, Cliente> e : listaClientes.entrySet()) {
                System.out.println("ID:" + e.getValue().getIdCliente() + " Nombre Completo: " + e.getValue().getNombreCompleto());
            }
            System.out.print("Introduzca el ID del cliente: ");
            idClientQueReserva = intInput(1, listaClientes.size());
            try {
                listaClientes.get(idClientQueReserva).getVehiculo().cabeEnParcela(listaClientes.get(idClientQueReserva).getVehiculo().getLongitud(), listaClientes.get(idClientQueReserva).getVehiculo().getAncho());
            } catch (AlojamientoInvalidoException ex) {
                System.out.println("\nNo se puede hacer la reserva para este cliente!"
                        + "\nSu vehiculo es demasiado grande.\n");
                error = false;
            }
            if (error) {
                System.out.print("Introduzca el numero de parcela: ");
                numParcela = intInput(1, 5);
                System.out.print("Introduzca la fecha de inicio: ");
                fechaInicio = intInput(1, 31);
                System.out.print("Introduzca la fecha fin: ");
                fechaFin = intInput(1, 31);
                listaReservas.put(idResRealizada, new Reserva(idResRealizada, listaClientes.get(idClientQueReserva), numParcela, fechaInicio, fechaFin));
                for (int i = fechaInicio; i <= fechaFin; i++) {
                    parcelasDias[numParcela][i] = idClientQueReserva;
                }
                idReserva++;
            }
        } else {
            System.out.println("La lista de clientes esta vacia, cree alguno para empezar.");
        }
    }

    public static void mostrarReservas(HashMap<Integer, Reserva> listaReservas) {
        if (!listaReservas.isEmpty()) {
            for (Map.Entry<Integer, Reserva> e : listaReservas.entrySet()) {
                System.out.println("ID: " + e.getValue().getIdReserva() + " Nombre Completo: "
                        + e.getValue().getCliente().getNombreCompleto() + " Parcela: " + e.getValue().getNumParcela()
                        + " Fecha inicio: " + e.getValue().getFechaInicio() + " Fecha fin: " + e.getValue().getFechaFin());
            }
        } else {
            System.out.println("La lista de reservas esta vacia, cree alguna para empezar.");
        }
    }

    public static void eliminarReservas(HashMap<Integer, Reserva> listaReservas, HashMap<Integer, Cliente> listaClientes, int parcelasDias[][]) {
        int idREliminar;
        if (!listaReservas.isEmpty()) {
            for (Map.Entry<Integer, Reserva> e : listaReservas.entrySet()) {
                System.out.println("ID: " + e.getValue().getIdReserva() + " Nombre Completo: "
                        + e.getValue().getCliente().getNombreCompleto() + " Parcela: " + e.getValue().getNumParcela()
                        + " Fecha inicio: " + e.getValue().getFechaInicio() + " Fecha fin: " + e.getValue().getFechaFin());
            }

            System.out.print("Introduzca el numero de reserva que quiere eliminar: ");
            idREliminar = intInput(1, listaReservas.size());

            for (int i = listaReservas.get(idREliminar).getFechaInicio(); i <= listaReservas.get(idREliminar).getFechaFin(); i++) {
                parcelasDias[listaReservas.get(idREliminar).getNumParcela()][i] = 0;
            }
            listaReservas.remove(idREliminar);
        } else {
            System.out.println("La lista de reservas esta vacia, cree alguna para empezar.");
        }
    }
}