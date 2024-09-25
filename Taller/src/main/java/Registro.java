import java.util.InputMismatchException;
import java.util.Scanner;

class Registro {
    public static void main(String[] args) {
        String[][] registro = crearRegistro();
        imprimirMenu(); // Hay un ''do'' que no va
        int opcion = obtenerDecision();
        if (opcion == 2) {
            try {
                int valor = mostrarMayoresDeEdad(registro);
                System.out.println("Cantidad de personas mayores de edad:" + valor);
            } catch (NumberFormatException e) {
                System.out.println("Matriz inexistente");
            }
        }
        else if (opcion == 3) {
            int menoresDeEdad = 0;
            int queSera = obtenerUltimoEspacio(registro);

            for (int i = 0; i < queSera; i++) {
                if (Integer.parseInt(registro[i][2]) < 18) menoresDeEdad++;
            }

            System.out.println("Hay " + menoresDeEdad + " menores de edad.");
        } else if(opcion == 4) {
            int personasTerceraEdad = 0;
            for (String[] persona : registro) {
                if (Integer.parseInt(persona[2]) >= 60 && persona[1].equals("casado/a")) {
                    personasTerceraEdad++;
                } else if(Integer.parseInt(persona[2]) >= 65 && persona[1].equals("soltero/a")) {
                    personasTerceraEdad++;
                }
            }
            System.out.println("Hay " + personasTerceraEdad + " personas de tercera edad");

        } else if(opcion == 5) {
            int casados = 0;
            int solteros = 0;
            for(String[] persona : registro) {
                if(persona[1].equals("casado/a")) {
                    casados++;
                } else if(persona[1].equals("soltero/a")) {
                    solteros++;
                }
            }

            System.out.println("Hay " + casados + " casados/as.");
            System.out.println("Hay " + solteros + " solteros/as.");
        } else if(opcion == 6) {
            System.out.println("Programa finalizado");
        }
    }
    // Había un } de más en esta línea

    public static String[][] crearRegistro() {
        String[][] registro = new String[50][3]; // Originalmente definía una matriz como un double
        return registro;
    }

    public static void imprimirMenu() {
        System.out.println(""" 
                Menú
                1) Agregar persona.
                2) Mostrar la cantidad de personas mayores de edad.
                3) Mostrar la cantidad de personas menores de edad.
                4) Mostrar la cantidad de personas de tercera edad.
                5) Mostrar la cantidad de personas según estado civil (Soltero/a - Casado/a).
                6)Salir.
                """);
    }

    public static int obtenerDecision() {
        Scanner decision = new Scanner(System.in); // Definido erróneamente
        int opcion = decision.nextInt();  // Falta un ; al final de esta línea - se cambio el nombre
        return opcion;
    }

    public static void segundaOpcion(int opcion, String[][] registro) {
        if (opcion == 2) {
            int valor = mostrarMayoresDeEdad(registro);
            System.out.println("Cantidad de personas mayores de edad:" +valor);
        }
    }

    public static int mostrarMayoresDeEdad(String[][] registro) {
        int mayoresDeEdad = 0;
        for (String[] persona : registro) {
            if (Integer.parseInt(persona[2]) >= 18) {
                mayoresDeEdad++;
            }
        }
        return mayoresDeEdad;
    }

    public static int obtenerUltimoEspacio(String [][] registro) {
        return registro.length - obtenerVacios(registro);
    }

    public static boolean hayCupo(String [][] registro) {
        return obtenerVacios(registro) != 0;
    }

    public static int obtenerVacios(String [][] registro) {
        for(int i = 0; i < registro.length; i++) {
            if(registro[i][0].equals("")){
                return registro.length - i;
            }
        }
        return 0;
    }
}
