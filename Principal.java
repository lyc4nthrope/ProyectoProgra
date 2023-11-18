import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * AUTORES:
 * Daniel Perez
 * Camilo Ospina (El mas guapo)
 * Cristhian Osorio
 */

public class Principal {
    static ArrayList<Torneo> torneos = new ArrayList<>();

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

        int optionPrincipal = 0;
        do {
            optionPrincipal = pedirInt("1. Crear torneo\n 2. Entrar al torneo\n 3. salir", null);

            if (optionPrincipal == 1) {
                String nombre = "";
                do {
                    nombre = pedir("ingrese el nombre del torneo", null);
                    if (existeTorneoNombre(nombre)) {
                        JOptionPane.showMessageDialog(null, "El nombre de ese torneo ya exite, intente otro por favor");
                    }
                } while (existeTorneoNombre(nombre));

                LocalDateTime fecha = pedirFechaHora("ingrese la fecha y hora del inicio del torneo", null);
                int limiteEdad = pedirInt("Ingrese la edad minima para participar", null);
                String deporte = pedir("ingrese el deporte del torneo", null);
                int limiteJugador = pedirInt("Ingrese el numero de jugadores maximo", null);
                Genero genero = pedirGenero();
                TipoTorneo tipoTorneo = pedirTipoTorneo();
                LocalDateTime fechaInicioIncripciones = pedirFechaHora("Ingrese la fecha de Inicio de Incripciones",
                        null);
                LocalDateTime fechaCierreIncripciones = pedirFechaHora("Ingrese la fecha del Cierre de Inscripciones",
                        null);
                float precioInscripcion = pedirFloat("Ingrese el valor de incripcion", null);

                Torneo torneo = new Torneo(nombre, fecha, limiteEdad, deporte, limiteJugador, genero, tipoTorneo,
                        fechaInicioIncripciones, fechaCierreIncripciones,
                        precioInscripcion);
                torneos.add(torneo);

            }
            if (optionPrincipal == 2) {

                String nombreTorneo = pedir("Ingrese el nombre del torneo a observar", null);
                if (existeTorneoNombre(nombreTorneo)) {
                    int indiceTorneo = indiceTorneo(nombreTorneo);

                    int optionSecundaria = 0;
                    do {
                        optionSecundaria = pedirInt(
                                "1. Añadir equipo\n 2. modificar fechas\n 3. enfrentamientos\n 4. ver equipos\n 5. ver jueces\n6. aniadir juez\n 7. volver",
                                null);

                        if (optionSecundaria == 1) {
                            torneos.get(indiceTorneo).añadirEquipo();
                        }
                        if (optionSecundaria == 2) {
                            torneos.get(indiceTorneo).modificarFechaMenu();
                        }
                        if (optionSecundaria == 3) {
                            int optionTerciaria = 0;

                            do {
                                optionTerciaria = pedirInt(
                                        "1. general\n 2. buscar por equipos\n 3. buscar por juez\n 4. resultados\n 5. modificar enfrentamientos\n 6. Crear Enfrentamiento\n7. Volver",
                                        null);

                                if (optionTerciaria == 1) {
                                    torneos.get(indiceTorneo).mostrarEnfrentamientos();
                                }
                                if (optionTerciaria == 2) {
                                    torneos.get(indiceTorneo).buscarPorEquipos();
                                }
                                if (optionTerciaria == 3) {
                                    torneos.get(indiceTorneo).enfrentamientoJuez();
                                }
                                if (optionTerciaria == 4) {
                                    torneos.get(indiceTorneo).resultadosEnfrentamientos();
                                }
                                if (optionTerciaria == 5) {
                                    torneos.get(indiceTorneo).modificarEnfrentamientos();
                                }
                                if (optionTerciaria==6) {
                                    torneos.get(indiceTorneo).crearEnfrentamientos();
                                }
                            } while (optionTerciaria != 7);
                        }
                        if (optionSecundaria == 4) {
                            torneos.get(indiceTorneo).verEquipos();
                        }
                        if (optionSecundaria == 5) {
                            torneos.get(indiceTorneo).verJueces();
                        }
                        if (optionSecundaria == 6) {
                            torneos.get(indiceTorneo).añadirJuez();
                        }

                    } while (optionSecundaria != 7);

                } else {
                    JOptionPane.showMessageDialog(null, "Torneo buscado no encontrado");
                }
                if (optionPrincipal == 3) {
                    System.exit(0);
                }
            }
        } while (optionPrincipal != 3);

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

    public static float pedirFloat(String msj, String text) {
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
                msj + " en este formato con barras, puntos y comas (YYYY/MM/DD, HH:mm)", text);
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd, HH:mm");
            LocalDateTime fechaHecha = LocalDateTime.parse(fecha, formatter);
            return fechaHecha;
        } catch (Exception e) {
            return pedirFechaHora("Error al ingresar, intente de nuevo\n" + msj, fecha);
        }

    }

    public static TipoTorneo pedirTipoTorneo() {
        TipoTorneo torneo = null;
        do {
            String textTorneo = pedir("Ingrese el tipo de torneo: \nLOCAL \nREGIONAL \nNACIONAL\nMUNDIAL", null);
            if (textTorneo.equalsIgnoreCase("LOCAL")) {
                torneo = TipoTorneo.LOCAL;
            }
            if (textTorneo.equalsIgnoreCase("REGIONAL")) {
                torneo = TipoTorneo.REGIONAL;
            }
            if (textTorneo.equalsIgnoreCase("NACIONAL")) {
                torneo = TipoTorneo.NACIONAL;
            }
            if (textTorneo.equalsIgnoreCase("MUNDIAL")) {
                torneo = TipoTorneo.MUNDIAL;
            }
            if (torneo == null) {
                JOptionPane.showMessageDialog(null, "Tipo Ingresado invalido");
            }
        } while (torneo == null);
        return torneo;
    }

    public static Genero pedirGenero() {
        Genero genero = null;
        do {
            String generoString = pedir("Ingrese el genero del torneo: \n" + //
                    "MASCULINO \n" + //
                    "FEMENINO \n" + //
                    "MIXTO", null);
            if (generoString.equalsIgnoreCase("MASCULINO")) {
                genero = Genero.MASCULINO;
            }
            if (generoString.equalsIgnoreCase("FEMENINO")) {
                genero = Genero.FEMENINO;
            }
            if (generoString.equalsIgnoreCase("MIXTO")) {
                genero = Genero.MIXTO;
            }
            if (genero == null) {
                JOptionPane.showMessageDialog(null, "Tipo Ingresado invalido");
            }
        } while (genero == null);
        return genero;
    }

    public static boolean existeTorneoNombre(String nombreTorneo) {
        boolean estaTorneo = false;
        for (int i = 0; i < torneos.size() && !estaTorneo; i++) {
            if (nombreTorneo.equalsIgnoreCase(torneos.get(i).getNombre())) {
                estaTorneo = true;
            }
        }
        return estaTorneo;
    }

    public static int indiceTorneo(String nombreTorneo) {
        boolean estaTorneo = false;
        int indice = -1;
        for (int i = 0; i < torneos.size() && !estaTorneo; i++) {
            if (nombreTorneo.equalsIgnoreCase(torneos.get(i).getNombre())) {
                estaTorneo = true;
                indice = i;
            }
        }
        return indice;
    }
    public static void verTorneos(){
        String listaTorneos = "";
        for (Torneo torneo : torneos) {
            listaTorneos+=torneo.toString();
        }
        JOptionPane.showMessageDialog(null, listaTorneos);
    }
}
