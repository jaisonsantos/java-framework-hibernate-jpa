package cm.java.jpa.testes.entidades;

import cm.java.jpa.entidades.LivroMapeadoPeloXML;
import cm.java.jpa.testes.TestePersistenciaAbstrato;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class LivroMapeadoXMLTesteIntegridade extends TestePersistenciaAbstrato {

  // ======================================
  // =              Testes Unitários      =
  // ======================================

  @Test
  public void deveriaCriarUmLivro() throws Exception {

    LivroMapeadoPeloXML livro = new LivroMapeadoPeloXML("Guia do Mochileiro das Galaxias", 12.5F, "O Guia do Mochileiro das Galaxias é uma série de ficção científica criada por Douglas Adams.", "1-84023-742-2", 354, false);
    tx.begin();
    em.persist(livro);
    tx.commit();
    assertNotNull("O ID não deveria ser nulo", livro.getId());
  }
}