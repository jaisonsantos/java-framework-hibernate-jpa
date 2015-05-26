package cm.java.jpa.testes.consultas;

import cm.java.jpa.consultas.ConsumidorManip;
import cm.java.jpa.consultas.EnderecoManip;
import cm.java.jpa.testes.TestePersistenciaAbstrato;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ConsumidorManipTesteIntegridade extends TestePersistenciaAbstrato {

  // ======================================
  // =           Testes unitários         =
  // ======================================

  @Test 
  public void deveriaPersistirUmConsumidorComUmEndereco() throws Exception {

    ConsumidorManip consumidor = new ConsumidorManip("Jose", "Silva", "jsilva@empresa.com");
    EnderecoManip endereco = new EnderecoManip("Rua Dois", "Rio de Janeiro", "23300111", "BR");
    consumidor.setEndereco(endereco);

    // Persisto o objeto
    tx.begin();
    em.persist(consumidor);
    em.persist(endereco);
    tx.commit();

    assertNotNull(consumidor.getId());
    assertNotNull(endereco.getId());
  }

  @Test // 
  public void deveriaEncontrarUmConsumidor() throws Exception {

    ConsumidorManip consumidor = new ConsumidorManip("Jose", "Silva", "jsilva@empresa.com");
    EnderecoManip endereco = new EnderecoManip("Rua Dois", "Rio de Janeiro", "23300111", "BR");
    consumidor.setEndereco(endereco);

    // Persisto o objeto
    tx.begin();
    em.persist(consumidor);
    em.persist(endereco);
    tx.commit();

    assertNotNull(consumidor.getId());
    assertNotNull(endereco.getId());

    // Chamo o metodo clear
    em.clear();

    consumidor = em.find(ConsumidorManip.class, consumidor.getId());
    assertNotNull(consumidor);
  }

  @Test // 
  public void deveriaPegarUmaReferenciaDoConsumidor() throws Exception {

    ConsumidorManip consumidor = new ConsumidorManip("Jose", "Silva", "jsilva@empresa.com");
    EnderecoManip endereco = new EnderecoManip("Rua Dois", "Rio de Janeiro", "23300111", "BR");
    consumidor.setEndereco(endereco);

    // Persisto o objeto
    tx.begin();
    em.persist(consumidor);
    em.persist(endereco);
    tx.commit();

    assertNotNull(consumidor.getId());
    assertNotNull(endereco.getId());

    // Chamo o metodo Clear
    em.clear();

    consumidor = em.getReference(ConsumidorManip.class, consumidor.getId());
    assertNotNull(consumidor);
  }

  @Test // 
  public void deveriaRemoverUmConsumidor() throws Exception {

    ConsumidorManip consumidor = new ConsumidorManip("Jose", "Silva", "jsilva@empresa.com");
    EnderecoManip endereco = new EnderecoManip("Rua Dois", "Rio de Janeiro", "23300111", "BR");
    consumidor.setEndereco(endereco);

    // Persisto o objeto
    tx.begin();
    em.persist(consumidor);
    em.persist(endereco);
    tx.commit();

    assertNotNull(consumidor.getId());
    assertNotNull(endereco.getId());

    // Removo o objeto
    tx.begin();
    em.remove(consumidor);
    em.remove(endereco);
    tx.commit();

    assertEquals(consumidor.getPrimeiroNome(), "Jose");
    assertEquals(endereco.getCidade(), "Rio de Janeiro");

    consumidor = em.find(ConsumidorManip.class, consumidor.getId());
    assertNull(consumidor);
    endereco = em.find(EnderecoManip.class, endereco.getId());
    assertNull(endereco);
  }

  @Test // 
  public void deveriaPersistirUmConsumidorEAtualizarEle() throws Exception {

    ConsumidorManip consumidor = new ConsumidorManip("Jose", "Silva", "jsilva@empresa.com");
    EnderecoManip endereco = new EnderecoManip("Rua Dois", "Rio de Janeiro", "23300111", "BR");
    consumidor.setEndereco(endereco);

    // Persisto o objeto
    tx.begin();
    em.persist(consumidor);
    em.persist(endereco);
    tx.commit();

    assertNotNull(consumidor.getId());
    assertNotNull(endereco.getId());

    consumidor = em.find(ConsumidorManip.class, consumidor.getId());
    assertNotNull(consumidor);
    assertEquals(consumidor.getPrimeiroNome(),"Jose");

    consumidor.setPrimeiroNome("Novo primeiro nome");
    assertEquals(consumidor.getPrimeiroNome(), "Novo primeiro nome");

    em.refresh(consumidor);
    assertEquals(consumidor.getPrimeiroNome(), "Jose");
  }

  @Test // 
  public void deveriaVerificarSeIssoContemUmConsumidor() throws Exception {

    ConsumidorManip consumidor = new ConsumidorManip("Jose", "Silva", "jsilva@empresa.com");
 
    // Persisto o objeto
    tx.begin();
    em.persist(consumidor);
    tx.commit();

    assertTrue(em.contains(consumidor));

    // Removo o objeto
    tx.begin();
    em.remove(consumidor);
    tx.commit();

    assertFalse(em.contains(consumidor));
  }

  @Test // 
  public void deveriaIsolarUmConsumidor() throws Exception {

    ConsumidorManip consumidor = new ConsumidorManip("Jose", "Silva", "jsilva@empresa.com");
    
    // Persisto o objeto
    tx.begin();
    em.persist(consumidor);
    tx.commit();

    assertTrue(em.contains(consumidor));

    // isolo o object
    em.detach(consumidor);

    assertFalse(em.contains(consumidor));
  }

  @Test // 
  public void deveriaLimparEDepoisMesclarUmConsumidor() throws Exception {

    ConsumidorManip consumidor = new ConsumidorManip("Jose", "Silva", "jsilva@empresa.com");
    EnderecoManip endereco = new EnderecoManip("Rua Dois", "Rio de Janeiro", "23300111", "BR");
    consumidor.setEndereco(endereco);

    // Persisto o objeto
    tx.begin();
    em.persist(consumidor);
    em.persist(endereco);
    tx.commit();

    assertTrue(em.contains(consumidor));

    em.clear();
    assertFalse(em.contains(consumidor));

    consumidor.setPrimeiroNome("Bruno");
    tx.begin();
    em.merge(consumidor);
    tx.commit();

    em.clear();
    assertFalse(em.contains(consumidor));

    consumidor = em.find(ConsumidorManip.class, consumidor.getId());
    assertEquals(consumidor.getPrimeiroNome(), "Bruno");
    assertTrue(em.contains(consumidor));

  }

  @Test // 
  public void deveriaAtualizarUmConsumidor() throws Exception {

    ConsumidorManip consumidor = new ConsumidorManip("Jose", "Silva", "jsilva@empresa.com");
    
    // Persisto o objeto
    tx.begin();
    em.persist(consumidor);

    assertNotNull(consumidor.getId());
    assertEquals(consumidor.getPrimeiroNome(), "Jose");

    consumidor.setPrimeiroNome("Bruno");
    assertEquals(consumidor.getPrimeiroNome(), "Bruno");

    tx.commit();
  }

  @Test // 
  public void deveriaPersistirUmConsumidorEUmEndereco() throws Exception {

    ConsumidorManip consumidor = new ConsumidorManip("Jose", "Silva", "jsilva@empresa.com");
    EnderecoManip endereco = new EnderecoManip("Rua Dois", "Rio de Janeiro", "23300111", "BR");
    consumidor.setEndereco(endereco);

    // Persisto o objeto
    tx.begin();
    em.persist(consumidor);
    em.persist(endereco);
    tx.commit();

    assertNotNull(consumidor.getId());
    assertNotNull(endereco.getId());
  }

  @Test // 
  public void deveriaPersistirUmConsumidorECascatarNoEndereco() throws Exception {

    ConsumidorManip consumidor = new ConsumidorManip("Jose", "Silva", "jsilva@empresa.com");
    EnderecoManip endereco = new EnderecoManip("Rua Dois", "Rio de Janeiro", "23300111", "BR");
    consumidor.setEndereco(endereco);

    // Persisto o objeto
    tx.begin();
    em.persist(consumidor);
    tx.commit();

    assertNotNull(consumidor.getId());
    assertNotNull(endereco.getId());
  }

  @Test
  public void deveriaAtualizarUmConsumidorEDepoisLimpalo() throws Exception {

    ConsumidorManip consumidor = new ConsumidorManip("Jose", "Silva", "jsilva@empresa.com");

    // Persisto o objeto
    tx.begin();
    em.persist(consumidor);
    tx.commit();

    assertTrue(em.contains(consumidor));

    em.clear();
    assertFalse(em.contains(consumidor));

    consumidor = em.find(ConsumidorManip.class, consumidor.getId());
    assertEquals(consumidor.getPrimeiroNome(), "Jose");
    assertTrue(em.contains(consumidor));

  }

  @Test
  public void deveriaLimparTudoEDepoisMesclarUmConsumidor() throws Exception {

    ConsumidorManip consumidor = new ConsumidorManip("Jose", "Silva", "jsilva@empresa.com");

    // Persisto o objeto
    tx.begin();
    em.persist(consumidor);
    tx.commit();

    assertTrue(em.contains(consumidor));

    em.clear();
    assertFalse(em.contains(consumidor));

    tx.begin();
    consumidor = em.merge(consumidor);
    consumidor.setPrimeiroNome("Bruno");
    tx.commit();

    em.clear();
    assertFalse(em.contains(consumidor));

    consumidor = em.find(ConsumidorManip.class, consumidor.getId());
    assertEquals(consumidor.getPrimeiroNome(), "Bruno");
    assertTrue(em.contains(consumidor));

  }

  @Test
  public void deveriaPersistirUmConsumidor() throws Exception {

    ConsumidorManip consumidor = new ConsumidorManip("Jose", "Silva", "jsilva@empresa.com");

    // Persisto o objeto
    tx.begin();
    em.persist(consumidor);
    tx.commit();


    assertNotNull(consumidor.getId());
  }

  @Test
  public void deveriaPersistirUmEndereco() throws Exception {

    EnderecoManip endereco = new EnderecoManip("Rua Dois", "Rio de Janeiro", "23300111", "BR");
  
    // Persisto o objeto
    tx.begin();
    em.persist(endereco);
    tx.commit();


    assertNotNull(endereco.getId());
  }
}