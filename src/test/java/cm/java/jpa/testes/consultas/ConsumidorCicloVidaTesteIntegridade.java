package cm.java.jpa.testes.consultas;

import cm.java.jpa.consultas.ConsumidorCicloVida;
import cm.java.jpa.testes.TestePersistenciaAbstrato;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ConsumidorCicloVidaTesteIntegridade extends TestePersistenciaAbstrato {

  // ======================================
  // =        Testes unitários            =
  // ======================================

  @Test
  public void deveriaExibirDiferentesFasesCicloVida() throws Exception {

    // Instancio um objeto
    ConsumidorCicloVida consumidor = new ConsumidorCicloVida("Bruno", "Penha", "cm.java.frameworks@gmail.com", "1234565");
    assertFalse(em.contains(consumidor));

    // Persito o Objeto
    System.out.println("\nPERSIST");
    tx.begin();
    em.persist(consumidor);
    tx.commit();
    assertTrue("deveria estar no contexto de persistencia após persistir", em.contains(consumidor));

    // Encontro o objeto
    System.out.println("\nFIND");
    em.clear();
    assertFalse("não deveria estar no contexto de persistencia após o clear", em.contains(consumidor));
    consumidor = em.find(ConsumidorCicloVida.class, consumidor.getId());
    assertTrue("deveria estar no contexto de persistencia apos buscar", em.contains(consumidor));

    // Isolo o objeto
    System.out.println("\nDETACH");
    em.detach(consumidor);
    assertFalse("não deveria estar no contexto de persistencia após o isolamento", em.contains(consumidor));
    consumidor = em.find(ConsumidorCicloVida.class, consumidor.getId());
    assertTrue("deveria estar no contexto de persistencia após encontrar", em.contains(consumidor));

    // Atualizo o objeto
    System.out.println("\nREFRESH");
    consumidor.setEmail("novaconta@empresa.com"); // Sem atualização, apenas o PosCarregamento é chamado
    tx.begin();
    em.refresh(consumidor);
    tx.commit();
    assertTrue("deveria estar no contexto de persistencia após atualizar", em.contains(consumidor));

    System.out.println("\nINSIRO NOVOS DADOS");
    tx.begin();
    consumidor.setPrimeiroNome("novo primeiro nome");
    consumidor.setUltimoNome("novo ultimo nome");
    tx.commit();

    // Mesclo o objeto
    System.out.println("\nMERGE");
    em.clear();
    assertFalse("não deveria estar no contexto de persistencia após o clear", em.contains(consumidor));
    consumidor.setEmail("novaconta@empresa.com"); // Sem atualização, apenas o PosCarregamento é chamado
    tx.begin();
    consumidor = em.merge(consumidor);
    tx.commit();
    assertTrue("deveria estar no contexto de persistência após mesclar", em.contains(consumidor));

    // Removo a entidade
    System.out.println("\nREMOVE");
    tx.begin();
    em.remove(consumidor);
    tx.commit();
    assertFalse("não deveria estar no contexto de persistencia após a remoção ", em.contains(consumidor));
  }
}