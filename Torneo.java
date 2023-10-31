import java.time.LocalDate;
import java.util.*;

import javax.swing.JOptionPane;

public class Torneo {
    private ArrayList<ArrayList> equipos = new ArrayList<>();
    
    private String nombreTorneo;
    private LocalDate fechaInicioTorneo;
    private int limiteEdad;
    private String tipoDeporte;
    private int numeroJugadoresEquipo;
    private Genero genero;
    private Tipo tipoTorneo;
    private LocalDate fechaInscripcion;
    private LocalDate fechaCierreInscripcion;
    private float valorInscripcion;

    public (String nombreTorneo, LocalDate Torneo, int limiteEdad, String tipoDeporte, int numeroJugadoresEquipo,
            Genero genero, Tipo tipoTorneo, LocalDate fechaInscripcion, LocalDate fechaCierreInscripcion,
            float valorInscripcion) {
        this.nombreTorneo = nombreTorneo;
        this.Torneo = Torneo;
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

    public void setEquipos(ArrayList<ArrayList> equipos) {
        this.equipos = equipos;
    }

    public String getNombre() {
        return nombreTorneo;
    }

    public void setNombre(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }

    public LocalDate getFechaInicio() {
        return Torneo;
    }

    public void setFechaInicio(LocalDate Torneo) {
        this.Torneo = Torneo;
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

    public Tipo getTipo() {
        return tipoTorneo;
    }

    public void setTipo(Tipo tipoTorneo) {
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

        for (int i = 0; i < numeroJugadoresEquipo + 1; i++) {

            String textequipo = "Nombre del equipo";
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
            int edad = Integer.parseInt(pedir(textEdad));
            String email = pedir(textEmail);
            String telefono = pedir(textTelefono);
            String equipo = pedir(textequipo);
            int Xgenero =0;

            do{
                Xgenero = Integer.parseInt(pedir(textgenero));
            }while(Xgenero !=1 || Xgenero!=2);

            //GENERO MENU CON ENUM
            if (Xgenero == 1) {
                Genero generoPersona = Genero.MASCULINO;             
            } else if (Xgenero == 2) {
                Genero generoPersona = Genero.FEMENINO;  
            }
            
            Representante jugador = new Representante (nombre, edad, email, telefono, generoPersona, equipo);
            equipo.add(jugador);
            }

            equipos.add(equipo);
        }else{
            JOptionPane.showMessajeDialog(null, "La fecha de valorInscripcion no han empezado o se han acabado");
        }
    }

    // modificar fechas
    public void modificarFechas() {
        JOptionPane.showMessageDialog(null,"ingrese la nueva fecha de inscripción");
        fechaInscripcion = JOptionPane.showInputDialog("");
        
        JOptionPane.showMessageDialog(null, "ingrese la nueva fecha de cierre de valorInscripcion");
        fechaCierreInscripcion = JOptionPane.showInputDialog("");

        JOptionPane.showMessageDialog(null, "ingrese la nueva fecha de inicio del torneo");
        Torneo = JOptionPane.showInputDialog("");
    }


    // enfrentamientos



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
        try{
            return Integer.parseInt(pedir(msj));
        }catch{
            JOptionPane.showMessajeDialog(null, "Digite un numero correctamente");
        }

    }
}
