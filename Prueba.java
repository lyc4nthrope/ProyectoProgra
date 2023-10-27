import java.util.*;
import java.util.zip.DataFormatException;
import java.time.*;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class Prueba {

    public static void main(String[] args) {
        String fecha = JOptionPane.showInputDialog(null, "YYYY/MM/DD");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate fechaCierreInscripcion = LocalDate.parse(fecha, formatter);
        System.out.println(sePasoFechaInscripcion(fechaCierreInscripcion)+"");
    }

    public static boolean sePasoFechaInscripcion(LocalDate fechaCierreInscripcion) {
        return LocalDate.now().isAfter(fechaCierreInscripcion);
    }
}