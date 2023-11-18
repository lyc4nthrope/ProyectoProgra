public class Jurado extends Persona {

    private String licencia;

    public Jurado(String nombre, int edad, String email, String numeroCelular, Genero genero, String licencia) {
        super(nombre, edad, email, numeroCelular, genero);
        this.licencia = licencia;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    @Override
    public String toString() {
        return super.toString()+" , licencia :" + licencia;
    }

    
    
}
