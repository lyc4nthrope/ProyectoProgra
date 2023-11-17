import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

/**
 * AUTORES:
 * Daniel Perez
 * Camilo Ospina (El mas guapo)
 * Cristhian Osorio
 */

public class Principal {
    public static void main(String[] args) {
        // el menu va a ser de la siguiente manera:

        /**
         * MENU
         * 1. Crear torneo
         * 2. Entrar a torneo
         * 3. salir
         * 
         * 1. en crear torneo se va a llamar al constructor por asi decirlo
         * 
         * 2.
         * a. Añadir equipo, cuando se unda añadir equipo se llama comparar fecha
         * b. modificar fechas
         * 
         * c. enfrentamientos
         * d. equipos
         * e. jueces
         * f. volver
         * 
         * C. en c se llenarian los campos referente a los equipos y todo lo demas
         * 
         * 1. general
         * 2. buscar por equipos
         * 3. buscar por juez
         * 4. resultados
         * 5. modificar enfrentamientos
         * 
         */

        int op = 0;
        do {
            op = Integer.parseInt(pedir("1. Crear torneo\n 2. Entrar al torneo\n 3. salir", null));

            if (op == 1) {
                String nombre = pedir("ingrese el nombre del torneo", null);
                LocalDateTime fecha = pedirFechaHora("ingrese la fecha y hora del torneo", null);
                int limiteEdad = pedirInt("Ingrese la edad minima para participar", null);
                String deporte = pedir("ingrese el deporte del torneo", null);
                int limiteJugador = pedirInt("Ingrese el numero de jugadores maximo", null);
                String gen = pedir("ingrese el genero del torneo: \nMASCULINO \nFEMENINO \nMIXTO;", null);
                Genero genero = null;
                do {

                    if (gen.equalsIgnoreCase("MASCULINO")) {
                        genero = Genero.MASCULINO;
                    }
                    if (gen.equalsIgnoreCase("FEMENINO")) {
                        genero = Genero.FEMENINO;
                    }
                    if (gen.equalsIgnoreCase("MIXTO")) {
                        genero = Genero.MIXTO;
                    }
                } while (genero == null);

                Torneo torneo = new Torneo(nombre, fecha, limiteEdad, deporte, limiteJugador, genero, null, null, null,
                        op);

            }
            if (op == 2) {

                int option = 0;
                do {
                    option = Integer.parseInt(pedir(
                            "1. Añadir equipo\n 2. modificar fechas\n 3. enfrentamientos\n 4. equipos\n 5. jueces\n 6. volver",
                            null));

                    if (option == 1) {

                    }
                    if (option == 2) {

                    }
                    if (option == 3) {
                        int optionn = 0;

                        do {
                            optionn = Integer.parseInt(pedir(
                                    "1. general\n 2. buscar por equipos\n 3. buscar por juez\n 4. resultados\n 5. modificar enfrentamientos\n 6. volver",
                                    null));
                        } while (optionn != 6);

                        if (option == 4) {

                        }
                        if (option == 5) {

                        }
                        if (option == 6) {

                        }
                        if (option == 4) {

                        }
                        if (option == 5) {

                        }
                        if (option == 6) {

                        }
                    }
                    if (option == 4) {

                    }
                    if (option == 5) {

                    }
                    if (option == 6) {

                    }
                } while (option != 6);

            }
            if (op == 3) {
                System.exit(0);
            }
        } while (op != 3);

    }

    public static String pedir(String msj, String text) {
        return JOptionPane.showInputDialog(null, msj, text);
    }

    public static int pedirInt(String msj, String text) {
        String numero = pedir(msj, text);
        try {
            int numTrue = Integer.parseInt(numero);
            return numTrue;
        } catch (Exception e) {
            // TODO: handle exception
            return pedirInt("Error al ingresae\n" + msj, numero);
        }
    }

    public float pedirFloat(String msj, String text) {
        String numero = pedir(msj, text);
        try {
            float numTrue = Float.parseFloat(numero);
            return numTrue;
        } catch (java.util.InputMismatchException e) {
            // TODO: handle exception
            return pedirFloat("Error al ingresar\n" + msj, numero);
        }
    }

    public static LocalDateTime pedirFechaHora(String msj, String text) {
        String fecha = JOptionPane.showInputDialog(null,
                msj + "en este formato con barras, puntos y comas (YYYY/MM/DD, HH:mm)", text);
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd, HH:mm");
            LocalDateTime fechaHecha = LocalDateTime.parse(fecha, formatter);
            return fechaHecha;
        } catch (Exception e) {
            return pedirFechaHora("Error al ingresar, intente de nuevo\n" + msj, fecha);
        }

    }

}
