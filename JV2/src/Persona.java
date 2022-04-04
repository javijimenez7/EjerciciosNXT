import java.util.Optional;

public class Persona {
    private String nombre;
    private String poblacion;
    private Integer edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String _nombre) {

        nombre = _nombre;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String _poblacion) {

        poblacion = _poblacion;
    }

    public Optional<Integer> getEdad() {

        return Optional.ofNullable(edad);
    }

    public void setEdad(Integer _edad) {

        edad = _edad;
    }


    public Persona(){
    }

    public String obtienePoblacion(){
        Optional <String> poblacion = Optional.ofNullable(this.getPoblacion());
        return poblacion.orElse("Desconocida");
    }
    public String toString(Integer numeroLinea){
        return "Linea "+numeroLinea +". Nombre:"+ this.getNombre() + ",Población: " + this.obtienePoblacion() + ",Edad: " + this.getEdad().get() + "";
    }
}
