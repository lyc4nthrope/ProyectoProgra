import java.util.*;
import java.util.zip.DataFormatException;
import java.time.*;
import java.time.format.DateTimeFormatter;


import javax.swing.JOptionPane;

public class Prueba {
    

    public static void main(String[] args) {
        int numero= pedirInt("hola");
        String fecha = JOptionPane.showInputDialog(null, "YYYY/MM/DD");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate fechaCierreInscripcion = LocalDate.parse(fecha, formatter);
        System.out.println(sePasoFechaInscripcion(fechaCierreInscripcion)+"");
    }

    public static boolean sePasoFechaInscripcion(LocalDate fechaCierreInscripcion) {
        return LocalDate.now().isAfter(fechaCierreInscripcion);
    }

    public static String pedir(String msj) {
        return JOptionPane.showInputDialog(null, msj);
    }

    public static int pedirInt(String msj) {
        int numero;
        try {
            numero = Integer.parseInt(pedir(msj));
        } catch (Exception e) {
            // TODO: handle exception
            numero = pedirInt(msj);
        }
        return numero;
    }


    


}
