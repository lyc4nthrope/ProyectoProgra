import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.JOptionPane;

public class Torneo {
    private ArrayList<enfrentamiento> enfrentamientos = new ArrayList<>();
    private ArrayList<String> nombresEquipos = new ArrayList<>();
    private ArrayList<ArrayList> equipos = new ArrayList<>();
    private ArrayList<Jurado> jurados = new ArrayList<>();
    
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

    public Torneo(String nombreTorneo, LocalDateTime fechaTorneo, int limiteEdad, String tipoDeporte, int numeroJugadoresEquipo,
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
    
    public boolean abiertaInscripcion(){
        return LocalDateTime.now().isBefore(fechaInscripcion);
    }

    public void añadirEquipo() {
    if (aunFechaInscripcion() && abiertaInscripcion()) {

        ArrayList <Representante> equipo = new ArrayList <>();

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
           
            int Xgenero =0;

            do{
                Xgenero = Integer.parseInt(pedir(textgenero, null));
            }while(Xgenero !=1 || Xgenero!=2);

            //GENERO MENU CON ENUM
            Genero generoPersona = null;
            if (Xgenero == 1) {
                generoPersona = Genero.MASCULINO;             
            } 
            if (Xgenero == 2) {
                generoPersona = Genero.FEMENINO;  
            }
            if (generoPersona==genero || genero==Genero.MIXTO) {
                Representante jugador = new Representante (nombre, edad, email, telefono, generoPersona, nombreEquipo);
                equipo.add(jugador);
                
            }else{
                JOptionPane.showMessageDialog(null, "No puede entrar al tornero ya que es un torneo de " + genero);          
            }

            }
            
            nombresEquipos.add(nombreEquipo);
            equipos.add(equipo);

        }else{
            JOptionPane.showMessageDialog(null, "La fecha de Inscripcion no han empezado o se han acabado");
        }
    }

    // modificar fechas
    public void modificarFechaInicio() {
        this.fechaInicioTorneo = pedirFechaHora("ingrese la nueva fecha de inicio y hora del torneo:  ", null);
    }

    public void modificarFechaInicioInscripcion() {
        
        this.fechaInscripcion= pedirFechaHora("ingrese la nueva fecha de inicio de inscripcion y hora del torneo: ", null); 
     
    }

    public void modificarFechaCierreInscripcion() {
        this.fechaCierreInscripcion = pedirFechaHora("ingrese la nueva fecha de cierre de inscripcion y hora del torneo: ", null);
    }
    // enfrentamientos

    public void crearEnfrentamientos() {
        String elemento = "";

        //pedir los contrincantes de los equipos en el torneo
        for (int i = 0; i < nombresEquipos.size(); i++) {

            elemento = elemento + "\n" + (i + 1) + ". " + nombresEquipos.get(i);

        }

        int op = pedirInt("ingrese el numero del primer equipo: \n " + elemento, null);
        int opp = pedirInt("ingrese el numero del segundo equipo: \n " + elemento, null);

        do {
            opp = pedirInt("ingrese el numero del n equipo: \n " + elemento, null);

        } while (op == opp);
        ArrayList contrincantes = new ArrayList<>();
        contrincantes.add(equipos.get(op-1));
        contrincantes.add(equipos.get(opp-1));


        LocalDateTime fechaEnfrantamiento = pedirFechaHora("Ingrese la fecha del enfrentamiento y hora del torneo: ", null);

        String lugar = pedir("ingrese el lugar del enfrentamiento: ", null);


        String listanombres = "";

        for (int i = 0; i < jurados.size(); i++) {

            listanombres = listanombres + "\n" + (i + 1) + ". " + jurados.get(i).getNombre();


        }

        int numeroJurados = pedirInt("ingrese el numero de jurados para este enfrentamiento:", null);

        ArrayList<Jurado> juradosEnfrentamiento = new ArrayList<>();

        //pedir escoger los jurados de los jurados en el torneo
        for (int i = 0; juradosEnfrentamiento.size() < numeroJurados; i++) {

            int numeroIndiceJurado = pedirInt("ingrese el numero del nombre del jurado: " + numeroJurados, null);

            boolean sta = false;

            //revision si ya esta ese jurado
            for (int j = 0; j < juradosEnfrentamiento.size() && !sta; j++) {

                if (juradosEnfrentamiento.get(j).getNombre().equals(jurados.get(numeroIndiceJurado - 1).getNombre())) {
                    sta=true;
                }
            }
            if (sta) {
                JOptionPane.showMessageDialog(null, "Jurado ya ingresado, ingrese otro");
            }else{
                juradosEnfrentamiento.add(jurados.get(numeroIndiceJurado-1));
            }
        }
        int [] resultados ={0,0,0};
        enfrentamiento enfrentamiento = new enfrentamiento(fechaEnfrantamiento, contrincantes, juradosEnfrentamiento, lugar, resultados, TipoEnfrentamiento.PENDIENTE);
        enfrentamientos.add(enfrentamiento);
    }

    //pedir fecha con hora
    public LocalDateTime pedirFechaHora(String msj, String text) {
        String fecha = JOptionPane.showInputDialog(null, msj + "en este formato con barras, puntos y comas (YYYY/MM/DD, HH:mm)", text);
        try {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd, HH:mm");
        LocalDateTime fechaHecha = LocalDateTime.parse(fecha, formatter);
        return fechaHecha;
        } catch (Exception e) {
            return pedirFechaHora("Error al ingresar, intente de nuevo\n"+msj, fecha);
        }
        

    }


    public void mostrarEnfrentamientos(){
        String enfrentamientosGeneral = "";
        for (enfrentamiento enfrentamiento : enfrentamientos) {
            enfrentamientosGeneral = enfrentamientosGeneral+"\n"+enfrentamiento.infoEnfrentamiento();
        }
        JOptionPane.showMessageDialog(null, enfrentamientosGeneral);
    }

    


    // general



    // buscar por equipos



    // buscar por juez




    // resultados




    // modificar enfrentamientos



    // ver equipos




    // ver jueces





     
    public static String pedir(String msj, String text) {
        return JOptionPane.showInputDialog(null, msj, text);
    }
    public static int pedirInt(String msj, String text) {
        String numero=pedir(msj, text);
        try {
            int numTrue = Integer.parseInt(numero);
            return numTrue;
        } catch (Exception e) {
            // TODO: handle exception
            return pedirInt("Error al ingresae\n"+msj, numero);
        }
    }

    public float pedirFloat(String msj, String text){
         String numero = pedir(msj, text);
        try {
            float numTrue=Float.parseFloat(numero);
            return numTrue;
        } catch (java.util.InputMismatchException e) {
            // TODO: handle exception
            return pedirFloat("Error al ingresar\n"+msj, numero);
        }
    }
}
