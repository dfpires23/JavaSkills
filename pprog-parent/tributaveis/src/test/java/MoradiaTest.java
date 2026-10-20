import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import org.dei.tributaveis.Moradia;
import org.dei.tributaveis.Cores;

class MoradiaTest {

    @Test
    void testConstrutor() {
        Moradia m = new Moradia("Rua do Bocage", 90.0f, Cores.CINZENTO);
        assertEquals("Rua do Bocage", m.getMorada());
        assertEquals(90.0f, m.getArea());
        assertEquals(Cores.CINZENTO, m.getCor());
    }

    @Test
    void testSetters() {
        Moradia m = new Moradia("Rua do Bocage", 90.0f, Cores.CINZENTO);
        m.setMorada("Rua do Bocage, nº 10");
        m.setArea(100.0f);
        m.setCor(Cores.ENCARNADO);
        assertEquals("Rua do Bocage, nº 10", m.getMorada());
        assertEquals(100.0f, m.getArea());
        assertEquals(Cores.ENCARNADO, m.getCor());
    }

    @Test
    void testToString() {
        Moradia m = new Moradia("Rua do Bocage", 90.0f, Cores.CINZENTO);
        String expected = "Moradia situada na Rua do Bocage com área de 90,0 tem cor cinzento";
        assertEquals(expected, m.toString());
    }

    @Test
    void testCalcularValorImposto() {
        Moradia m = new Moradia("Rua do Bocage", 90.0f, Cores.CINZENTO);
        assertEquals(180.0f, m.calcularValorImposto());
    }
}