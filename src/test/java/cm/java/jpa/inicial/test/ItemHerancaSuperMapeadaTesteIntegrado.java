package cm.java.jpa.inicial.test;

import cm.java.jpa.entidades.ItemHerancaSuperMapeada;
import cm.java.jpa.entidades.LivroHerancaSuperMapeada;
import cm.java.jpa.inicial.TestePersistenciaAbstrato;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ItemHerancaSuperMapeadaTesteIntegrado extends TestePersistenciaAbstrato {

  // ======================================
  // =              Testes Unitários      =
  // ======================================
  @Test
  public void deveriaCriarUmLivro() throws Exception {

    LivroHerancaSuperMapeada livro = new LivroHerancaSuperMapeada("Guia do Mochileiro das Galáxias", 21f, "Melhor livro de TI", "123-456-789", "Pinguin", 321, false);
    ItemHerancaSuperMapeada item = new ItemHerancaSuperMapeada("Guia do Mochileiro das Galáxias", 21f, "Melhor livro de TI");
    
    tx.begin();
    em.persist(livro);
    tx.commit();
    assertNotNull("A ID do livro não deveria ser nula", livro.getId());
  }
}