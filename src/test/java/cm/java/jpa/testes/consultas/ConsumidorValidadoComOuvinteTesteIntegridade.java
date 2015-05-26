package cm.java.jpa.testes.consultas;

import cm.java.jpa.consultas.ConsumidorValidadoComOuvinte;
import cm.java.jpa.testes.TestePersistenciaAbstrato;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class ConsumidorValidadoComOuvinteTesteIntegridade extends TestePersistenciaAbstrato {

  // ======================================
  // =           Testes unitários         =
  // ======================================

  @Test
  public void deveriaVerificarIdadeConsumidor() throws Exception {

     // Instancio um objeto
    ConsumidorValidadoComOuvinte consumidor = new ConsumidorValidadoComOuvinte("Bruno", "Penha", "cm.java.frameworks@gmail.com", "1234565", new Date(), new Date());
    assertFalse(em.contains(consumidor));

    // Persisto o objeto
    tx.begin();
    em.persist(consumidor);
    tx.commit();
    assertTrue("deveria estar no contexto de persistencia depois de persistir", em.contains(consumidor));
    assertEquals(new Integer(0), consumidor.getIdade());

    // Encontro o ojeto
    consumidor = em.find(ConsumidorValidadoComOuvinte.class, consumidor.getId());
    assertTrue("deveria estar no contexto de persistencia depois de encontrar", em.contains(consumidor));
    assertEquals(new Integer(0), consumidor.getIdade());

    // Removo a entidade
    tx.begin();
    em.remove(consumidor);
    tx.commit();
    assertFalse("não deveria estar no contexto de persistencia após a remoção", em.contains(consumidor));
  }

  @Test(expected = IllegalArgumentException.class)
  public void deveriaLancarExcecaoParaPrimeiroNomeNulo() throws Exception {

      
    // Instancio o objeto
    ConsumidorValidadoComOuvinte consumidor = new ConsumidorValidadoComOuvinte(null, "Penha", "cm.java.frameworks@gmail.com", "1234565", new Date(), new Date());

    // Persisto o objeto
    tx.begin();
    em.persist(consumidor);
    tx.commit();
  }

  @Test(expected = IllegalArgumentException.class)
  public void deveriaLancarExcecaoParaUltimoNomeNulo() throws Exception {

    // Instancio o objeto
    ConsumidorValidadoComOuvinte consumidor = new ConsumidorValidadoComOuvinte("Bruno", null, "cm.java.frameworks@gmail.com", "1234565", new Date(), new Date());

    //Persisto o objeto
    tx.begin();
    em.persist(consumidor);
    tx.commit();
  }
}