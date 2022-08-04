package sintactico;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String [][] accion = new String[36][3]; // Tabla Accion
        String [][] ir_A = new String[9][3]; // Tabla ir_A

        accion[0][0] = "0"; accion[0][1] = "ID";accion[0][2] = "5";
        accion[1][0] = "0"; accion[1][1] = "("; accion[1][2] = "4";
        accion[2][0] = "1"; accion[2][1] = "+"; accion[2][2] = "6";
        accion[3][0] = "1"; accion[3][1] = "$"; accion[3][2] = "acc";
        accion[4][0] = "2"; accion[4][1] = "+"; accion[4][2] = "2"; //regla 2
        accion[5][0] = "2"; accion[5][1] = "*"; accion[5][2] = "7";
        accion[6][0] = "2"; accion[6][1] = ")"; accion[6][2] = "2"; // regla 2
        accion[7][0] = "2"; accion[7][1] = "$"; accion[7][2] = "2"; //regla 2
        accion[8][0] = "3"; accion[8][1] = "+"; accion[8][2] = "4"; // regla 4
        accion[9][0] = "3"; accion[9][1] = "*"; accion[9][2] = "4"; //regla 4
        accion[10][0] = "3"; accion[10][1] = ")"; accion[10][2] = "4"; //regla 4
        accion[11][0] = "3"; accion[11][1] = "$"; accion[11][2] = "4"; //regla 4
        accion[12][0] = "4"; accion[12][1] = "ID"; accion[12][2] = "5";
        accion[13][0] = "4"; accion[13][1] = "("; accion[13][2] = "4";
        accion[14][0] = "5"; accion[14][1] = "+"; accion[14][2] = "6"; // regla 6
        accion[15][0] = "5"; accion[15][1] = "*"; accion[15][2] = "6"; // regla 6
        accion[16][0] = "5"; accion[16][1] = ")"; accion[16][2] = "6"; // regla 6
        accion[17][0] = "5"; accion[17][1] = "$"; accion[17][2] = "6"; //regla 6
        accion[18][0] = "6"; accion[18][1] = "ID"; accion[18][2] = "5";
        accion[19][0] = "6"; accion[19][1] = "("; accion[19][2] = "4";
        accion[20][0] = "7"; accion[20][1] = "ID"; accion[20][2] = "5";
        accion[21][0] = "7"; accion[21][1] = "("; accion[21][2] = "4";
        accion[22][0] = "8"; accion[22][1] = "+"; accion[22][2] = "6";
        accion[23][0] = "8"; accion[23][1] = ")"; accion[23][2] = "11";
        accion[24][0] = "9"; accion[24][1] = "+"; accion[24][2] = "1"; // regla 1
        accion[25][0] = "9"; accion[25][1] = "*"; accion[25][2] = "7";
        accion[26][0] = "9"; accion[26][1] = ")"; accion[26][2] = "1"; // regla 1
        accion[27][0] = "9"; accion[27][1] = "$"; accion[27][2] = "1"; //regla 1
        accion[28][0] = "10"; accion[28][1] = "+"; accion[28][2] = "3"; // regla 3
        accion[29][0] = "10"; accion[29][1] = "*"; accion[29][2] = "3"; //regla 3
        accion[30][0] = "10"; accion[30][1] = ")"; accion[30][2] = "3"; // regla 3
        accion[31][0] = "10"; accion[31][1] = "$"; accion[31][2] = "3"; //regla 3
        accion[32][0] = "11"; accion[32][1] = "+"; accion[32][2] = "5"; //regla 5
        accion[33][0] = "11"; accion[33][1] = "*"; accion[33][2] = "5"; //regla 5
        accion[34][0] = "11"; accion[34][1] = ")"; accion[34][2] = "5"; // regla 5
        accion[35][0] = "11"; accion[35][1] = "$"; accion[35][2] = "5"; // regla 5

        ir_A[0][0] = "0"; ir_A[0][1] = "E"; ir_A[0][2] = "1";
        ir_A[1][0] = "O"; ir_A[1][1] = "T"; ir_A[1][2] = "2";
        ir_A[2][0] = "0"; ir_A[2][1] = "F"; ir_A[2][2] = "3";
        ir_A[3][0] = "4"; ir_A[3][1] = "E"; ir_A[3][2] = "8";
        ir_A[4][0] = "4"; ir_A[4][1] = "T"; ir_A[4][2] = "2"; //regla 2
        ir_A[5][0] = "4"; ir_A[5][1] = "F"; ir_A[5][2] = "3";
        ir_A[6][0] = "6"; ir_A[6][1] = "T"; ir_A[6][2] = "9"; // regla 2
        ir_A[7][0] = "6"; ir_A[7][1] = "F"; ir_A[7][2] = "3"; //regla 2
        ir_A[8][0] = "7"; ir_A[8][1] = "F"; ir_A[8][2] = "10"; // regla 4



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

    }
}
