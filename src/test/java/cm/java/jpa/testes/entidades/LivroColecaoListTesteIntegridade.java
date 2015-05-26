package cm.java.jpa.testes.entidades;

import cm.java.jpa.entidades.LivroColecaoList;
import cm.java.jpa.testes.TestePersistenciaAbstrato;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class LivroColecaoListTesteIntegridade extends TestePersistenciaAbstrato {

  // ======================================
  // =           Testes Unitários         =
  // ======================================

  @Test
  public void deveriaCriarUmLivroComEtiquetas() throws Exception {

    ArrayList<String> etiqueta = new ArrayList<>();
    etiqueta.add("ficção científica");
    etiqueta.add("tem que comprar");
    etiqueta.add("engraçado");
      LivroColecaoList livro = new LivroColecaoList("Guia do Muchileiro das Galáxias", 12.5F, "O Guia do Mochileiro das Galáxias é uma série de comédia ficção científica criada por Douglas Adams.", "1-84023-742-2", 354, false, etiqueta);
    tx.begin();
    em.persist(livro);
    tx.commit();
    assertNotNull("O ID não deveria ser nulo", livro.getId());
    assertEquals(3, livro.getEtiquetas().size());
  }
}