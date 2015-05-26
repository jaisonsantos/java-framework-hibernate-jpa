package cm.java.jpa.testes.consultas;


import cm.java.jpa.consultas.ConsumidorValidado;
import cm.java.jpa.testes.TestePersistenciaAbstrato;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class ConsumidorValidadoTesteIntegridade extends TestePersistenciaAbstrato {

  // ======================================
  // =        Testes unitários            =
  // ======================================

  @Test
  public void idadeDeveriaSerMaiorQueZero() {
    ConsumidorValidado consumidor = new ConsumidorValidado("Maria", "Joana", "mjoana@empresa.com", "+351 123 4565");
    consumidor.setDataNascimento(new GregorianCalendar(1975, 5, 27).getTime());

    consumidor.calculaIdade();

    int idadeCalculada = consumidor.getIdade();

    assertTrue(idadeCalculada >= 0);
  }

  @Test
  public void idadeDeveriaSer33() {
    int idadeEsperada = 33;

    Calendar nascimento = new GregorianCalendar();
    nascimento.roll(Calendar.YEAR, idadeEsperada * (-1));
    nascimento.roll(Calendar.DAY_OF_YEAR, -1);

    ConsumidorValidado consumidor = new ConsumidorValidado("Maria", "Joana", "mjoana@empresa.com", "+351 123 4565");
    consumidor.setDataNascimento(nascimento.getTime());

    consumidor.calculaIdade();

    assertEquals(new Long(idadeEsperada), new Long(consumidor.getIdade()));
  }

  @Test
  public void deveriaVerificarIdadeNulaParaDataNascimentoNula() {
    ConsumidorValidado customer = new ConsumidorValidado();
    customer.calculaIdade();
    assertNull(customer.getIdade());
  }


  @Test
  public void deveriaVerificarIdadeConsumidor() throws Exception {

    // Instancio um objeto
    ConsumidorValidado consumidor = new ConsumidorValidado("Bruno", "Penha", "cm.java.frameworks@gmail.com", "1234565", new Date(), new Date());
    assertFalse(em.contains(consumidor));

    // Persisto o objeto
    tx.begin();
    em.persist(consumidor);
    tx.commit();
    assertTrue("deveria estar no contexto de persistencia após a inserção do dado", em.contains(consumidor));
    assertEquals(new Integer(0), consumidor.getIdade());

    // Encontro o objeto
    consumidor = em.find(ConsumidorValidado.class, consumidor.getId());
    assertTrue("deveria estar no contexto de persitencia após encontrar o objeto", em.contains(consumidor));
    assertEquals(new Integer(0), consumidor.getIdade());
    
    // removo a entidade
    tx.begin();
    em.remove(consumidor);
    tx.commit();
    assertFalse("não deveria estar no contexto de persistencia após a remoção do registro no banco", em.contains(consumidor));
  }

  @Test(expected = IllegalArgumentException.class)
  public void deveriaLancarExcecaoParaPrimeiroNomeNulo() throws Exception {

      
    // Instancio o objeto
    ConsumidorValidado consumidor = new ConsumidorValidado(null, "Penha", "cm.java.frameworks@gmail.com", "1234565", new Date(), new Date());

    // Persisto o objeto
    tx.begin();
    em.persist(consumidor);
    tx.commit();
  }

  @Test(expected = IllegalArgumentException.class)
  public void deveriaLancarExcecaoParaUltimoNomeNulo() throws Exception {

    // Instancio o objeto
    ConsumidorValidado consumidor = new ConsumidorValidado("Bruno", null, "cm.java.frameworks@gmail.com", "1234565", new Date(), new Date());

    //Persisto o objeto
    tx.begin();
    em.persist(consumidor);
    tx.commit();
  }
}
