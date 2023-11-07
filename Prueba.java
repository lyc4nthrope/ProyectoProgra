import java.util.*;
import java.util.zip.DataFormatException;
import java.time.*;
import java.time.format.DateTimeFormatter;


import javax.swing.JOptionPane;

public class Prueba {
    

    public static void main(String[] args) {
        LocalDateTime num=pedirFechaHora("Fecha", null);
        System.out.println(num);
       
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

    


}
