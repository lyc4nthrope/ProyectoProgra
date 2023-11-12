import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.JOptionPane;

public class Torneo {
    private ArrayList<Enfrentamiento> enfrentamientos = new ArrayList<>();
    private ArrayList<String> nombresEquipos = new ArrayList<>();
    private ArrayList<ArrayList> equipos = new ArrayList<>();
    private ArrayList<Jurado> jurados = new ArrayList<>();
    private ArrayList<int[]> resultadosEquipos = new ArrayList<>();

    private String nombreTorneo;
    private LocalDateTime fechaInicioTorneo;
    private int limiteEdad;
    private String tipoDeporte;
    private int numeroJugadoresEquipo;
    private Genero genero;
    private TipoTorneo tipoTorneo;
    private LocalDateTime fechaInscripcion;
    private LocalDateTime fechaCierreInscripcion;
    private float valorInscripcion;

    public Torneo(String nombreTorneo, LocalDateTime fechaTorneo, int limiteEdad, String tipoDeporte,
            int numeroJugadoresEquipo,
            Genero genero, TipoTorneo tipoTorneo, LocalDateTime fechaInscripcion, LocalDateTime fechaCierreInscripcion,
            float valorInscripcion) {
        this.nombreTorneo = nombreTorneo;
        this.fechaInicioTorneo = fechaTorneo;
        this.limiteEdad = limiteEdad;
        this.tipoDeporte = tipoDeporte;
        this.numeroJugadoresEquipo = numeroJugadoresEquipo;
        this.genero = genero;
        this.tipoTorneo = tipoTorneo;
        this.fechaInscripcion = fechaInscripcion;
        this.fechaCierreInscripcion = fechaCierreInscripcion;
        this.valorInscripcion = valorInscripcion;
    }

    public ArrayList<ArrayList> getEquipos() {
        return equipos;
    }

    public String getNombre() {
        return nombreTorneo;
    }

    public void setNombre(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicioTorneo;
    }

    public void setFechaInicio(LocalDateTime Torneo) {
        this.fechaInicioTorneo = Torneo;
    }

    public int getLimiteEdad() {
        return limiteEdad;
    }

    public void setLimiteEdad(int limiteEdad) {
        this.limiteEdad = limiteEdad;
    }

    public String getTipoDeporte() {
        return tipoDeporte;
    }

    public void setTipoDeporte(String tipoDeporte) {
        this.tipoDeporte = tipoDeporte;
    }

    public int getNumeroJugadoresEquipo() {
        return numeroJugadoresEquipo;
    }

    public void setNumeroJugadoresEquipo(int numeroJugadoresEquipo) {
        this.numeroJugadoresEquipo = numeroJugadoresEquipo;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public TipoTorneo getTipo() {
        return tipoTorneo;
    }

    public void setTipo(TipoTorneo tipoTorneo) {
        this.tipoTorneo = tipoTorneo;
    }

    public LocalDateTime getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDateTime fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public LocalDateTime getFechaCierreInscripcion() {
        return fechaCierreInscripcion;
    }

    public void setFechaCierreInscripcion(LocalDateTime fechaCierreInscripcion) {
        this.fechaCierreInscripcion = fechaCierreInscripcion;
    }

    public float getInscripcion() {
        return valorInscripcion;
    }

    public void setInscripcion(float valorInscripcion) {
        this.valorInscripcion = valorInscripcion;
    }

    public boolean aunFechaInscripcion() {
        return LocalDateTime.now().isAfter(fechaCierreInscripcion);
    }

    public boolean abiertaInscripcion() {
        return LocalDateTime.now().isBefore(fechaInscripcion);
    }

    public static ArrayList<ArrayList> contrincantes = new ArrayList<>();

    public static ArrayList<Jurado> juradosEnfrentamiento = new ArrayList<>();

    public void añadirEquipo() {
        if (aunFechaInscripcion() && abiertaInscripcion()) {

            ArrayList<Representante> equipo = new ArrayList<>();

            String nombreEquipo = pedir("Nombre del equipo", null);

            for (int i = 0; equipo.size() < numeroJugadoresEquipo + 1; i++) {

                String textNombre = "Nombre Representante";
                String textEdad = "Edad del Represetante";
                String textEmail = "email del representante";
                String textTelefono = "Numero de celular del representante";
                String textgenero = "1. Masculino\n 2. Femenino";

                if (i != 0) {
                    textNombre = "Nombre del Jugador";
                    textEdad = "Edad del jugador";
                    textEmail = "Email del jugador";
                    textTelefono = "Numero de celular del jugador";
                }

                String nombre = pedir(textNombre, null);
                int edad = pedirInt(textEdad, null);
                String email = pedir(textEmail, null);
                String telefono = pedir(textTelefono, null);

                int Xgenero = 0;

                do {
                    Xgenero = Integer.parseInt(pedir(textgenero, null));
                } while (Xgenero != 1 || Xgenero != 2);

                // GENERO MENU CON ENUM
                Genero generoPersona = null;
                if (Xgenero == 1) {
                    generoPersona = Genero.MASCULINO;
                }
                if (Xgenero == 2) {
                    generoPersona = Genero.FEMENINO;
                }
                if (generoPersona == genero || genero == Genero.MIXTO) {
                    Representante jugador = new Representante(nombre, edad, email, telefono, generoPersona,
                            nombreEquipo);
                    equipo.add(jugador);

                } else {
                    JOptionPane.showMessageDialog(null, "No puede entrar al tornero ya que es un torneo de " + genero);
                }

            }

            nombresEquipos.add(nombreEquipo);
            equipos.add(equipo);

        } else {
            JOptionPane.showMessageDialog(null, "La fecha de Inscripcion no han empezado o se han acabado");
        }
    }

    // modificar fechas
    public void modificarFechaInicio() {
        this.fechaInicioTorneo = pedirFechaHora("ingrese la nueva fecha de inicio y hora del torneo:  ", null);
    }

    public void modificarFechaInicioInscripcion() {

        this.fechaInscripcion = pedirFechaHora("ingrese la nueva fecha de inicio de inscripcion y hora del torneo: ",
                null);

    }

    public void modificarFechaCierreInscripcion() {
        this.fechaCierreInscripcion = pedirFechaHora(
                "ingrese la nueva fecha de cierre de inscripcion y hora del torneo: ", null);
    }
    // enfrentamientos

    public void crearEnfrentamientos() {

        String elemento = "";

        // pedir los contrincantes de los equipos en el torneo
        for (int i = 0; i < nombresEquipos.size(); i++) {

            elemento = elemento + "\n" + (i + 1) + ". " + nombresEquipos.get(i);

        }

        int op = pedirInt("ingrese el numero del primer equipo: \n " + elemento, null);
        int opp = pedirInt("ingrese el numero del segundo equipo: \n " + elemento, null);

        do {
            opp = pedirInt("ingrese el numero del segundo equipo: \n " + elemento, null);

        } while (op == opp);

        contrincantes.add(equipos.get(op - 1));
        contrincantes.add(equipos.get(opp - 1));

        LocalDateTime fechaEnfrantamiento = pedirFechaHora("Ingrese la fecha del enfrentamiento y hora del torneo: ",
                null);

        String lugar = pedir("ingrese el lugar del enfrentamiento: ", null);

        String listanombres = "";

        for (int i = 0; i < jurados.size(); i++) {

            listanombres = listanombres + "\n" + (i + 1) + ". " + jurados.get(i).getNombre();

        }

        int numeroJurados = pedirInt("ingrese el numero de jurados para este enfrentamiento:", null);

        // pedir escoger los jurados de los jurados en el torneo
        for (int i = 0; juradosEnfrentamiento.size() < numeroJurados; i++) {

            int numeroIndiceJurado = pedirInt("ingrese el numero del nombre del jurado: " + numeroJurados, null);

            if (buscarJuez(juradosEnfrentamiento, jurados.get(numeroIndiceJurado - 1).getNombre())) {
                JOptionPane.showMessageDialog(null, "Jurado ya ingresado, ingrese otro");
            } else {
                juradosEnfrentamiento.add(jurados.get(numeroIndiceJurado - 1));
            }
        }
        int[] resultados = { 0, 0, 0 };
        int codigo = pedirInt("ingrese el codigo del enfrentamiento: ", null);
        Enfrentamiento enfrentamiento = new Enfrentamiento(fechaEnfrantamiento, contrincantes, juradosEnfrentamiento,
                lugar, resultados, TipoEnfrentamiento.PENDIENTE);
        enfrentamientos.add(enfrentamiento);
    }

    // añadir juez

    public void añadirJuez() {

        for (int i = 0; i < jurados.size(); i++) {

            String textNombre = "Nombre del juez";
            String textEdad = "Edad del juez";
            String textEmail = "email del juez";
            String textTelefono = "Numero de celular del juez";
            String textgenero = "1. Masculino\n 2. Femenino";

            if (i != 0) {
                textNombre = "Nombre del Jugador";
                textEdad = "Edad del jugador";
                textEmail = "Email del jugador";
                textTelefono = "Numero de celular del jugador";
            }

            String nombreJuez = pedir(textNombre, null);
            int edadJuez = pedirInt(textEdad, null);
            String emailJuez = pedir(textEmail, null);
            String telefonoJuez = pedir(textTelefono, null);

            int Xgenero = 0;

            do {
                Xgenero = Integer.parseInt(pedir(textgenero, null));
            } while (Xgenero != 1 || Xgenero != 2);

            // GENERO MENU CON ENUM
            Genero generoPersona = null;
            if (Xgenero == 1) {
                generoPersona = Genero.MASCULINO;
            }
            if (Xgenero == 2) {
                generoPersona = Genero.FEMENINO;
            }

            Jurado jurados = new Jurado(nombreJuez, edadJuez, textEmail, emailJuez, generoPersona, telefonoJuez);

            juradosEnfrentamiento.add(jurados);
        }
    }

    public boolean buscarJuez(ArrayList<Jurado> jueces, String nombreJurado) {
        boolean sta = false;
        for (int i = 0; i < jueces.size() && !sta; i++) {
            if (jueces.get(i).getNombre().equals(nombreJurado)) {
                sta = true;
            }

        }
        return sta;

    }

    // pedir fecha con hora
    public LocalDateTime pedirFechaHora(String msj, String text) {
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

    // general
    public void mostrarEnfrentamientos() {
        String enfrentamientosGeneral = "";
        for (Enfrentamiento enfrentamiento : enfrentamientos) {
            enfrentamientosGeneral = enfrentamientosGeneral + "\n" + enfrentamiento.infoEnfrentamiento();
        }
        JOptionPane.showMessageDialog(null, enfrentamientosGeneral);
    }

    // buscar por equipos

    public void buscarPorEquipos() {

        String equipoBuscado = JOptionPane.showInputDialog("ingrese el equipo a buscar: ");

        if (existeEquipo(equipoBuscado)) {
            String text = "";
            for (int i = 0; i < enfrentamientos.size(); i++) {
                ArrayList<ArrayList> contrincantes = enfrentamientos.get(i).getContrincantes();
                ArrayList<Representante> equipo = contrincantes.get(0);
                ArrayList<Representante> equipoDos = contrincantes.get(1);
                if (equipo.get(0).getEquipo().equals(equipoBuscado)
                        || equipoDos.get(0).getEquipo().equals(equipoBuscado)) {

                    text += enfrentamientos.get(i).infoEnfrentamiento() + "\n\n";

                }

            }
            JOptionPane.showMessageDialog(null, text);
        } else {
            JOptionPane.showMessageDialog(null, "El equipo no existe");
        }

    }

    public boolean existeEquipo(String equipoBuscado) {
        boolean sta = false;
        for (int i = 0; i < nombresEquipos.size() && !sta; i++) {
            if (equipoBuscado.equals(nombresEquipos.get(i))) {
                sta = true;
            }

        }
        return sta;
    }

    // buscar por juez

    public void enfrentamientoJuez() {
        String juezBuscado = JOptionPane.showInputDialog("ingrese el juez a buscar: ");

        if (buscarJuez(jurados, juezBuscado)) {
            String text = "";
            for (int i = 0; i < jurados.size(); i++) {
                ArrayList<Jurado> juradosEnfre = enfrentamientos.get(i).getJueces();
                for (int j = 0; j < juradosEnfre.size(); j++) {
                    if (jurados.get(j).getNombre().equals(juezBuscado)) {
                        text += enfrentamientos.get(i).infoEnfrentamiento() + "\n\n";

                    }

                }

            }
            JOptionPane.showMessageDialog(null, text);
        } else {
            JOptionPane.showMessageDialog(null, "El equipo no existe");
        }

    }

    // resultados

    public void resultadosEnfrentamientos() {
        String listaResultados = "";
        ArrayList<int[]> resultadoCada = (ArrayList<int[]>) resultadosEquipos.clone();
        ArrayList<String> nombresEquiposAux = (ArrayList<String>) nombresEquipos.clone();
        for (int i = 0; i < resultadoCada.size(); i++) {
            for (int j = 1; j < resultadoCada.size(); j++) {
                if (resultadoCada.get(i)[0] < resultadoCada.get(j)[0]) {
                    int[] unResultado = resultadoCada.get(j);
                    resultadoCada.remove(j);
                    resultadoCada.add(i, unResultado);
                    String unEquipo = nombresEquiposAux.get(j);
                    nombresEquiposAux.remove(j);
                    nombresEquiposAux.add(i, unEquipo);

                }

            }

        }
        for (int i = 0; i < resultadoCada.size(); i++) {
            listaResultados += nombresEquiposAux.get(i) + "  V: " + resultadoCada.get(i)[0] + "  E: "
                    + resultadoCada.get(i)[1] + " D: " + resultadoCada.get(i)[2] + "\n\n";

        }

        JOptionPane.showMessageDialog(null, listaResultados);
    }

    // modificar enfrentamientos
    public void modificarEnfrentamientos() {

        int anti = Integer.parseInt(JOptionPane.showInputDialog("ingrese el codigo del enfrentamiento"));
        for (int i = 0; i < enfrentamientos.size(); i++) {
            if (enfrentamientos.get(i).getCodigo() == anti) {
                String situ = JOptionPane.showInputDialog(
                        "Ingrese el nuevo estado del enfrentamiento: \n PENDIENTE \n EN_JUEGO \n APLAZADO \n FINALIZADO");
                TipoEnfrentamiento estado = TipoEnfrentamiento.valueOf(situ);
                enfrentamientos.get(i).setTipoEnfrentamiento(estado);
                if (situ.equals("FINALIZADO")) {
                    int resul = Integer.parseInt(JOptionPane.showInputDialog("hubo un ganador: \n" + "1. Si \n" + "2. No"));
                    if (resul == 1) {
                        
                    }
                }

                int op = Integer.parseInt(JOptionPane
                        .showInputDialog("Desea cambiar la fecha del enfrentamiento: " + "1. si \n" + "2. no"));
                if (op == 1) {
                    LocalDateTime fecha = pedirFechaHora(
                            "ingrese la nueva fecha de inicio y hora del enfrentamiento:  ",
                            null);
                    enfrentamientos.get(i).setFechainicio(fecha);
                }
            }

        }

    }

    // ver equipos

    public void verEquipos() {

        ArrayList<String> msj = new ArrayList<String>();
        for (int i = 0; i < equipos.size(); i++) {
            String compil = "\n" + equipos.get(i);
            msj.add(compil);

        }
        Collections.sort(msj, ordenarVictorias);
        JOptionPane.showMessageDialog(null, msj);

    }

    // ordenar equipos por victorias
    public class ordenarVictorias implements Comparator<Enfrentamiento> {

        @Override
        public int compare(Enfrentamiento e1, Enfrentamiento e2) {
            return e1.getResultados() - e2.getResultados();
        }

    }

    // ver jueces

    public void verJueces() {

        String msj = "";
        for (int i = 0; i < jurados.size(); i++) {
            msj += jurados.get(i) + "\n";

        }
        JOptionPane.showMessageDialog(null, msj);
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
}
