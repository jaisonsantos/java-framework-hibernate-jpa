package cm.java.jpa.testes.entidades;

import cm.java.jpa.entidades.NoticiaClasseId;
import cm.java.jpa.testes.TestePersistenciaAbstrato;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class NoticiaClasseIdTesteIntegridade extends TestePersistenciaAbstrato {

  // ======================================
  // =           Testes Unitários         =
  // ======================================

  @Test
  public void deveriaCriarUmaNoticia() throws Exception {

    NoticiaClasseId noticia = new NoticiaClasseId("Projeto Google Code será desativado", "PT", "Nove anos após o lançamento, o Projeto Google Code será desativado no dia 25 de janeiro de 2016.");
    tx.begin();
    em.persist(noticia);
    tx.commit();
    assertNotNull("O Id não deveria ser nulo", noticia.getTitulo());
  }
}