package cm.java.jpa.testes.entidades;

import cm.java.jpa.entidades.ItemHerancaSuperMapeada;
import cm.java.jpa.entidades.LivroHerancaSuperMapeada;
import cm.java.jpa.testes.TestePersistenciaAbstrato;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ItemHerancaSuperMapeadaTesteIntegridade extends TestePersistenciaAbstrato {

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