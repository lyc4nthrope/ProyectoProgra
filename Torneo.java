import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.swing.JOptionPane;

public class Torneo {
    private ArrayList<ArrayList> enfrentamientos = new ArrayList<>();
    private ArrayList<String> nombresEquipos = new ArrayList<>();
    private ArrayList<ArrayList> equipos = new ArrayList<>();
    private ArrayList<Jurado> jurados = new ArrayList<>();
    
    private String nombreTorneo;
    private LocalDate fechaInicioTorneo;
    private int limiteEdad;
    private String tipoDeporte;
    private int numeroJugadoresEquipo;
    private Genero genero;
    private TipoTorneo tipoTorneo;
    private LocalDate fechaInscripcion;
    private LocalDate fechaCierreInscripcion;
    private float valorInscripcion;

    public Torneo(String nombreTorneo, LocalDate fechaTorneo, int limiteEdad, String tipoDeporte, int numeroJugadoresEquipo,
            Genero genero, TipoTorneo tipoTorneo, LocalDate fechaInscripcion, LocalDate fechaCierreInscripcion,
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

    public LocalDate getFechaInicio() {
        return fechaInicioTorneo;
    }

    public void setFechaInicio(LocalDate Torneo) {
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

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public LocalDate getFechaCierreInscripcion() {
        return fechaCierreInscripcion;
    }

    public void setFechaCierreInscripcion(LocalDate fechaCierreInscripcion) {
        this.fechaCierreInscripcion = fechaCierreInscripcion;
    }

    public float getInscripcion() {
        return valorInscripcion;
    }

    public void setInscripcion(float valorInscripcion) {
        this.valorInscripcion = valorInscripcion;
    }

    
    public boolean aunFechaInscripcion() {
        return LocalDate.now().isAfter(fechaCierreInscripcion);
    }
    
    public boolean abiertaInscripcion(){
        return LocalDate.now().isBefore(fechaInscripcion);
    }

    public void añadirEquipo() {
    if (aunFechaInscripcion() && abiertaInscripcion()) {

        ArrayList <Representante> equipo = new ArrayList <>();

         String nombreEquipo = pedir("Nombre del equipo");

        for (int i = 0; i < numeroJugadoresEquipo + 1; i++) {

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

            String nombre = pedir(textNombre);
            int edad = pedirInt(textEdad);
            String email = pedir(textEmail);
            String telefono = pedir(textTelefono);
           
            int Xgenero =0;

            do{
                Xgenero = Integer.parseInt(pedir(textgenero));
            }while(Xgenero !=1 || Xgenero!=2);

            //GENERO MENU CON ENUM
            Genero generoPersona = genero;
            if (Xgenero == 1) {
                generoPersona = Genero.MASCULINO;             
            } 
            if (Xgenero == 2) {
                generoPersona = Genero.FEMENINO;  
            }
            if (generoPersona==genero) {
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
        this.fechaInicioTorneo = pedirFecha("ingrese la nueva fecha de incio del torneo: ");
    }

    public void modificarFechaInicioInscripcion() {
        
        this.fechaInscripcion= pedirFecha("ingrese la nueva fecha de inicio de inscripcion: "); 
     
    }

    public void modificarFechaCierreInscripcion() {
        this.fechaCierreInscripcion = pedirFecha("ingrese la nueva fecha de cierre de inscripcion: ");
    }
    // enfrentamientos

    public void crearEnfrentamientos() {
        String elemento = "";

        for (int i = 0; i < nombresEquipos.size(); i++) {

            elemento = elemento + "\n" + (i + 1) + ". " + nombresEquipos.get(i);

        }

        int op = pedirInt("ingrese el numero del primer equipo: \n " + elemento);
        int opp = pedirInt("ingrese el numero del segundo equipo: \n " + elemento);

        do {
            opp = pedirInt("ingrese el numero del segundo equipo: \n " + elemento);

        } while (op == opp);

        LocalDate fechaEnfrantamiento = pedirFecha("ingrese la fecha del enfrentamiento: ");

        String lugar = pedir("ingrese el lugar del engrentamiento: ");


        String listanombres = "";

        for (int i = 0; i < jurados.size(); i++) {

            listanombres = listanombres + "\n" + (i + 1) + ". " + jurados.get(i).getNombre();


        }

        int numeroJurados = pedirInt("ingrese el numero de jurados de este torneo:");

        ArrayList<Jurado> juradosEnfrentamiento = new ArrayList<>();

        for (int i = 0; i < numeroJurados; i++) {

            int numeroIndiceJurado = pedirInt("ingrese el numero del nombre del jurado: " + numeroJurados);

            boolean sta = true;

            for (int j = 0; j < juradosEnfrentamiento.size() && sta; j++) {

                if (juradosEnfrentamiento.get(j).getNombre().equals(jurados.get(numeroIndiceJurado - 1).getNombre())) {
                    JOptionPane.showMessageDialog(null, "Jurado ya ingresado, ingrese otro");

                } else {
                    juradosEnfrentamiento.add(jurados.get(numeroIndiceJurado - 1));
                }

            }

        }
        




    


        




    }
    
    
    
    //pedir fecha
    public LocalDate pedirFecha(String msj) {

        String fecha = JOptionPane.showInputDialog(null, msj +"en este orden y con las barras ty, YYYY/MM/DD");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate fechaHecha = LocalDate.parse(fecha, formatter);
        return fechaHecha;
        
    }




    // general



    // buscar por equipos



    // buscar por juez




    // resultados




    // modificar enfrentamientos



    // ver equipos




    // ver jueces





     
    public String pedir(String msj) {
        return JOptionPane.showInputDialog(null, msj);
    }

    public int pedirInt(String msj){
        int numero;
        try {
            numero=Integer.parseInt(pedir(msj));
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: No ha ingresado un número entero válido.");
            // TODO: handle exception
            numero=pedirInt(msj);
        }
        return numero;
    }

    public float pedirFloat(String msj){
         float numero;
        try {
            numero=Float.parseFloat(pedir(msj));
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: No ha ingresado un número decimal válido.");
            // TODO: handle exception
            numero=pedirFloat(msj);
        }
        return numero;
    }
}
