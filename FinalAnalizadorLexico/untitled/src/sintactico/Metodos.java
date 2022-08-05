package sintactico;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Metodos {

    public static String [][] accion;
    public static String [][] ir_A;

    public Metodos(String [][] a, String [][] i){

        this.accion = a;
        this.ir_A = i;

    }

    public static String metodoAccion (String estado, String token){

        String valor_pila = "";

        for (int i = 0; i < accion.length ; i++) {

            for (int j = 0; j < accion[i].length; j++){

                if (accion[i][0].equals(estado) && accion[i][1].equals(token))  {

                    valor_pila = accion[i][2];

                    return valor_pila;
                }

            }

        }

        return "error";

    }

    public static String metodoIrA (String estado, String token){

        String nro_veces = "";

        for (int i = 0; i < accion.length; i++) {

            for (int j = 0; j < accion[i].length ; j++) {
                

                if (accion[i][0].equals(estado) && accion[i][1].equals(token) && accion[i][2].equals("R1"))  {

                    nro_veces = "3";

           
                } else if (accion[i][0].equals(estado) && accion[i][1].equals(token) && accion[i][2].equals("R2")) {

                } else if (accion[i][0].equals(estado) && accion[i][1].equals(token) && accion[i][2].equals("R3")) {

                } else if (accion[i][0].equals(estado) && accion[i][1].equals(token) && accion[i][2].equals("R4")) {

                } else if (accion[i][0].equals(estado) && accion[i][1].equals(token) && accion[i][2].equals("R5")) {

                } else if (accion[i][0].equals(estado) && accion[i][1].equals(token) && accion[i][2].equals("R6")) {

                } else {

                    System.out.println("TOKEN NO ESPERADO");
                }
            }

        }

        return "error";

    }

    public static String[] recorrerEspaciosBn(char[] a,String b) {
        String palabra = "";
        String[] espacio = b.split(" ");
        return espacio;
    }

    public static String leerArchivo (String archivo) throws FileNotFoundException, IOException {
        Path path = Paths.get(archivo);
        File doc =new File(archivo);
        Scanner obj=new Scanner(doc);
        String content="";
        try {
            content = Files.readString(path);
            System.out.println(content);
        }catch (IOException e){
            e.printStackTrace();
        }

        while (obj.hasNextLine()){
            System.out.println(obj.nextLine());
        }
        return content;
    }

}
