package cm.java.jpa.testes.entidades;

import cm.java.jpa.entidades.TrilhaMusica;
import cm.java.jpa.testes.TestePersistenciaAbstrato;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;


public class TrilhaMusicaTesteIntegridade extends TestePersistenciaAbstrato {

  // ======================================
  // =           Testes Unitários         =
  // ======================================

  @Test
  public void devericaCriarUmaTrilha() throws Exception {

    TrilhaMusica trilha = new TrilhaMusica("Sgt Pepper Lonely Heart Club Ban", 4.53f, "Ouça o trompete com atenção, é o George Harrison tocando");
    tx.begin();
    em.persist(trilha);
    tx.commit();
    assertNotNull("O ID não deve ser nulo", trilha.getId());
  }
}