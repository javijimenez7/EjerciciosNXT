import java.util.Optional;

public class Persona {
    private String Nombre;
    private String Poblacion;
    private Integer Edad;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getPoblacion() {
        return Poblacion;
    }

    public void setPoblacion(String poblacion) {
        Poblacion = poblacion;
    }

    public Integer getEdad() {
        return Edad;
    }

    public void setEdad(Integer edad) {
        Edad = edad;
    }


    public Persona(){
    }

    public String obtienePoblacion(){
        Optional <String> poblacion = Optional.ofNullable(this.getPoblacion());
        return poblacion.isPresent() ? poblacion.get() : "Desconocida";
    }

}
