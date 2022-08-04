package analizador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class metodos {
    public static boolean buscarAritmetico(String cadena) {
        boolean estado = false;
        String op_aritmeticos[] = {"^","$","\\","?","--"};
        String linea ="";
        linea = op_aritmeticos[0];
        for (int i = 0; i < op_aritmeticos.length; i++) {
            linea = op_aritmeticos[i];
            if (op_aritmeticos[i].equals(cadena)) {
                estado = true;
            }
        }
        return estado;
    }

    public static boolean buscarSeparador(String cadena) {
        boolean estado = false;
        String separadores[] = {":", ";", "  ", ")", "_", ".", ""," ","(",",","[","]"};
        for (int i = 0; i < separadores.length; i++) {
            if (separadores[i].equals(cadena)) {
                estado = true;
            }
        }
        return estado;
    }
    public static boolean buscar_OpRelacional(String cadena) {
        boolean estado = false;
        String op_aritmeticos[] = {"**","hefes","zeu","!","her","apo","AA","are"};
        for (int i = 0; i < op_aritmeticos.length; i++) {
            if (op_aritmeticos[i].equals(cadena)) {
                estado = true;
            }
        }
        return estado;
    }


    public static boolean buscar_OpLogico(String cadena) {
        boolean estado = false;
        String op_logicos[] = {"tim","ate","kra"};
        for (int i = 0; i < op_logicos.length; i++) {
            if (op_logicos[i].equals(cadena)) {
                estado = true;
            }
        }
        return estado;
    }

    public static boolean buscarPReservada(String cadena) {
        boolean estado = false;
        String palabras_reservadas[] = {"pandora", "prometeo", "medusa", "aquiles",
                "castor - polux", "andromeda", "switch", "bool", "main", "si", "finsi","int"
                ,"char","inicio","fin"};
        for (int i = 0; i < palabras_reservadas.length; i++) {
            if (cadena.equals(palabras_reservadas[i])) {
                estado = true;
            }
        }
        return estado;
    }

    public static String[] RecorrerEspaciosBn(char[] a,String b) {
        String palabra = "";
        String[] espacio = b.split(" ");
        return espacio;
    }

    public static boolean buscarNumero(String cadena){
        boolean estado = false;
        char[] linea = cadena.toCharArray();
        for (int i = 0; i < cadena.length(); i++) {
            if(Character.isDigit(linea[i])){
                estado=true;
            }else{
                i=cadena.length();
                estado=false;
            }
        }

        return estado;

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
