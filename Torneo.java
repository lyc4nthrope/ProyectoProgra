import java.time.LocalDate;
import java.util.*;

import javax.swing.JOptionPane;

public class  {
    private ArrayList<ArrayList> equipos = new ArrayList<>();
    
    private String nombre;
    private LocalDate fechaInicio;
    private int limiteEdad;
    private String tipoDeporte;
    private int numeroJugadoresEquipo;
    private Genero genero;
    private Tipo tipo;
    private LocalDate fechaInscripcion;
    private LocalDate fechaCierreInscripcion;
    private float inscripcion;

    public (String nombre, LocalDate fechaInicio, int limiteEdad, String tipoDeporte, int numeroJugadoresEquipo,
            Genero genero, Tipo tipo, LocalDate fechaInscripcion, LocalDate fechaCierreInscripcion,
            float inscripcion) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.limiteEdad = limiteEdad;
        this.tipoDeporte = tipoDeporte;
        this.numeroJugadoresEquipo = numeroJugadoresEquipo;
        this.genero = genero;
        this.tipo = tipo;
        this.fechaInscripcion = fechaInscripcion;
        this.fechaCierreInscripcion = fechaCierreInscripcion;
        this.inscripcion = inscripcion;
    }

    public ArrayList<ArrayList> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<ArrayList> equipos) {
        this.equipos = equipos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
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
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
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
        return inscripcion;
    }

    public void setInscripcion(float inscripcion) {
        this.inscripcion = inscripcion;
    }

    
    public boolean aunFechaInscripcion() {
        return LocalDate.now().isAfter(fechaCierreInscripcion);
    }
    
    public void añadirEquipo() {
    if (aunFechaInscripcion()) {
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
            

            }
        }
    }

    // modificar fechas
    public void modificarFechas() {
        JOptionPane.showMessageDialog(null,"ingrese la nueva fecha de inscripción");
        fechaInscripcion = JOptionPane.showInputDialog("");
        
        JOptionPane.showMessageDialog(null, "ingrese la nueva fecha de cierre de inscripcion");
        fechaCierreInscripcion = JOptionPane.showInputDialog("");

        JOptionPane.showMessageDialog(null, "ingrese la nueva fecha de inicio del torneo");
        fechaInicio = JOptionPane.showInputDialog("");
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

}
