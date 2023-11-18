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
        return !LocalDateTime.now().isAfter(fechaCierreInscripcion);
    }

    public boolean abiertaInscripcion() {
        return !LocalDateTime.now().isBefore(fechaInscripcion);
    }

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
                if (limiteEdad < edad || i == 0) {
                    String email = pedir(textEmail, null);
                    String telefono = pedir(textTelefono, null);

                    int Xgenero = 0;

                    do {
                        Xgenero = pedirInt(textgenero, null);
                    } while (Xgenero != 1 && Xgenero != 2);

                    // GENERO MENU CON ENUM
                    Genero generoPersona = null;
                    if (Xgenero == 1) {
                        generoPersona = Genero.MASCULINO;
                    }
                    if (Xgenero == 2) {
                        generoPersona = Genero.FEMENINO;
                    }
                    if (generoPersona == genero || genero == Genero.MIXTO || i == 0) {

                        Representante jugador = new Representante(nombre, edad, email, telefono, generoPersona,
                                nombreEquipo);
                        equipo.add(jugador);

                    } else {
                        JOptionPane.showMessageDialog(null,
                                "No puede entrar al tornero ya que es un torneo de " + genero);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No tiene la edad requerida");
                }

            }

            nombresEquipos.add(nombreEquipo);
            equipos.add(equipo);
            int [] resultado = {0,0,0};
            resultadosEquipos.add(resultado);

        } else {
            JOptionPane.showMessageDialog(null, "La fecha de Inscripcion no han empezado o se han acabado");
        }
    }

    // modificar fechas
    public void modificarFechaMenu() {
        int option = 0;
        do {
            option = pedirInt(
                    "Ingrese la fecha que desea modificar : \n1. Fecha de Inico\n2. Fecha de Inicio de Inscripciones\n3. Fecha de Cierre de Inscripciones\n4. Volver",
                    null);
            if (option == 1) {
                modificarFechaInicio();
            }
            if (option == 2) {
                modificarFechaInicioInscripcion();
            }
            if (option == 3) {
                modificarFechaCierreInscripcion();
            }
        } while (option != 4);
    }

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
        ArrayList<ArrayList> contrincantes =new ArrayList<>();
        ArrayList<Jurado>juradosEnfrentamiento=new ArrayList<>();
        // pedir los contrincantes de los equipos en el torneo
        for (int i = 0; i < nombresEquipos.size(); i++) {

            elemento = elemento + "\n" + (i + 1) + ". " + nombresEquipos.get(i);

        }

        int op = pedirInt("ingrese el numero del primer equipo: \n " + elemento, null);
        int opp = pedirInt("ingrese el numero del segundo equipo: \n " + elemento, null);
        if (op == opp) {
            do {
                JOptionPane.showMessageDialog(null, "No puede enfrentar un equipo contra si mismo");
                opp = pedirInt("ingrese el numero del segundo equipo: \n " + elemento, null);
            } while (op == opp);

        }

        contrincantes.add(equipos.get(op - 1));
        contrincantes.add(equipos.get(opp - 1));

        LocalDateTime fechaEnfrantamiento = pedirFechaHora("Ingrese la fecha del enfrentamiento y hora del torneo: ",
                null);

        String lugar = pedir("ingrese el lugar del enfrentamiento: ", null);

        int numeroJurados = pedirInt("ingrese el numero de jurados para este enfrentamiento:", null);
        String listanombres = "";

        for (int i = 0; i < jurados.size(); i++) {
            listanombres = listanombres + "\n" + (i + 1) + ". " + jurados.get(i).getNombre();
        }
        // pedir escoger los jurados de los jurados en el torneo
        do {
            int numeroIndiceJurado = pedirInt("ingrese el numero del nombre del jurado: " + listanombres, null);

            if (buscarJuez(juradosEnfrentamiento, jurados.get(numeroIndiceJurado - 1).getNombre())) {
                JOptionPane.showMessageDialog(null, "Jurado ya ingresado, ingrese otro");
            } else {
                juradosEnfrentamiento.add(jurados.get(numeroIndiceJurado - 1));
            }
        } while (juradosEnfrentamiento.size() < numeroJurados);

        int codigo = pedirInt("ingrese el codigo del enfrentamiento: ", null);
        if (existeCodigo(codigo)) {
            do {
                JOptionPane.showMessageDialog(null, "Codigo ya existente");
                codigo =pedirInt("ingrese el codigo del enfrentamiento: ", null);
            } while (existeCodigo(codigo));
        }
        Enfrentamiento enfrentamiento = new Enfrentamiento(fechaEnfrantamiento, contrincantes, juradosEnfrentamiento, lugar, TipoEnfrentamiento.PENDIENTE, codigo, listanombres);
        enfrentamientos.add(enfrentamiento);
    }
    public boolean existeCodigo(int codigo){
        boolean esta=false;
        for (int i = 0; i < enfrentamientos.size() && !esta; i++) {
            if (enfrentamientos.get(i).getCodigo()==codigo) {
                esta=true;
            }
        }
        return esta;
    }
    // añadir juez

    public void añadirJuez() {

        String nombreJuez = pedir("Nombre del juez", null);
        int edadJuez = pedirInt("Edad del juez", null);
        String emailJuez = pedir("email del juez", null);
        String telefonoJuez = pedir("Numero de celular del juez", null);
        String licencia = pedir("Ingrese la licencia del juez", null);
        int Xgenero = 0;

        do {
            Xgenero = Integer.parseInt(pedir("1. Masculino\n 2. Femenino", null));
        } while (Xgenero != 1 && Xgenero != 2);

        // GENERO MENU CON ENUM
        Genero generoPersona = null;
        if (Xgenero == 1) {
            generoPersona = Genero.MASCULINO;
        }
        if (Xgenero == 2) {
            generoPersona = Genero.FEMENINO;
        }

        Jurado juez = new Jurado(nombreJuez, edadJuez, emailJuez, telefonoJuez, generoPersona, licencia);

        jurados.add(juez);

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
        ArrayList<int[]> resultadoCada = new ArrayList<>(resultadosEquipos);
        ArrayList<String> nombresEquiposAux = new ArrayList<>(nombresEquipos);
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

        if (existeEnfrentamiento(anti)) {

            String situ = JOptionPane.showInputDialog(
                    "Ingrese el nuevo estado del enfrentamiento: \n EN JUEGO \n APLAZADO \n FINALIZADO");

            int indiceEnfrentamiento = indiceEnfrentamientoCodigo(anti);
            if (situ.equalsIgnoreCase("FINALIZADO")) {
                int resul = Integer.parseInt(JOptionPane.showInputDialog("hubo un ganador: \n" + "1. Si \n" + "2. No"));
                if (resul == 1) {
                    String ganador = JOptionPane.showInputDialog("Ingrese el nombre del equipo ganador");
                    ArrayList<ArrayList> contrincantes = enfrentamientos.get(indiceEnfrentamiento).getContrincantes();
                    ArrayList<Representante> equipo = contrincantes.get(0);
                    ArrayList<Representante> equipoDos = contrincantes.get(1);

                    if (ganador.equals(equipo.get(0).getEquipo())) {
                        int indexEquipGanador = indiceEquipo(ganador);
                        int indexEquipPerdedor = indiceEquipo(equipoDos.get(0).getEquipo());
                        resultadosEquipos.get(indexEquipGanador)[0] += 1;
                        resultadosEquipos.get(indexEquipPerdedor)[2] += 1;
                        enfrentamientos.get(indiceEnfrentamiento).setTipoEnfrentamiento(TipoEnfrentamiento.FINALIZADO);
                    }
                    if (ganador.equals(equipoDos.get(0).getEquipo())) {
                        int indexEquipGanador = indiceEquipo(ganador);
                        int indexEquipPerdedor = indiceEquipo(equipo.get(0).getEquipo());
                        resultadosEquipos.get(indexEquipGanador)[0] += 1;
                        resultadosEquipos.get(indexEquipPerdedor)[2] += 1;
                        enfrentamientos.get(indiceEnfrentamiento).setTipoEnfrentamiento(TipoEnfrentamiento.FINALIZADO);
                    }
                    if(enfrentamientos.get(indiceEnfrentamiento).getTipoEnfrentamiento()==TipoEnfrentamiento.FINALIZADO){
                        JOptionPane.showMessageDialog(null,
                                "el equipo ingresado no pertenece al enfrentamiento");
                    }
                }
                if (resul == 2) {
                    ArrayList<ArrayList> contrincantes = enfrentamientos.get(indiceEnfrentamiento).getContrincantes();
                    ArrayList<Representante> equipo = contrincantes.get(0);
                    ArrayList<Representante> equipoDos = contrincantes.get(1);
                    int indexEquip1 = indiceEquipo(equipo.get(0).getEquipo());
                    int indexEquip2 = indiceEquipo(equipoDos.get(0).getEquipo());
                    resultadosEquipos.get(indexEquip1)[1] += 1;
                    resultadosEquipos.get(indexEquip2)[1] += 1;
                }

            }
            if (situ.equalsIgnoreCase("APLAZADO")) {
                enfrentamientos.get(indiceEnfrentamiento).setTipoEnfrentamiento(TipoEnfrentamiento.APLAZADO);
                LocalDateTime nuevaFecha = pedirFechaHora("ingrese la nueva fecha del enfrentamiento", null);
                String razon = JOptionPane.showInputDialog("ingrese la razon del aplazamiento");
                enfrentamientos.get(indiceEnfrentamiento).setFechainicio(nuevaFecha);
                enfrentamientos.get(indiceEnfrentamiento).setRazon(razon);

            }
            if (situ.equalsIgnoreCase("EN JUEGO")) {
                enfrentamientos.get(indiceEnfrentamiento).setTipoEnfrentamiento(TipoEnfrentamiento.EN_JUEGO);
            }
            if (!(situ.equalsIgnoreCase("EN JUEGO") || situ.equalsIgnoreCase("APLAZADO")
                    || situ.equalsIgnoreCase("FINALIZADO"))) {
                JOptionPane.showMessageDialog(null, "estado no valido");
            }
        }
    }

    // buscar equipo
    public int indiceEquipo(String equipo) {
        boolean esta = false;
        int indiceEquipo = -1;
        for (int i = 0; i < nombresEquipos.size() && !esta; i++) {
            if (equipo.equalsIgnoreCase(nombresEquipos.get(i))) {
                esta = true;
                indiceEquipo = i;
            }
        }
        return indiceEquipo;
    }

    public boolean existeEnfrentamiento(int codigo) {
        boolean esta = false;
        for (int i = 0; i < enfrentamientos.size() && !esta; i++) {
            if (enfrentamientos.get(i).getCodigo() == codigo) {
                esta = true;
            }
        }
        return esta;
    }

    public int indiceEnfrentamientoCodigo(int codigo) {
        boolean esta = false;
        int indiceEnfrentamiento = -1;
        for (int i = 0; i < enfrentamientos.size() && !esta; i++) {
            if (enfrentamientos.get(i).getCodigo() == codigo) {
                esta = true;
                indiceEnfrentamiento = i;
            }
        }
        return indiceEnfrentamiento;
    }
    // ver equipos

    public void verEquipos() {

        String msj = "";

        for (int i = 0; i < equipos.size(); i++) {
            ArrayList<Representante> equipo = equipos.get(i);
            String listaEquipo = "Representante ";
            for (int j = 0; j < equipo.size(); j++) {
                listaEquipo += equipo.get(j).toString() + "\n";
            }
            String compil = "\n\n" + nombresEquipos.get(i) + " : \n" + listaEquipo;
            msj += compil;

        }
        JOptionPane.showMessageDialog(null, msj);

    }

    

    // ver jueces

    @Override
    public String toString() {
        return "Torneo : " + nombreTorneo + ", fecha deInicio del Torneo= " + fechaInicioTorneo + ", limite de Edad= "
                + limiteEdad + ", Deporte= " + tipoDeporte + ", genero del torneo= " + genero + ", Torneo " + tipoTorneo
                + ", fecha de Inscripcion= " + fechaInscripcion + ", fecha de Cierre de Inscripciones= " + fechaCierreInscripcion
                + ", valor de la Inscripcion= " + valorInscripcion+" , tiene "+equipos.size()+" equipos"
                +" con "+enfrentamientos.size()+" enfrentamientos y con "+jurados.size()+" jueces"+"\n\n" ;
    }

    public void verJueces() {

        String msj = "";
        for (int i = 0; i < jurados.size(); i++) {
            msj += "Jurado " + jurados.get(i).toString() + "\n\n";

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
