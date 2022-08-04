package analizador;

public class Funciones {

    public static String[] funcionQuitarEspacios(String b) {

        String[] split = b.split(" ");

        return split;

    }

    public static boolean buscarOperadorAritmetico(String ar) {

        boolean encontrado = false;

        String operadores_aritmeticos[] = {"plus", "rest", "multiply_by", "divided"};

        //System.out.println(operadores_aritmeticos.length);

        String p = "";
        p = operadores_aritmeticos[0];

        for (int i = 0; i < operadores_aritmeticos.length; i++) {
            p= operadores_aritmeticos[i];

            if (operadores_aritmeticos[i].equals(ar)) {

                encontrado = true;

            }
        }

        return encontrado;
    }

    public static boolean buscarNumero(String a){

        boolean encontrado = false;

        char[] stri = a.toCharArray();

        for (int i = 0; i < a.length(); i++) {

            if(Character.isDigit(stri[i])){

                encontrado = true;

            }else{

                i=a.length();

                encontrado = false;
            }
        }

        return encontrado;

    }

    public static boolean buscarSeparador(String ar) {

        boolean encontrado = false;
        String separadores[] = {":", ";", "  ", ")", "_", ".", ""," ","(",","};
        //System.out.println(separadores.length);

        for (int i = 0; i < separadores.length; i++) {

            if (separadores[i].equals(ar)) {
                encontrado = true;
            } else {

            }

        }

        return encontrado;

    }
    public static boolean buscarOperadoresRelacionales(String ar) {

        boolean encontrado = false;
        String operadores_relacionales[] = {"less","pyke_than","!","pyke_or","less_or","@@","!="};

        //System.out.println(operadores_relacionales.length);

        for (int i = 0; i < operadores_relacionales.length; i++) {

            if (operadores_relacionales[i].equals(ar)) {

                encontrado = true;

            } else {

            }

        }
        return encontrado;
    }


    public static boolean buscarOperadoresLogicos(String ar) {

        boolean encontrado = false;

        String operadores_logicos[] = {"||","??","not"};

        //System.out.println(operadores_logicos.length);
        for (int i = 0; i < operadores_logicos.length; i++) {
            if (operadores_logicos[i].equals(ar)) {

                encontrado = true;
            } else {

            }

        }
        return encontrado;
    }

    public static boolean buscarPalabrasReservadas(String ar) {
        boolean encontrado = false;
        String palabras_reservadas[] = {"str", "int", "void", "include",
                "bool", "list", "fin"};
        //System.out.println(palabras_reservadas.length);
        for (int i = 0; i < palabras_reservadas.length; i++) {

            if (ar.equals(palabras_reservadas[i])) {
                encontrado = true;
            }
        }
        return encontrado;
    }

}
