package modules;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PessoaJuridicaTest {

    @Test
    public void testGetName() {
        PessoaJuridica pj = new PessoaJuridica("Empresa A", 12345678000199L);
        assertEquals("Empresa A", pj.getName());
    }

    @Test
    public void testSetName() {
        PessoaJuridica pj = new PessoaJuridica("Empresa A", 12345678000199L);
        pj.setName("Empresa B");
        assertEquals("Empresa B", pj.getName());
    }
}
