package sintactico;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

import static sintactico.Metodos.*;

import static analizador.metodos.RecorrerEspaciosBn;
import static analizador.metodos.leerArchivo;

public class sintactico {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[][] accion = new String[36][3]; // Tabla Accion
        String[][] ir_A = new String[9][3]; // Tabla ir_A

        // R1 -> E -> E + T
        // R2 -> E -> T
        // R3 -> T -> T * F
        // R4 -> T -> F
        // R5 -> F -> ( E )
        // R6 -> F -> id

        accion[0][0] = "0";
        accion[0][1] = "ID";
        accion[0][2] = "5";
        accion[1][0] = "0";
        accion[1][1] = "(";
        accion[1][2] = "4";
        accion[2][0] = "1";
        accion[2][1] = "+";
        accion[2][2] = "6";
        accion[3][0] = "1";
        accion[3][1] = "$";
        accion[3][2] = "acc";
        accion[4][0] = "2";
        accion[4][1] = "+";
        accion[4][2] = "R2"; //regla 2
        accion[5][0] = "2";
        accion[5][1] = "*";
        accion[5][2] = "7";
        accion[6][0] = "2";
        accion[6][1] = ")";
        accion[6][2] = "R2"; // regla 2
        accion[7][0] = "2";
        accion[7][1] = "$";
        accion[7][2] = "R2"; //regla 2
        accion[8][0] = "3";
        accion[8][1] = "+";
        accion[8][2] = "R4"; // regla 4
        accion[9][0] = "3";
        accion[9][1] = "*";
        accion[9][2] = "R4"; //regla 4
        accion[10][0] = "3";
        accion[10][1] = ")";
        accion[10][2] = "R4"; //regla 4
        accion[11][0] = "3";
        accion[11][1] = "$";
        accion[11][2] = "R4"; //regla 4
        accion[12][0] = "4";
        accion[12][1] = "ID";
        accion[12][2] = "5";
        accion[13][0] = "4";
        accion[13][1] = "(";
        accion[13][2] = "4";
        accion[14][0] = "5";
        accion[14][1] = "+";
        accion[14][2] = "R6"; // regla 6
        accion[15][0] = "5";
        accion[15][1] = "*";
        accion[15][2] = "R6"; // regla 6
        accion[16][0] = "5";
        accion[16][1] = ")";
        accion[16][2] = "R6"; // regla 6
        accion[17][0] = "5";
        accion[17][1] = "$";
        accion[17][2] = "R6"; //regla 6
        accion[18][0] = "6";
        accion[18][1] = "ID";
        accion[18][2] = "5";
        accion[19][0] = "6";
        accion[19][1] = "(";
        accion[19][2] = "4";
        accion[20][0] = "7";
        accion[20][1] = "ID";
        accion[20][2] = "5";
        accion[21][0] = "7";
        accion[21][1] = "(";
        accion[21][2] = "4";
        accion[22][0] = "8";
        accion[22][1] = "+";
        accion[22][2] = "6";
        accion[23][0] = "8";
        accion[23][1] = ")";
        accion[23][2] = "11";
        accion[24][0] = "9";
        accion[24][1] = "+";
        accion[24][2] = "R1"; // regla 1
        accion[25][0] = "9";
        accion[25][1] = "*";
        accion[25][2] = "7";
        accion[26][0] = "9";
        accion[26][1] = ")";
        accion[26][2] = "R1"; // regla 1
        accion[27][0] = "9";
        accion[27][1] = "$";
        accion[27][2] = "R1"; //regla 1
        accion[28][0] = "10";
        accion[28][1] = "+";
        accion[28][2] = "R3"; // regla 3
        accion[29][0] = "10";
        accion[29][1] = "*";
        accion[29][2] = "R3"; //regla 3
        accion[30][0] = "10";
        accion[30][1] = ")";
        accion[30][2] = "R3"; // regla 3
        accion[31][0] = "10";
        accion[31][1] = "$";
        accion[31][2] = "R3"; //regla 3
        accion[32][0] = "11";
        accion[32][1] = "+";
        accion[32][2] = "R5"; //regla 5
        accion[33][0] = "11";
        accion[33][1] = "*";
        accion[33][2] = "R5"; //regla 5
        accion[34][0] = "11";
        accion[34][1] = ")";
        accion[34][2] = "R5"; // regla 5
        accion[35][0] = "11";
        accion[35][1] = "$";
        accion[35][2] = "R5"; // regla 5

        ir_A[0][0] = "0";
        ir_A[0][1] = "E";
        ir_A[0][2] = "1";
        ir_A[1][0] = "O";
        ir_A[1][1] = "T";
        ir_A[1][2] = "2";
        ir_A[2][0] = "0";
        ir_A[2][1] = "F";
        ir_A[2][2] = "3";
        ir_A[3][0] = "4";
        ir_A[3][1] = "E";
        ir_A[3][2] = "8";
        ir_A[4][0] = "4";
        ir_A[4][1] = "T";
        ir_A[4][2] = "2";
        ir_A[5][0] = "4";
        ir_A[5][1] = "F";
        ir_A[5][2] = "3";
        ir_A[6][0] = "6";
        ir_A[6][1] = "T";
        ir_A[6][2] = "9";
        ir_A[7][0] = "6";
        ir_A[7][1] = "F";
        ir_A[7][2] = "3";
        ir_A[8][0] = "7";
        ir_A[8][1] = "F";
        ir_A[8][2] = "10";

        boolean stop = true;
        String estado = "0";
        String valor_pila = "";

        System.out.println("===============Analizador Sintactico=============");
        System.out.println("          Bryan Rodriguez - Fabian Soto          ");
        System.out.println("-------------------------------------------------");
        String text = sc.nextLine();

        Metodos m = new Metodos(accion, ir_A);

        String lec_archivo = m.leerArchivo("C:\\Users\\sotof\\Desktop\\CompiladorLexicoSintactico" +
                "\\FinalAnalizadorLexico\\untitled\\src\\analizador\\exe.txt");

        int c = 0;

        char[] cadena_token = text.toCharArray(); //Se tranformar a un ARRAY de CARACTERES

        String[] lista_caracteres = m.recorrerEspaciosBn(cadena_token, lec_archivo);


        Stack pila = new Stack(); // PILAAAA


        System.out.println("***************************************");
        pila.push(estado);
        pila.mostrar();
        System.out.println(lista_caracteres.length);
        System.out.println("****************************************");

        while (stop) {

            for (int z = 0; z < lista_caracteres.length; ) {

                for (int i = 0; i < accion.length; i++) {

                    for (int j = 0; j < accion[i].length; j++) {

                        if (accion[i][0].equals(estado) && accion[i][1].equals(lista_caracteres[z])) {

                            System.out.println("Posicion Cadena = " + z);
                            System.out.println("CADENA = " + lista_caracteres[z]);
                            System.out.println("ESTADO = " + estado);
                            System.out.println("TOKEN = " + accion[i][1]);
                            System.out.println("SALIDA = " + accion[i][2]);

                            valor_pila = accion[i][2];

                            pila.push(valor_pila);

                            estado = pila.peek();

                            System.out.println("ESTADO = " + estado);
                            pila.mostrar();
                            z++;
                        }
                        String estado_entrada = pila.peek();

                        switch (estado_entrada) {

                            case "R1":

                                z--;

                                pila.pop();
                                pila.pop();
                                pila.pop();
                                pila.pop();

                                System.out.println("======================================================");

                                pila.mostrar();

                                System.out.println("Posicion Cadena = " + z);
                                System.out.println("CADENA = " + lista_caracteres[z]);
                                System.out.println("ESTADO = " + pila.peek());

                                System.out.println("REGLA 1");

                                String estado_nuevo = pila.peek();

                                for (int k = 0; k < ir_A.length; k++) {

                                    for (int l = 0; l < ir_A[k].length; l++) {

                                        if (ir_A[k][0].equals(estado_nuevo) && ir_A[k][1].equals("E")) {

                                            System.out.println("Posicion Cadena = " + z);
                                            System.out.println("CADENA = " + lista_caracteres[z]);
                                            System.out.println("ESTADO = " + estado_nuevo);
                                            System.out.println("ir_A = " + ir_A[k][1]);
                                            System.out.println("SALIDA = " + ir_A[k][2]);

                                            valor_pila = ir_A[k][2];

                                            pila.push(valor_pila);

                                            estado = pila.peek();

                                            System.out.println("ESTADO = " + estado);
                                            pila.mostrar();

                                            break;

                                        }
                                    }
                                }
                                break;

                            case "R2":

                                z--;

                                pila.pop();
                                pila.pop();

                                System.out.println("======================================================");

                                pila.mostrar();

                                System.out.println("Posicion Cadena = " + z);
                                System.out.println("CADENA = " + lista_caracteres[z]);
                                System.out.println("ESTADO = " + pila.peek());

                                System.out.println("REGLA 2");

                                estado_nuevo = pila.peek();

                                for (int k = 0; k < ir_A.length; k++) {

                                    for (int l = 0; l < ir_A[k].length; l++) {

                                        if (ir_A[k][0].equals(estado_nuevo) && ir_A[k][1].equals("E")) {

                                            System.out.println("Posicion Cadena = " + z);
                                            System.out.println("CADENA = " + lista_caracteres[z]);
                                            System.out.println("ESTADO = " + estado_nuevo);
                                            System.out.println("ir_A = " + ir_A[k][1]);
                                            System.out.println("SALIDA = " + ir_A[k][2]);

                                            valor_pila = ir_A[k][2];

                                            pila.push(valor_pila);

                                            estado = pila.peek();

                                            System.out.println("ESTADO = " + estado);
                                            pila.mostrar();

                                            break;

                                        }
                                    }
                                }

                                break;

                            case "R3":

                                z--;

                                pila.pop();
                                pila.pop();
                                pila.pop();
                                pila.pop();

                                System.out.println("======================================================");

                                pila.mostrar();

                                System.out.println("Posicion Cadena = " + z);
                                System.out.println("CADENA = " + lista_caracteres[z]);
                                System.out.println("ESTADO = " + pila.peek());

                                System.out.println("REGLA 2");

                                estado_nuevo = pila.peek();

                                for (int k = 0; k < ir_A.length; k++) {

                                    for (int l = 0; l < ir_A[k].length; l++) {

                                        if (ir_A[k][0].equals(estado_nuevo) && ir_A[k][1].equals("T")) {

                                            System.out.println("Posicion Cadena = " + z);
                                            System.out.println("CADENA = " + lista_caracteres[z]);
                                            System.out.println("ESTADO = " + estado_nuevo);
                                            System.out.println("ir_A = " + ir_A[k][1]);
                                            System.out.println("SALIDA = " + ir_A[k][2]);

                                            valor_pila = ir_A[k][2];

                                            pila.push(valor_pila);

                                            estado = pila.peek();

                                            System.out.println("ESTADO = " + estado);
                                            pila.mostrar();

                                            break;

                                        }
                                    }
                                }


                                break;

                            case "R4":

                                z--;


                                pila.pop();
                                pila.pop();

                                System.out.println("======================================================");

                                pila.mostrar();

                                System.out.println("Posicion Cadena = " + z);
                                System.out.println("CADENA = " + lista_caracteres[z]);
                                System.out.println("ESTADO = " + pila.peek());

                                System.out.println("REGLA 4");

                                estado_nuevo = pila.peek();

                                System.out.println(estado_nuevo);

                                for (int k = 0; k < ir_A.length; k++) {

                                    for (int l = 0; l < ir_A[k].length; l++) {

                                        if (ir_A[k][0].equals(estado_nuevo) && ir_A[k][1].equals("T")) {

                                            System.out.println("Posicion Cadena = " + z);
                                            System.out.println("CADENA = " + lista_caracteres[z]);
                                            System.out.println("ESTADO = " + estado_nuevo);
                                            System.out.println("ir_A = " + ir_A[k][1]);
                                            System.out.println("SALIDA = " + ir_A[k][2]);

                                            valor_pila = ir_A[k][2];

                                            pila.push(valor_pila);

                                            estado = pila.peek();

                                            System.out.println("ESTADO = " + estado);
                                            pila.mostrar();

                                            break;

                                        }
                                    }
                                }

                                break;

                            case "R5":

                                z--;

                                pila.pop();
                                pila.pop();
                                pila.pop();
                                pila.pop();

                                System.out.println("======================================================");

                                pila.mostrar();

                                System.out.println("Posicion Cadena = " + z);
                                System.out.println("CADENA = " + lista_caracteres[z]);
                                System.out.println("ESTADO = " + pila.peek());

                                System.out.println("REGLA 5");

                                estado_nuevo = pila.peek();

                                for (int k = 0; k < ir_A.length; k++) {

                                    for (int l = 0; l < ir_A[k].length; l++) {

                                        if (ir_A[k][0].equals(estado_nuevo) && ir_A[k][1].equals("F")) {

                                            System.out.println("Posicion Cadena = " + z);
                                            System.out.println("CADENA = " + lista_caracteres[z]);
                                            System.out.println("ESTADO = " + estado_nuevo);
                                            System.out.println("ir_A = " + ir_A[k][1]);
                                            System.out.println("SALIDA = " + ir_A[k][2]);

                                            valor_pila = ir_A[k][2];

                                            pila.push(valor_pila);

                                            estado = pila.peek();

                                            System.out.println("ESTADO = " + estado);
                                            pila.mostrar();

                                            break;

                                        }
                                    }
                                }


                                break;

                            case "R6":

                                z--;

                                pila.pop();
                                pila.pop();

                                System.out.println("REGLA 6");

                                estado_nuevo = pila.peek();

                                for (int k = 0; k < ir_A.length; k++) {

                                    for (int l = 0; l < ir_A[k].length; l++) {

                                        if (ir_A[k][0].equals(estado_nuevo) && ir_A[k][1].equals("F")) {

                                            System.out.println("Posicion Cadena = " + z);
                                            System.out.println("CADENA = " + lista_caracteres[z]);
                                            System.out.println("ESTADO = " + estado_nuevo);
                                            System.out.println("ir_A = " + ir_A[k][1]);
                                            System.out.println("SALIDA = " + ir_A[k][2]);

                                            valor_pila = ir_A[k][2];

                                            pila.push(valor_pila);

                                            estado = pila.peek();

                                            System.out.println("ESTADO = " + estado);

                                            break;

                                        }
                                    }
                                }
                                break;

                        }

                        if (accion[i][0].equals(estado) && accion[i][1].equals(lista_caracteres[c]) && accion[i][2].equals("acc")) {

                            System.out.println("El analisis sintactico ha sido completado");

                            stop = false;
                            break;

                        }
                    }
                }

            }
        }
    }
}


//        while (stop == true) {
//
//            int c = 0;
//
//            for (int i = 0; i < accion.length; i++) {
//
//                for (int j = 0; j < accion[i].length; j++) {
//
//                    while (c != lista_caracteres.length) {
//
//                        if (accion[i][0].equals(estado) && accion[i][1].equals(lista_caracteres[c])) {
//
//                            valor_pila = accion[i][2];
//                            pila.push(valor_pila);
//                            estado = pila.peek();
//
//                            c++;
//
//                        } else if (accion[i][0].equals(estado) && accion[i][1].equals(lista_caracteres[c]) && accion[i][2].equals("R1")) {
//                            pila.pop();
//                            pila.pop();
//                            pila.pop();
//                            estado = pila.peek();
//                            for (int k = 0; k < ir_A.length; k++) {
//                                for (int l = 0; l < ir_A[k].length; l++) {
//                                    if (ir_A[i][0].equals(estado) && ir_A[i][1].equals("E")) {
//                                        valor_pila = ir_A[i][2];
//                                        pila.push(valor_pila);
//                                    }
//                                }
//                            }
//                            System.out.println("Condicional2");
//                        } else if (accion[i][0].equals(estado) && accion[i][1].equals(lista_caracteres[c]) && accion[i][2].equals("R2")) {
//                            pila.pop();
//                            estado = pila.peek();
//                            for (int k = 0; k < ir_A.length; k++) {
//                                for (int l = 0; l < ir_A[k].length; l++) {
//                                    if (ir_A[i][0].equals(estado) && ir_A[i][1].equals("E")) {
//                                        valor_pila = ir_A[i][2];
//                                        pila.push(valor_pila);
//                                    }
//                                }
//                            }
//                            System.out.println("Condicional3");
//                        } else if (accion[i][0].equals(estado) && accion[i][1].equals(lista_caracteres[c]) && accion[i][2].equals("R3")) {
//                            pila.pop();
//                            pila.pop();
//                            pila.pop();
//                            estado = pila.peek();
//                            for (int k = 0; k < ir_A.length; k++) {
//                                for (int l = 0; l < ir_A[k].length; l++) {
//                                    if (ir_A[i][0].equals(estado) && ir_A[i][1].equals("T")) {
//                                        valor_pila = ir_A[i][2];
//                                        pila.push(valor_pila);
//                                    }
//                                }
//                            }
//                            System.out.println("Condicional4");
//                        } else if (accion[i][0].equals(estado) && accion[i][1].equals(lista_caracteres[c]) && accion[i][2].equals("R4")) {
//                            pila.pop();
//                            estado = pila.peek();
//                            for (int k = 0; k < ir_A.length; k++) {
//                                for (int l = 0; l < ir_A[k].length; l++) {
//                                    if (ir_A[i][0].equals(estado) && ir_A[i][1].equals("T")) {
//                                        valor_pila = ir_A[i][2];
//                                        pila.push(valor_pila);
//                                    }
//                                }
//                            }
//                            System.out.println("Condicional5");
//                        } else if (accion[i][0].equals(estado) && accion[i][1].equals(lista_caracteres[c]) && accion[i][2].equals("R5")) {
//                            pila.pop();
//                            pila.pop();
//                            pila.pop();
//                            estado = pila.peek();
//                            for (int k = 0; k < ir_A.length; k++) {
//                                for (int l = 0; l < ir_A[k].length; l++) {
//                                    if (ir_A[i][0].equals(estado) && ir_A[i][1].equals("F")) {
//                                        valor_pila = ir_A[i][2];
//                                        pila.push(valor_pila);
//                                    }
//                                }
//                            }
//                            System.out.println("Condicional6");
//                        } else if (accion[i][0].equals(estado) && accion[i][1].equals(lista_caracteres[c]) && accion[i][2].equals("R6")) {
//                            pila.pop();
//                            estado = pila.peek();
//                            for (int k = 0; k < ir_A.length; k++) {
//                                for (int l = 0; l < ir_A[k].length; l++) {
//                                    if (ir_A[i][0].equals(estado) && ir_A[i][1].equals("F")) {
//                                        valor_pila = ir_A[i][2];
//                                        pila.push(valor_pila);
//                                    }
//                                }
//                            }
//                            System.out.println("Condicional7");
//                        } else {
//
//                            if (accion[i][0].equals(estado) && accion[i][1].equals(lista_caracteres[c]) && accion[i][2].equals("acc")) {
//                                stop = false;
//                                System.out.println("Analisis sintactico terminado con exito!");
//                                System.out.println("FINAL");
//                                System.out.println(estado);
//                                pila.mostrar();
//                                stop = false;
//                            }
//
//                        }
//
//                    }
//
//                    stop = false;
//                    break;
//
//
//                }
//
//            }
//
//        }




        /*

        //Mostrar por pantalla los valores que contiene la matriz

        System.out.println("valores introducidos:");
        for (int i = 0; i < accion.length; i++) {
            for (int j = 0; j < accion[i].length; j++) {
                System.out.print(accion[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println("valores introducidos:");
        for (int i = 0; i < ir_A.length; i++) {

            for (int j = 0; j < ir_A[i].length; j++) {

                System.out.print(ir_A[i][j] + " ");

            }

            System.out.println();
        }


         */






