public class Representante extends Persona {

    private String equipo;

    public Representante(String nombre, int edad, String email, String numeroCelular, Genero genero, String equipo) {
        super(nombre, edad, email, numeroCelular, genero);
        this.equipo = equipo;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return  super.toString()+" del equipo " + equipo;
    }

    
    
    
}
