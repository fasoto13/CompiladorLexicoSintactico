package analizador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import static analizador.Funciones.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("***************************************************");
        System.out.println("Analizador Léxico");
        System.out.println("Nombre:Fabian Soto");
        System.out.println("***************************************************");

        int estado = 1; /* Estados */

        int c = 0; /* Recorre la cadena */

        String ubi_archivo = "untitled/src/analizador/ejemplo.txt"; /* Ruta de ubicacion del archivo a leer */

        /* LECTURA DEL ARCHIVO */

        Path path = Paths.get(ubi_archivo);

        File doc = new File(ubi_archivo);

        Scanner obj = new Scanner(doc);

        String content = ""; // Almacenara lo que encuentre en el txt

        try {

            content = Files.readString(path);

        } catch (IOException e) {

            e.printStackTrace();
        }

        /*while (obj.hasNextLine()){

            System.out.println(obj.nextLine());

        }*/

        /* FIN DE LA LECTURA */

        // System.out.println(content); // imprimir el contenido del archivo

        String[] arrays = funcionQuitarEspacios(content); // Envia a la funcion que nos ayudara a quitar los espacios
                                                          // que encuentre en el archivo

        while (c != arrays.length) {

            System.out.println(arrays[c]);

            switch (estado) {

                case 1:

                    if (buscarOperadorAritmetico(arrays[c])) { // buscar operadores aritmeticos

                        estado = 2;

                    }

                    if (buscarNumero (arrays[c]) ) { // buscar numero

                        estado = 4;

                    }

                    if (buscarSeparador(arrays[c])) { //buscar separador

                        estado = 3;

                    }

                    if (buscarOperadoresRelacionales(arrays[c])) { // buscar operadores relacionales

                        estado = 7;

                    }
                    if (buscarOperadoresLogicos(arrays[c])) { // Buscar operadores logicos

                        estado = 8;

                    }

                    if (buscarOperadorAritmetico(arrays[c]) == false && buscarSeparador(arrays[c]) == false
                            && buscarOperadoresLogicos(arrays[c]) == false && buscarOperadoresRelacionales(arrays[c]) == false
                            && buscarNumero(arrays[c]) == false) {

                        if (buscarPalabrasReservadas(arrays[c])) { // Buscar palabras reservadas

                            estado = 5;

                        } else {

                            estado = 6;

                        }

                    }

                    break;

                case 2: // Es un operador aritmetico

                    System.out.println(arrays[c] + " ---> es un operador aritmetico");

                    estado = 1;

                    c++;

                    break;

                case 3:

                    System.out.println(arrays[c] + " ---> es un separador");

                    estado = 1;

                    c++;

                    break;
                case 4:

                    System.out.println(arrays[c] + " ---> es un numero");

                    estado = 1;

                    c++;

                    break;
                case 5:

                    System.out.println(arrays[c] + " ---> es una palabra reservada");

                    estado = 1;

                    c++;

                    break;

                case 6:

                    System.out.println(arrays[c] + " ---> es un identificador");

                    estado = 1;

                    c++;

                    break;

                case 7:

                    System.out.println(arrays[c] + " ---> es un operador relacional");

                    estado = 1;

                    c++;

                    break;
                case 8:

                    System.out.println(arrays[c] + " ---> es operador logico");

                    estado = 1;

                    c++;

                    break;


            }


        }

    }
}
