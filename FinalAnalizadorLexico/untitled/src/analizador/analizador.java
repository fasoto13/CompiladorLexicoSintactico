package analizador;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import static analizador.metodos.*;


public class analizador {
    public static void main(String[] args) throws IOException {
        Scanner sr = new Scanner(System.in);
        System.out.println("===============Analizador lexico=============");
        System.out.println("             Bryan Rodriguez 1Bim            ");
        System.out.println("---------------------------------------------");
        int estado = 1;
        int c = 0;
        String text = sr.nextLine();
        String lec_archivo = leerArchivo("C:\\Users\\sotof\\Desktop\\CompiladorLexicoSintactico\\FinalAnalizadorLexico" +
                "\\untitled\\src\\analizador\\exe.txt");
        char[] stri = text.toCharArray();
        if (text == "") {
            text = "_";
        }
        String[] caracter = RecorrerEspaciosBn(stri, lec_archivo);
        while (c != caracter.length) {

            switch (estado) {
                case 1:

                    if (buscarAritmetico(caracter[c])) {
                        estado = 2;
                    }

                    if (buscarNumero(caracter[c])) {
                        estado = 4;
                    }

                    if (buscarSeparador(caracter[c])) {
                        estado = 3;
                    }
                    if (buscar_OpRelacional(caracter[c])) {
                        estado = 7;
                    }
                    if (buscar_OpLogico(caracter[c])) {
                        estado = 8;
                    }
                    if (buscarAritmetico(caracter[c]) == false && buscarSeparador(caracter[c]) == false
                            && buscar_OpLogico(caracter[c]) == false && buscar_OpRelacional(caracter[c]) == false
                            && buscarNumero(caracter[c]) == false) {
                        if (buscarPReservada(caracter[c])) {
                            estado = 5;
                        } else {
                            estado = 6;
                        }
                    }

                    break;
                case 2:
                    System.out.println(caracter[c] + " -> es un operador aritmetico");
                    estado = 1;
                    c++;

                    break;
                case 3:
                    System.out.println(caracter[c] + " -> es un separador");
                    estado = 1;
                    c++;

                    break;
                case 4:
                    System.out.println(caracter[c] + " -> es un numero");
                    estado = 1;
                    c++;
                    break;
                case 5:
                    System.out.println(caracter[c] + " -> es una palabra reservada");
                    estado = 1;
                    c++;
                    break;
                case 6:
                    System.out.println(caracter[c] + " -> es un identificador");
                    estado = 1;
                    c++;
                    break;
                case 7:
                    System.out.println(caracter[c] + " -> es un organizador relacional");
                    estado = 1;
                    c++;
                    break;
                case 8:
                    System.out.println(caracter[c] + " -> es un identificador logico");
                    estado = 1;
                    c++;
                    break;

            }
        }
    }
}
