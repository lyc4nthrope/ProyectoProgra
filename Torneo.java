import java.util.*;

public class Torneo {
    private ArrayList<ArrayList> equipos = new ArrayList<>();
    
    private String nombreTorneo;
    private Date fechaInicio;
    private int limiteEdad;
    private String tipoDeporte;
    private int numeroJugadoresEquipo;
    private Genero genero;
    private TipoTorneo tipoTorneo;
    private Date fechaInscripcion;
    private Date fechaCierreInscripcion;
    private float inscripcion;

    public Torneo(String nombreTorneo, Date fechaInicio, int limiteEdad, String tipoDeporte, int numeroJugadoresEquipo,
            Genero genero, TipoTorneo tipoTorneo, Date fechaInscripcion, Date fechaCierreInscripcion,
            float inscripcion) {
        this.nombreTorneo = nombreTorneo;
        this.fechaInicio = fechaInicio;
        this.limiteEdad = limiteEdad;
        this.tipoDeporte = tipoDeporte;
        this.numeroJugadoresEquipo = numeroJugadoresEquipo;
        this.genero = genero;
        this.tipoTorneo = tipoTorneo;
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

    public String getNombreTorneo() {
        return nombreTorneo;
    }

    public void setNombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
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

    public TipoTorneo getTipoTorneo() {
        return tipoTorneo;
    }

    public void setTipoTorneo(TipoTorneo tipoTorneo) {
        this.tipoTorneo = tipoTorneo;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public Date getFechaCierreInscripcion() {
        return fechaCierreInscripcion;
    }

    public void setFechaCierreInscripcion(Date fechaCierreInscripcion) {
        this.fechaCierreInscripcion = fechaCierreInscripcion;
    }

    public float getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(float inscripcion) {
        this.inscripcion = inscripcion;
    }

    
     
    
     
    
}
