package cm.java.jpa.testes.entidades;

import cm.java.jpa.entidades.NoticiaAgrupado;
import cm.java.jpa.entidades.NoticiaIdAgrupado;
import cm.java.jpa.testes.TestePersistenciaAbstrato;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class NoticiaAgrupadoTesteIntegridade extends TestePersistenciaAbstrato {

  // ======================================
  // =           Testes Unitários         =
  // ======================================

  @Test
  public void deveriaCriarUmaNoticia() throws Exception {

    NoticiaIdAgrupado noticiaId = new NoticiaIdAgrupado("Projeto Google Code será desativado", "PT");
    NoticiaAgrupado noticia = new NoticiaAgrupado(noticiaId, "Nove anos após o lançamento, o Projeto Google Code será desativado no dia 25 de janeiro de 2016.");
    tx.begin();
    em.persist(noticia);
    tx.commit();

    noticia = em.find(NoticiaAgrupado.class, new NoticiaIdAgrupado("Projeto Google Code será desativado", "PT"));

    assertEquals("Nove anos após o lançamento, o Projeto Google Code será desativado no dia 25 de janeiro de 2016.", noticia.getConteudo());
  }
}