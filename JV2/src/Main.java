import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){

        File archivo;
        FileReader fr ;
        BufferedReader br;

        List<Persona> personas = new ArrayList<>();
       try{
           archivo = new File ("C:\\Users\\javier.jimenez\\Desktop\\EjerciciosNXT\\JV2\\personas.txt");
           fr = new FileReader (archivo);
           br = new BufferedReader(fr);
           String linea;

           while((linea = br.readLine())!=null) {
               String[] partes = linea.split(":");

               if (partes.length == 3) {

                   Persona p = new Persona();
                   p.setNombre(partes[0]);

                   if(partes[1]!="") {
                       p.setPoblacion(partes[1]);
                   } else {
                       p.setPoblacion(null);
                   }

                   p.setEdad(Integer.parseInt(partes[2].replace(" ","")));
                   personas.add(p);
               }
           }

           personas.stream().filter(p->p.getEdad()<25).forEach((p)-> System.out.println("Nombre: "+p.getNombre()+",Población: "+p.obtienePoblacion()+",Edad: "+p.getEdad()+""));

       } catch (Exception e){
           e.printStackTrace();
       }




    }
}
