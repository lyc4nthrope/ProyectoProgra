import java.util.*;
import java.util.zip.DataFormatException;
import java.time.*;
import java.time.format.DateTimeFormatter;


import javax.swing.JOptionPane;

public class Prueba {
    public static ArrayList<Enfrentamiento> enfrentamientos = new ArrayList<>();
    public static ArrayList<String>nombresEquipos=new ArrayList<>();
    public static ArrayList<int[]>resultadosEquipos= new ArrayList<>();
    public static void main(String[] args) {
        ArrayList<Representante>equipo1=new ArrayList<>();
        ArrayList<Representante>equipo2=new ArrayList<>();
        ArrayList<Representante>equipo3=new ArrayList<>();
        ArrayList<Representante>equipo4=new ArrayList<>();
        equipo1.add(new Representante("felipe", 12, "nose", "123", Genero.MASCULINO, "club"));
        equipo2.add(new Representante("juan", 122, "nose1", "323123", Genero.MASCULINO, "pepitos"));
        equipo3.add(new Representante("juana", 12, "12", "11297823", Genero.FEMENINO, "marimachas"));
        equipo4.add(new Representante("maria", 122, "kok", "327893123", Genero.FEMENINO, "esnusnu"));
        ArrayList<Jurado> jueces = new ArrayList<>();
        ArrayList<ArrayList>contricantes1 = new ArrayList<>();
        ArrayList<ArrayList>contricantes2 = new ArrayList<>();
        contricantes1.add(equipo1); contricantes1.add(equipo2);
        contricantes2.add(equipo3); contricantes2.add(equipo4);
        jueces.add(new Jurado("null", 200, "asd", "null", Genero.FEMENINO, "null"));
        int[] resultados1 = {1,2,2};int[] resultados3 = {5,3,2};
        int[] resultados2 = {2,2,4}; int[] resultados4 = {2,1,0};
        nombresEquipos.add("club");nombresEquipos.add("pepitos");nombresEquipos.add("marimachas");nombresEquipos.add("esnusnu");
        resultadosEquipos.add(resultados1);resultadosEquipos.add(resultados2);resultadosEquipos.add(resultados3);resultadosEquipos.add(resultados4);
       enfrentamientos.add(new Enfrentamiento(LocalDateTime.now(), contricantes1, jueces, "micasa", resultados1, TipoEnfrentamiento.FINALIZADO));
       enfrentamientos.add(new Enfrentamiento(LocalDateTime.now(), contricantes2, jueces, "micasa", resultados2, TipoEnfrentamiento.FINALIZADO));
       String prubea="";
       for (Enfrentamiento enfrentamiento : enfrentamientos) {
        prubea=prubea+enfrentamiento.infoEnfrentamiento();
       }
       JOptionPane.showMessageDialog(null, prubea);
       resultadosEnfrentamientos();
    }

    public static boolean sePasoFechaInscripcion(LocalDate fechaCierreInscripcion) {
        return LocalDate.now().isAfter(fechaCierreInscripcion);
    }

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
            return pedirInt("Error al ingresar\n"+msj, numero);
        }
    }
    public static LocalDateTime pedirFechaHora(String msj, String text) {
        String fecha = JOptionPane.showInputDialog(null, msj + "en este formato con barras, puntos y comas (YYYY/MM/DD, HH:mm)", text);
        try {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd, HH:mm");
        LocalDateTime fechaHecha = LocalDateTime.parse(fecha, formatter);
        return fechaHecha;
        } catch (Exception e) {
            return pedirFechaHora("Error al ingresar, intente de nuevo\n"+msj, fecha);
        }
        

    }
    public static void resultadosEnfrentamientos(){
        String listaResultados="";
        ArrayList<int []> resultadoCada = (ArrayList<int[]>) resultadosEquipos.clone();
        Collections.sort(resultadoCada, new CompararResultadosV());
        for (int index = 0; index < resultadoCada.size(); index++) {
            String resultadito=resultadoCada.get(index)[0]+"  "+resultadoCada.get(index)[1]+"   "+resultadoCada.get(index)[2];
            listaResultados=listaResultados+nombresEquipos.get(index)+"     "+resultadito+"\n\n";
        }
        JOptionPane.showMessageDialog(null, listaResultados);
    }



}
