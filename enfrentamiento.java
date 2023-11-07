import java.time.*;
import java.util.*;

public class Enfrentamiento {
    private LocalDateTime fechaInicio;
    private ArrayList<ArrayList> contrincantes;
    private ArrayList<Jurado> jueces;
    private String lugar;
    private int[] resultados = new int[3];
    private TipoEnfrentamiento tipoEnfrentamiento;

    public Enfrentamiento(LocalDateTime fechaInicio, ArrayList<ArrayList> contrincantes, ArrayList<Jurado> jueces,
            String lugar, int[] resultados, TipoEnfrentamiento tipoEnfrentamiento) {
        this.fechaInicio = fechaInicio;
        this.contrincantes = contrincantes;
        this.jueces = jueces;
        this.lugar = lugar;
        this.resultados = resultados;
        this.tipoEnfrentamiento = tipoEnfrentamiento;

    }
    public LocalDateTime getFechainicio() {
        return fechaInicio;
    }
    public void setFechainicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public ArrayList<ArrayList> getContrincantes() {
        return contrincantes;
    }
    public void setContrincantes(ArrayList<ArrayList> contrincantes) {
        this.contrincantes = contrincantes;
    }
    public ArrayList<Jurado> getJueces() {
        return jueces;
    }
    public void setJueces(ArrayList<Jurado> jueces) {
        this.jueces = jueces;
    }
    public String getLugar() {
        return lugar;
    }
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    public int[] getResultados() {
        return resultados;
    }
    public void setResultados(int[] resultados) {
        this.resultados = resultados;
    }
    public TipoEnfrentamiento getTipoEnfrentamiento() {
        return tipoEnfrentamiento;
    }
    public void setTipoEnfrentamiento(TipoEnfrentamiento tipoEnfrentamiento) {
        this.tipoEnfrentamiento = tipoEnfrentamiento;
    }
    

    
}
