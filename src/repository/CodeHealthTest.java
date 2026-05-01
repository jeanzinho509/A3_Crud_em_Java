package repository;

import static org.junit.Assert.*;
import org.junit.Test;
import modules.PessoaJuridica;
import modules.PessoaFisica;

public class CodeHealthTest {

    @Test
    public void testCreateWithWrongType() {
        RepositoryPessoaFisica repo = new RepositoryPessoaFisica();
        PessoaJuridica pj = new PessoaJuridica("Company", 12345678000199L);
        boolean result = repo.create(pj);
        assertFalse("create should return false when passing wrong type", result);
    }

    @Test
    public void testUpdateWithWrongTypeDoesNotThrow() {
        RepositoryPessoaFisica repo = new RepositoryPessoaFisica();
        PessoaJuridica pj = new PessoaJuridica("Company", 12345678000199L);
        // This should not throw ClassCastException anymore and should return false
        boolean result = repo.update(pj);
        assertFalse("update should return false when passing wrong type", result);
    }

    @Test
    public void testCreateWithWrongTypePJ() {
        RepositoryPessoaJuridica repo = new RepositoryPessoaJuridica();
        PessoaFisica pf = new PessoaFisica("John", 12345678901L);
        boolean result = repo.create(pf);
        assertFalse("create should return false when passing wrong type", result);
    }

    @Test
    public void testUpdateWithWrongTypeDoesNotThrowPJ() {
        RepositoryPessoaJuridica repo = new RepositoryPessoaJuridica();
        PessoaFisica pf = new PessoaFisica("John", 12345678901L);
        boolean result = repo.update(pf);
        assertFalse("update should return false when passing wrong type", result);
    }
}
