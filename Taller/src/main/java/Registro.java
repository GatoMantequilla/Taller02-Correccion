import java.util.InputMismatchException;
import java.util.Scanner;

class Registro {
    public static void main(String[] args) {
        String[][] registro = crearRegistro();
        boolean ejecucionMenu = true;
        while (ejecucionMenu) {
            imprimirMenu(); // Hay un ''do'' que no va
            int opcion = obtenerDecision();
            realizarAcciones(opcion, registro);
        } // Había un } de más en esta línea
    }

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
                6) Salir.
                """);
    }

    public static int obtenerDecision() {
        Scanner decision = new Scanner(System.in); // Definido erróneamente
        int opcion = decision.nextInt();  // Falta un ; al final de esta línea - se cambio el nombre
        return opcion;
    }

    public static void contarMayoresDeEdad(String[][] registro) {
        try {
            int valor = mostrarMayoresDeEdad(registro);
            System.out.println("Cantidad de personas mayores de edad:" + valor);
        } catch (NumberFormatException e) {
            System.out.println("Matriz inexistente");
        }
    }

    public static void contarMenoresDeEdad(String[][] registro) {
        try {
            int valorMenores = mostrarMenoresDeEdad(registro);
            System.out.println("Cantidad de personas menores de edad:" + valorMenores);
        } catch (NumberFormatException e) {
            System.out.println("Matriz inexistente");
        }
    }

    public static void contarTerceraEdad(String[][] registro) {
        try {
            int personasTerceraEdad = 0;
            for (String[] persona : registro) {
                if (Integer.parseInt(persona[2]) >= 60 && persona[1].equals("casado/a")) {
                    personasTerceraEdad++;
                } else if (Integer.parseInt(persona[2]) >= 65 && persona[1].equals("soltero/a")) {
                    personasTerceraEdad++;
                }
            }
            System.out.println("Hay " + personasTerceraEdad + " personas de tercera edad");
        } catch (NumberFormatException e) {
            System.out.println("Matriz inexistente");
        }
    }

    public static void contarCasadosYSolteros(String[][] registro) {
        try {
            int cantidadCasados = conteoDeCasados(registro);
            int cantidadSolteros = conteoDeSolteros(registro);
            System.out.println("Cantidad de casados:" + cantidadCasados);
            System.out.println("Cantidad de solteros:" + cantidadSolteros);
        } catch (NumberFormatException e) {
            System.out.println("Matriz inexistente");
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

    public static int mostrarMenoresDeEdad(String[][] registro) {
        int menoresDeEdad = 0;
        for (String[] persona : registro) {
            if (Integer.parseInt(persona[2]) < 18) {
                menoresDeEdad++;
            }
        }
        return menoresDeEdad;
    }

    public static int conteoDeSolteros(String[][] registro) {
        int solteros = 0;
        for (String[] persona : registro) {
            if (persona[1].equals("soltero/a")) {
                solteros++;
            }
        }
        return solteros;
    }

    public static int conteoDeCasados(String[][] registro) {
        int casados = 0;
        for (String[] persona : registro) {
            if (persona[1].equals("casado/a")) {
                casados++;
            }
        }
        return casados;
    }

    public static int obtenerUltimoEspacio(String[][] registro) {
        return registro.length - obtenerVacios(registro);
    }

    public static boolean hayCupo(String[][] registro) {
        return obtenerVacios(registro) != 0;
    }

    public static int obtenerVacios(String[][] registro) {
        for (int i = 0; i < registro.length; i++) {
            if (registro[i][0] == null) {
                return registro.length - i;
            }
        }
        return 0;
    }

    public static String recogerRespuesta() {
        String respuesta = "";
        try {
            respuesta = String.valueOf(new Scanner(System.in).next());
        } catch (InputMismatchException e) {
            System.out.println("Opción inválida");
        }
        return respuesta;
    }

    public static void agregarPersona(String[][] registro) {
        if (hayCupo(registro)) {
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

    public static void registrarDatos(String[][] registro, int indiceDisponible, String nombre, String estadoCivil, String edad) {
        registro[indiceDisponible][0] = nombre;
        registro[indiceDisponible][1] = estadoCivil;
        registro[indiceDisponible][2] = edad;
    }

    public static String recogerNombre() {
        String nombre;
        System.out.println("Ingrese el nombre: ");
        nombre = recogerRespuesta();
        return nombre;
    }

    public static String recogerEstadoCivil() {
        String estadoCivil;
        System.out.println("Ingrese el estadoCivil: ");
        estadoCivil = recogerRespuesta();
        return estadoCivil;
    }

    public static String recogerEdad() {
        String edad;
        System.out.println("Ingrese la edad: ");
        edad = recogerRespuesta();
        return edad;
    }

    public static void realizarAcciones(int opcion, String[][] registro) {
        if (opcion == 1) {
            agregarPersona(registro);
        } else if (opcion == 2) {
            contarMayoresDeEdad(registro);
        } else if (opcion == 3) {
            contarMenoresDeEdad(registro);
        } else if (opcion == 4) {
            contarTerceraEdad(registro);
        } else if (opcion == 5) {
            contarCasadosYSolteros(registro);
        } else if (opcion == 6) {
            System.out.println("Programa finalizado");
        } else {
            System.out.println("Opción inválida");
        }
    }
}
