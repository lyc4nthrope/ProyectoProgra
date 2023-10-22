public class Persona {
    private String nombre;
    private int edad;
    private String email;
    private String numeroCelular;
    private Genero genero;
    
    public Persona(String nombre, int edad, String email, String numeroCelular, Genero genero) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
        this.numeroCelular = numeroCelular;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    

    
}
