package cm.java.jpa.testes.entidades;

import cm.java.jpa.entidades.LivroHerancaTransiente;
import cm.java.jpa.testes.TestePersistenciaAbstrato;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ItemHerancaTransienteTesteIntegridade extends TestePersistenciaAbstrato {

  // ======================================
  // =           Testes unitários         =
  // ======================================
  @Test
  public void deveriaCriarUmLivro() throws Exception {


    LivroHerancaTransiente livro = new LivroHerancaTransiente("Guia do Mochileiro das Galaxias", 21f, "Melhor livro de TI", "123-456-789", "Pinguin", 321, false);
    tx.begin();
    em.persist(livro);
    tx.commit();
    assertNotNull("O ID do Livro não deveria ser nulo...", livro.getId());
  }
}