package cm.java.jpa.testes.entidades;

import cm.java.jpa.entidades.LivroHerancaAbstrata;
import cm.java.jpa.testes.TestePersistenciaAbstrato;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ItemHerancaAbastrataTesteIntegridade extends TestePersistenciaAbstrato {

  // ======================================
  // =              Testes Unitários      =
  // ======================================
  @Test
  public void deveriaCriarUmLivro() throws Exception {

    LivroHerancaAbstrata livro = new LivroHerancaAbstrata("Guia do Mochileiro das Galaxias", 21f, "Melhor livro de TI", "123-456-789", "Pinguin", 321, false);
    tx.begin();
    em.persist(livro);
    tx.commit();
    assertNotNull("A ID do Livro não deveria ser nula...", livro.getId());
  }
}