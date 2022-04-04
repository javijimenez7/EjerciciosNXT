import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {

        File archivo;
        FileReader fr;
        BufferedReader br;

        List<Persona> personas = new ArrayList<>();
        try {
            archivo = new File("C:\\Users\\javier.jimenez\\Desktop\\EjerciciosNXT\\JV2\\personas.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");

                if (partes.length > 2) {

                    Persona persona = new Persona();
                    persona.setNombre(partes[0]);

                    if (!partes[1].equals("")) {
                        persona.setPoblacion(partes[1]);
                    } else {
                        persona.setPoblacion(null);
                    }

                    persona.setEdad(Integer.parseInt(partes[2].replace(" ", "")));
                    personas.add(persona);
                }
            }
            AtomicInteger cont = new AtomicInteger();
            personas.stream().filter(p -> p.getEdad().orElse(25) < 25).toList()
                    .forEach(p -> System.out.println(p.toString(cont.incrementAndGet())));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
