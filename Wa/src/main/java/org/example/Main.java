package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Registro {
    public static void main(String[] args) {
        String [][] registro = new String[50][3];
        int opcion = -1;

        do { imprimirMenu();

            do { recogerOpcion();
            }while (opcion > 0 || opcion < 6);

            if(opcion == 1) {
                agregarPersona(registro);

            } else if(opcion == 2) {
                int mayoresDeEdad = 0;




                for (String[] persona : registro) {
                    if (persona[2] >= 18) mayoresDeEdad++;
                }
                System.out.println("Hay " + mayoresDeEdad + " mayores de edad.");
            } else if(opcion == 3) {

            } else if(opcion == 4) {
                int mmmm = 0;




                for (String[] persona : registro) {
                    if (persona[2] >= 60 && persona[1].equals("casado/a")) {
                        mmmm++;
                    } else if(persona[2] >= 65 && persona[1].equals("soltero/a")) {
                        mmmm++;
                    }
                }
                System.out.println("Hay " + mmmm + " personas de tercera edad");
            } else if(opcion == 5) {
                int NumSolteros = 0;
                int NumCasados = 0;
                for(String[] persona : registro) {
                    if(persona[1].equals("casado/a")) {
                        NumSolteros++;
                    } else if(persona[1].equals("soltero/a")) {
                        NumCasados++;
                    }
                }

                System.out.println("Hay " + NumCasados + " casados/as.");
                System.out.println("Hay " + NumSolteros + " solteros/as.");
            } else if(opcion == 6) {
                System.out.println("Programa finalizado");
            }
        }while (opcion == 6);
    }

    public static int obtenerUltimoEspacio(String[][] registro) {
        return registro.length - opa(registro);
    }

    public static boolean hayCupo(String[][] registro) {
        return opa(registro) != 0;
    }

    public static int opa(String[][] registro) {
        for(int i = 0; i < registro.length; i++) {
            if(registro[i][0].isEmpty()){
                return registro.length - i;
            }
        }

        return 0;
    }


















    public static void imprimirMenu(){
        System.out.println("""
                
                ---------------------------Menú---------------------------
                1) Agregar persona.
                2) Mostrar la cantidad de personas mayores de edad.
                3) Mostrar la cantidad de personas menores de edad.
                4) Mostrar la cantidad de personas de tercera edad.
                5) Mostrar la cantidad de personas según estado civil (Soltero/a - Casado/a).
                6) Salir.
                
                """);
    }

    public static int recogerOpcion(){
        int opcion = 0;
            try {
                opcion = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Opción inválida");
            }
            return opcion;
        }

    public static String recogerRespuesta() {
        String respuesta = "";
        try {
            respuesta = String.valueOf(new Scanner(System.in).nextInt());
        } catch (InputMismatchException e) {
            System.err.println("Opción inválida");
        }
        return respuesta;
    }


    public static void agregarPersona(String [][] registro){
        if(hayCupo(registro))
        {
            String nombre, estadoCivil, edad;
            int indiceDisponible = obtenerUltimoEspacio(registro);
            nombre = recogerNombre();
            estadoCivil = recogerEstadoCivil();
            edad = recogerEdad();
            registrarDatos(registro, indiceDisponible, nombre, estadoCivil, edad);

            System.out.println("Persona agregada.");
        } else {
            System.out.println("No hay cupo en el registro");
        }
    }

    public static void registrarDatos(String [][] registro , int indiceDisponible, String nombre, String estadoCivil,String edad){
        registro[indiceDisponible][0] = nombre;
        registro[indiceDisponible][1] = estadoCivil;
        registro[indiceDisponible][2] = edad;
    }

    public static String recogerNombre(){
        String nombre;
        System.err.println("Ingrese el nombre: ");
        nombre = recogerRespuesta();
        return nombre;
    }

    public static String recogerEstadoCivil(){
        String estadoCivil;
        System.err.println("Ingrese el estadoCivil: ");
        estadoCivil = recogerRespuesta();
        return estadoCivil;
    }

    public static String recogerEdad(){
        String edad;
        System.err.println("Ingrese la edad: ");
        edad = recogerRespuesta();
        return edad;
    }


}
