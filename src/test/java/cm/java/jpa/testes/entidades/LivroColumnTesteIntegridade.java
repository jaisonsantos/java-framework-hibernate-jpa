package cm.java.jpa.testes.entidades;

import cm.java.jpa.entidades.LivroColumn;
import cm.java.jpa.testes.TestePersistenciaAbstrato;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LivroColumnTesteIntegridade extends TestePersistenciaAbstrato {

    // ======================================
    // =           Testes Unitários         =
    // ======================================
    @Test
    public void deveriaCriarUmLivro() throws Exception {

        LivroColumn livro = new LivroColumn("Guia do Mochileiro das Galáxias", 12.5F, "O Guia do Mochileiro das Galáxias é uma série de comédia ficção científica criada por Douglas Adams.", "1-84023-742-2", 354, false);
        tx.begin();
        em.persist(livro);
        tx.commit();
        assertNotNull("O ID não deveria ser nulo", livro.getId());
    }

    @Test
    //@Ignore("updatable = false não funciona")
    public void titleShouldNotBeUpdatable() throws Exception {

        LivroColumn livro = new LivroColumn("Guia do Mochileiro das Galáxias", 12.5F, "O Guia do Mochileiro das Galáxias é uma série de comédia ficção científica criada por Douglas Adams.", "1-84023-742-2", 354, false);
        tx.begin();
        em.persist(livro);
        tx.commit();
        assertNotNull("o ID não deveria ser nulo", livro.getId());
        assertEquals("O titulo deveria ser Guia do Muchileiro das Galáxias", "Guia do Muchileiro das Galáxias", livro.getTitulo());

       
    }
}
