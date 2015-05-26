package cm.java.jpa.testes.entidades;

import cm.java.jpa.entidades.Consumidor;
import cm.java.jpa.testes.TestePersistenciaAbstrato;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertNotNull;


public class ConsumidorTesteIntegridade extends TestePersistenciaAbstrato {

  // ======================================
  // =           Teste Unitários          =
  // ======================================
  @Test
  public void deveriaCriarUmConsumidor() throws Exception {

    Consumidor consumidor = new Consumidor("Joao", "da Silva", "joao@empresa.com", "1234565", new Date(), new Date());
    tx.begin();
    em.persist(consumidor);
    tx.commit();
    assertNotNull("O ID não deveria ser nulo", consumidor.getId());
  }
}