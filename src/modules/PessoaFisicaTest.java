package modules;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PessoaFisicaTest {

    @Test
    public void testGetName() {
        PessoaFisica pf = new PessoaFisica("John Doe", 12345678901L);
        assertEquals("John Doe", pf.getName());
    }

    @Test
    public void testSetName() {
        PessoaFisica pf = new PessoaFisica("John Doe", 12345678901L);
        pf.setName("Jane Doe");
        assertEquals("Jane Doe", pf.getName());
    }
}
