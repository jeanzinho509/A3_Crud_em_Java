package repository;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import modules.PessoaFisica;

public class RepositoryPessoaFisicaTest {
    private RepositoryPessoaFisica repository;

    @Before
    public void setUp() {
        repository = new RepositoryPessoaFisica();
    }

    @Test
    public void testDeleteEmptyRepository() {
        boolean result = repository.delete(12345678901L);
        assertFalse("Delete on empty repository should return false", result);
    }

    @Test
    public void testDeleteNonExistentId() {
        PessoaFisica pf = new PessoaFisica("John Doe", 11122233344L);
        repository.create(pf);

        boolean result = repository.delete(99988877766L);
        assertFalse("Delete with non-existent ID should return false", result);
        assertEquals("Repository size should remain 1", 1, repository.read().size());
    }

    @Test
    public void testDeleteExistentId() {
        long cpf = 11122233344L;
        PessoaFisica pf = new PessoaFisica("John Doe", cpf);
        repository.create(pf);

        boolean result = repository.delete(cpf);
        assertTrue("Delete with existent ID should return true", result);
        assertEquals("Repository size should be 0", 0, repository.read().size());
    }
}
