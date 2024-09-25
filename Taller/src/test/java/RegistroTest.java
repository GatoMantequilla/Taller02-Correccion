import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegistroTest {

    @Test
    public void testMostrarMayoresDeEdad_conMayoresDeEdad() {
        String[][] registro = {
                {"Juan", "soltero/a", "20"},
                {"Ana", "casado/a", "25"},
                {"Pedro", "soltero/a", "15"}
        };
        assertEquals(2, Registro.mostrarMayoresDeEdad(registro));
    }

    @Test
    public void testMostrarMenoresDeEdad_conMenoresDeEdad() {
        String[][] registro = {
                {"Juan", "soltero/a", "20"},
                {"Ana", "casado/a", "15"},
                {"Pedro", "soltero/a", "10"}
        };
        assertEquals(2, Registro.mostrarMenoresDeEdad(registro));
    }

    @Test
    public void testMostrarMenoresDeEdad_sinMenoresDeEdad() {
        String[][] registro = {
                {"Pedro", "soltero/a", "18"},
                {"Ana", "casado/a", "25"}
        };
        assertEquals(0, Registro.mostrarMenoresDeEdad(registro));
    }

    @Test
    public void testHayCupo_cupoDisponible() {
        String[][] registro = new String[50][3];
        registro[0][0] = "Juan";
        assertTrue(Registro.hayCupo(registro));
    }

    @Test
    public void testHayCupo_sinCupo() {
        String[][] registro = new String[50][3];
        for (int i = 0; i < 50; i++) {
            registro[i][0] = "Persona " + i;
        }
        assertFalse(Registro.hayCupo(registro));
    }

    @Test
    public void testObtenerUltimoEspacio() {
        String[][] registro = new String[50][3];
        registro[0][0] = "Juan";
        assertEquals(1, Registro.obtenerUltimoEspacio(registro));
    }


}
