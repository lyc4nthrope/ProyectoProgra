import java.time.LocalDate;
import java.util.ArrayList;

public class enfrentamiento {
    private LocalDate fechainicio;
    private ArrayList<ArrayList> contrincantes;
    private ArrayList<Jurado> jueces;
    private String lugar;
    private int[] resultados = new int[3];
    private TipoEnfrentamiento tipoEnfrentamiento;
    public enfrentamiento(LocalDate fechainicio, ArrayList<ArrayList> contrincantes, ArrayList<Jurado> jueces,
            String lugar, int[] resultados, TipoEnfrentamiento tipoEnfrentamiento) {
        this.fechainicio = fechainicio;
        this.contrincantes = contrincantes;
        this.jueces = jueces;
        this.lugar = lugar;
        this.resultados = resultados;
        this.tipoEnfrentamiento = tipoEnfrentamiento;

    }
    public LocalDate getFechainicio() {
        return fechainicio;
    }
    public void setFechainicio(LocalDate fechainicio) {
        this.fechainicio = fechainicio;
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
