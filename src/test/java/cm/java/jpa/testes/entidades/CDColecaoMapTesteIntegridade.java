package cm.java.jpa.testes.entidades;

import cm.java.jpa.entidades.CDColecaoMap;
import cm.java.jpa.testes.TestePersistenciaAbstrato;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CDColecaoMapTesteIntegridade extends TestePersistenciaAbstrato {

  // ======================================
  // =              Testes Unitários      =
  // ======================================

  @Test
  public void deveriaCriarUmCDComMapsDeTrilhas() throws Exception {

    HashMap<Integer, String> trilhas = new HashMap<>();
    trilhas.put(1, "Wind Up Workin' in a Gas Station");
    trilhas.put(2, "Black Napkins");
    trilhas.put(3, "The Torture Never Stops");
    CDColecaoMap cd = new CDColecaoMap("Zoot Allures", 12.5F, "Lançado em Outubro 1976, e é o melhor album em estudio", trilhas);
    tx.begin();
    em.persist(cd);
    tx.commit();
    assertNotNull("ID should not be null", cd.getId());
    assertEquals(3, cd.getTrilhas().size());
  }
}