package cm.java.jpa.testes.consultas;

import cm.java.jpa.consultas.ConsumidorConsultas;
import cm.java.jpa.consultas.EnderecoConsultas;
import cm.java.jpa.consultas.two.ConsumidorConsultas_;
import cm.java.jpa.consultas.two.EnderecoConsultas_;
import cm.java.jpa.testes.TestePersistenciaAbstrato;
import javax.persistence.TypedQuery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import static org.junit.Assert.assertEquals;

public class APICriteriaTesteIntegridade extends TestePersistenciaAbstrato {

  // ======================================
  // =              Constantes            =
  // ======================================
  private static final int TODOS = 6;
  
  // ======================================
  // =              Atributos             =
  // ======================================
  private ConsumidorConsultas consumidor01;
  private ConsumidorConsultas consumidor02;
  private ConsumidorConsultas consumidor03;
  private ConsumidorConsultas consumidor04;
  private ConsumidorConsultas consumidor05;
  private ConsumidorConsultas consumidor06;

  // ======================================
  // =     Metodos do Ciclo de Vida       =
  // ======================================

  @Before
  public void persistirConsumidores() {
    tx = em.getTransaction();

    consumidor01 = new ConsumidorConsultas("Bruno", "Penha", "cm.java.frameworks@gmail.com", 33);
    EnderecoConsultas endereco01 = new EnderecoConsultas("Rua Dois", "Rio de Janeiro", "20770111", "BR");
    consumidor01.setEndereco(endereco01);

    consumidor02 = new ConsumidorConsultas("Joao", "Silva", "js@empresa.com", 45);
    EnderecoConsultas endereco02 = new EnderecoConsultas("Ritherdon Rd", "Londres", "8QE", "RU");
    consumidor02.setEndereco(endereco02);

    consumidor03 = new ConsumidorConsultas("Sebastião", "Filho", "sebf@yamail.com", 58);
    EnderecoConsultas endereco03 = new EnderecoConsultas("Inacio Alfama", "Lisboa", "A54", "PT");
    consumidor03.setEndereco(endereco03);

    consumidor04 = new ConsumidorConsultas("Frederico", "Alvin", "fred@carnail.com", 41);
    EnderecoConsultas endereco04 = new EnderecoConsultas("Morumbi", "Sao Paulo", "345678", "BR");
    consumidor04.setEndereco(endereco04);

    consumidor05 = new ConsumidorConsultas("Bruno", "Penha", "cm.java.web@gmail.com",33);
    EnderecoConsultas endereco05 = new EnderecoConsultas("Coffey", "Perth", "654F543", "AU");
    consumidor05.setEndereco(endereco05);

    consumidor06 = new ConsumidorConsultas("Davi", "Net", "dnet@yahoo.com", 89);
    EnderecoConsultas endereco06 = new EnderecoConsultas("Harbour Bridge", "Sydney", "JHG3", "AU");
    consumidor06.setEndereco(endereco06);

    // Persisto o objeto
    tx.begin();
    em.persist(consumidor01);
    em.persist(consumidor02);
    em.persist(consumidor03);
    em.persist(consumidor04);
    em.persist(consumidor05);
    em.persist(consumidor06);
    tx.commit();
  }

  @After
  public void removerConsumidores() {

    // Removo os objetos
    tx.begin();
    em.remove(consumidor01);
    em.remove(consumidor02);
    em.remove(consumidor03);
    em.remove(consumidor04);
    em.remove(consumidor05);
    em.remove(consumidor06);
    tx.commit();
  }

  // ======================================
  // =           Testes Unitários         =
  // ======================================

  @Test
  public void deveriaEncontrarConsumidorBruno() throws Exception {

    // select c from Consumidor c where c.primeiroNome = 'Bruno'
    CriteriaBuilder montador = em.getCriteriaBuilder();
    CriteriaQuery<ConsumidorConsultas> consultaCriteria = montador.createQuery(ConsumidorConsultas.class);
    Root<ConsumidorConsultas> c = consultaCriteria.from(ConsumidorConsultas.class);
    consultaCriteria.select(c).where(montador.equal(c.get("primeiroNome"), "Bruno"));
    assertEquals(2, em.createQuery(consultaCriteria).getResultList().size());
  }

  @Test(expected = IllegalArgumentException.class)
  public void deveriaFalharPrimeiroNomeEscritoIncorreto() throws Exception {

    // select c from Consumidor c where c.primeiroNome = 'Bruno'
    CriteriaBuilder montador = em.getCriteriaBuilder();
    CriteriaQuery<ConsumidorConsultas> consulta = montador.createQuery(ConsumidorConsultas.class);
    Root<ConsumidorConsultas> c = consulta.from(ConsumidorConsultas.class);
    consulta.select(c).where(montador.equal(c.get("primeironome"), "Bruno"));
    assertEquals(2, em.createQuery(consulta).getResultList().size());
  }

  @Test
  public void deveriaEncontrarConsumidorBrunoComMetaModelo() throws Exception {

    // select c from Consumidor c where c.primeiroNome = 'Bruno'
    CriteriaBuilder montador = em.getCriteriaBuilder();
    CriteriaQuery<ConsumidorConsultas> consulta = montador.createQuery(ConsumidorConsultas.class);
    Root<ConsumidorConsultas> c = consulta.from(ConsumidorConsultas.class);
    consulta.select(c).where(montador.equal(c.get(ConsumidorConsultas_.primeiroNome), "Bruno"));
    assertEquals(2, em.createQuery(consulta).getResultList().size());
  }

  @Test
  public void deveriaEncontrarConsumidorBrunoComMetaModeloETipoDaEntidade() throws Exception {

    // select c from Consumidor c where c.primeiroNome= 'Bruno'
    CriteriaBuilder montador = em.getCriteriaBuilder();
    CriteriaQuery<ConsumidorConsultas> consulta = montador.createQuery(ConsumidorConsultas.class);
    Root<ConsumidorConsultas> c = consulta.from(ConsumidorConsultas.class);
    EntityType<ConsumidorConsultas> c_ = c.getModel();
    consulta.select(c).where(montador.equal(c.get(c_.getSingularAttribute("primeiroNome")), "Bruno"));
    assertEquals(2, em.createQuery(consulta).getResultList().size());
  }

  @Test
  public void deveriaEncontrarConsumidoresMaioresQue40() throws Exception {
    // select c from Consumidor c where c.idade > 40
    CriteriaBuilder montador = em.getCriteriaBuilder();
    CriteriaQuery<ConsumidorConsultas> consulta = montador.createQuery(ConsumidorConsultas.class);
    Root<ConsumidorConsultas> c = consulta.from(ConsumidorConsultas.class);
    consulta.select(c).where(montador.greaterThan(c.get("idade").as(Integer.class), 40));
    assertEquals(4, em.createQuery(consulta).getResultList().size());
  }

  @Test
  public void deveriaEncontrarConsumidoresMaioresQue40ComMetaModelo() throws Exception {
    // select c from Consumidor c where c.idade > 40
    CriteriaBuilder montador = em.getCriteriaBuilder();
    CriteriaQuery<ConsumidorConsultas> consulta = montador.createQuery(ConsumidorConsultas.class);
    Root<ConsumidorConsultas> c = consulta.from(ConsumidorConsultas.class);
    consulta.select(c).where(montador.greaterThan(c.get(ConsumidorConsultas_.idade), 40));
    assertEquals(4, em.createQuery(consulta).getResultList().size());
  }

  @Test
  public void deveriaEncontrarTodosComConsultaDinamica() throws Exception {

    // Montador de um Criteria 
    CriteriaBuilder montadorCriteria = em.getCriteriaBuilder();
    CriteriaQuery<ConsumidorConsultas> consultaCriteria;
    TypedQuery<ConsumidorConsultas> consulta;
    Root<ConsumidorConsultas> consumidor;

    // select c from Consumidor c
    consultaCriteria = montadorCriteria.createQuery(ConsumidorConsultas.class);
    consultaCriteria.from(ConsumidorConsultas.class);
    assertEquals(TODOS, em.createQuery(consultaCriteria).getResultList().size());

    // select c from Consumidor c (setMaxResults(3))
    consulta = em.createQuery(consultaCriteria);
    consulta.setMaxResults(3);
    assertEquals(3, consulta.getResultList().size());

    // select c from Consumidor c where c.primeiroNome = 'Bruno'
    consultaCriteria = montadorCriteria.createQuery(ConsumidorConsultas.class);
    consumidor = consultaCriteria.from(ConsumidorConsultas.class);
    consultaCriteria.select(consumidor).where(montadorCriteria.equal(consumidor.get("primeiroNome"), "Bruno"));
    assertEquals(2, em.createQuery(consultaCriteria).getResultList().size());

    // select c from Consumidor c where c.primeiroNome = 'Bruno' (usando meta-modelo)
    String pNome = "Bruno";
    consultaCriteria = montadorCriteria.createQuery(ConsumidorConsultas.class);
    consumidor = consultaCriteria.from(ConsumidorConsultas.class);
    consultaCriteria.select(consumidor).where(montadorCriteria.equal(consumidor.get(ConsumidorConsultas_.primeiroNome), pNome));
    assertEquals(2, em.createQuery(consultaCriteria).getResultList().size());

    // select c from Consumidor c where c.primeiroNome = 'Bruno' (usando meta-modelo & parametros)
    consultaCriteria = montadorCriteria.createQuery(ConsumidorConsultas.class);
    consumidor = consultaCriteria.from(ConsumidorConsultas.class);
    consultaCriteria.select(consumidor).where(montadorCriteria.equal(consumidor.get(ConsumidorConsultas_.primeiroNome), "Bruno"));
    assertEquals(2, em.createQuery(consultaCriteria).getResultList().size());

    // select c from Consumidor c where c.primeiroNome = 'Bruno' (usando um predicado)
    consultaCriteria = montadorCriteria.createQuery(ConsumidorConsultas.class);
    consumidor = consultaCriteria.from(ConsumidorConsultas.class);
    Predicate predicado = montadorCriteria.equal(consumidor.get("primeiroNome"), "Bruno");
    consultaCriteria.select(consumidor).where(predicado);
    assertEquals(2, em.createQuery(consultaCriteria).getResultList().size());

    // select c from Consumidor c where c.endereco.pais = 'AU'
    consultaCriteria = montadorCriteria.createQuery(ConsumidorConsultas.class);
    consumidor = consultaCriteria.from(ConsumidorConsultas.class);
    consultaCriteria.select(consumidor).where(montadorCriteria.equal(consumidor.get("endereco").get("pais"), "AU"));
    assertEquals(2, em.createQuery(consultaCriteria).getResultList().size());

    // select c from Consumidor c where c.endereco.pais = 'AU' (usando meta-modelo)
    consultaCriteria = montadorCriteria.createQuery(ConsumidorConsultas.class);
    consumidor = consultaCriteria.from(ConsumidorConsultas.class);
    consultaCriteria.select(consumidor).where(montadorCriteria.equal(consumidor.get(ConsumidorConsultas_.endereco).get(EnderecoConsultas_.pais), "AU"));
    assertEquals(2, em.createQuery(consultaCriteria).getResultList().size());

    // select c from Consumidor c where c.idade > 40
    consultaCriteria = montadorCriteria.createQuery(ConsumidorConsultas.class);
    consumidor = consultaCriteria.from(ConsumidorConsultas.class);
    consultaCriteria.select(consumidor).where(montadorCriteria.greaterThan(consumidor.get("idade").as(Integer.class), 40));
    assertEquals(4, em.createQuery(consultaCriteria).getResultList().size());

    // select c from Consumidor c where c.idade > 40 (usando meta-modelo)
    consultaCriteria = montadorCriteria.createQuery(ConsumidorConsultas.class);
    consumidor = consultaCriteria.from(ConsumidorConsultas.class);
    consultaCriteria.select(consumidor).where(montadorCriteria.greaterThan(consumidor.get(ConsumidorConsultas_.idade), 40));
    assertEquals(4, em.createQuery(consultaCriteria).getResultList().size());

    // select c from Consumidor c where c.idade between 40 and 50
    consultaCriteria = montadorCriteria.createQuery(ConsumidorConsultas.class);
    consumidor = consultaCriteria.from(ConsumidorConsultas.class);
    consultaCriteria.select(consumidor).where(montadorCriteria.between(consumidor.get("idade").as(Integer.class), 40, 50));
    assertEquals(2, em.createQuery(consultaCriteria).getResultList().size());

    // select c from Consumidor c where c.idade between 40 and 50 (usando meta-modelo)
    consultaCriteria = montadorCriteria.createQuery(ConsumidorConsultas.class);
    consumidor = consultaCriteria.from(ConsumidorConsultas.class);
    consultaCriteria.select(consumidor).where(montadorCriteria.between(consumidor.get(ConsumidorConsultas_.idade), 40, 50));
    assertEquals(2, em.createQuery(consultaCriteria).getResultList().size());
  }
}