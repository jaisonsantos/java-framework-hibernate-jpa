package cm.java.jpa.testes.consultas;

import cm.java.jpa.consultas.ConsumidorConsultas;
import cm.java.jpa.consultas.EnderecoConsultas;
import cm.java.jpa.consultas.LivroConsultas;
import cm.java.jpa.testes.TestePersistenciaAbstrato;
import org.junit.Test;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ConsultasTesteIntegridade extends TestePersistenciaAbstrato {

  // ======================================
  // =              Constantes             =
  // ======================================

  private static final int TODOS = 6;

  // ======================================
  // =           Testes Unitários         =
  // ======================================

  @Test
  public void deveriaEncontrarTodosComConsultaDinâmica() throws Exception {

    ConsumidorConsultas consumidor01 = new ConsumidorConsultas("Bruno", "Silva", "bsilva@empresa.com", 14);
    EnderecoConsultas endereco01 = new EnderecoConsultas("Rua Dois", "Rio de Janeiro", "200099111", "BR");
    consumidor01.setEndereco(endereco01);

    ConsumidorConsultas consumidor02 = new ConsumidorConsultas("Bruno", "Penha", "cm.java.frameworks@gmail.com", 45);
    EnderecoConsultas endereco02 = new EnderecoConsultas("Rua Três", "Niteroi", "23222555", "BR");
    consumidor02.setEndereco(endereco02);

    ConsumidorConsultas consumidor03 = new ConsumidorConsultas("Silva", "Joenio", "sjoenio@empresa.com", 58);
    EnderecoConsultas endereco03 = new EnderecoConsultas("Inacio Alfama", "São Paulo", "11222333", "BR");
    consumidor03.setEndereco(endereco03);

    ConsumidorConsultas consumidor04 = new ConsumidorConsultas("Silvara", "Riou", "sriou@empresa.com", 41);
    EnderecoConsultas endereco04 = new EnderecoConsultas("Jardins", "Sao Paulo", "345678", "BR");
    consumidor04.setEndereco(endereco04);

    ConsumidorConsultas consumidor05 = new ConsumidorConsultas("Mario", "Ribeiro", "mario@empresa.com", 14);
    EnderecoConsultas endereco05 = new EnderecoConsultas("Coffey", "Perth", "654F543", "AU");
    consumidor05.setEndereco(endereco05);

    ConsumidorConsultas consumidor06 = new ConsumidorConsultas("David", "Chene", "dch@empresa.com", 89);
    EnderecoConsultas endereco06 = new EnderecoConsultas("Harbour Bridge", "Sydney", "JHG3", "AU");
    consumidor06.setEndereco(endereco06);

    // Persisto os objetos
    tx.begin();
    em.persist(consumidor01);
    em.persist(consumidor02);
    em.persist(consumidor03);
    em.persist(consumidor04);
    em.persist(consumidor05);
    em.persist(consumidor06);
    tx.commit();

    // Consulas
    Query consulta = em.createQuery("select c from ConsumidorConsultas c");
    List<ConsumidorConsultas> consumidores = consulta.getResultList();
    assertEquals(TODOS, consumidores.size());

    consulta = em.createQuery("select c from ConsumidorConsultas c");
    consulta.setMaxResults(3);
    assertEquals(3, consulta.getResultList().size());

    boolean algumCriterio = true;
    String consultaJpql = "select c from ConsumidorConsultas c";
    if (algumCriterio)
      consultaJpql += " where c.primeiroNome = 'Bruno'";
    consulta = em.createQuery(consultaJpql);
    assertEquals(2, consulta.getResultList().size());

    consultaJpql = "select c from ConsumidorConsultas c";
    if (algumCriterio)
      consultaJpql += " where c.primeiroNome = :pnome";
    consulta = em.createQuery(consultaJpql);
    consulta.setParameter("pnome", "Bruno");
    assertEquals(2, consulta.getResultList().size());

    consultaJpql = "select c from ConsumidorConsultas c";
    if (algumCriterio)
      consultaJpql += " where c.primeiroNome = ?1";
    consulta = em.createQuery(consultaJpql);
    consulta.setParameter(1, "Bruno");
    assertEquals(2, consulta.getResultList().size());

    consulta = em.createQuery("select c from ConsumidorConsultas c  where c.primeiroNome = :pnome");
    consulta.setParameter("pnome", "Bruno");
    consulta.setMaxResults(1);
    assertEquals(1, consulta.getResultList().size());

    consulta = em.createQuery("select c from ConsumidorConsultas c  where c.primeiroNome = :pnome").setParameter("pnome", "Bruno").setMaxResults(1);
    assertEquals(1, consulta.getResultList().size());

    // Consulta Tipada - TypedQuery
    TypedQuery<ConsumidorConsultas> consultaTipada = em.createQuery("select c from ConsumidorConsultas c", ConsumidorConsultas.class);
    consumidores = consultaTipada.getResultList();
    assertEquals(TODOS, consumidores.size());

    consultaTipada = em.createQuery("select c from ConsumidorConsultas c", ConsumidorConsultas.class);
    consultaTipada.setMaxResults(3);
    assertEquals(3, consultaTipada.getResultList().size());

    consultaJpql = "select c from ConsumidorConsultas c";
    if (algumCriterio)
      consultaJpql += " where c.primeiroNome = 'Bruno'";
    consultaTipada = em.createQuery(consultaJpql, ConsumidorConsultas.class);
    assertEquals(2, consultaTipada.getResultList().size());

    consultaJpql = "select c from ConsumidorConsultas c";
    if (algumCriterio)
      consultaJpql += " where c.primeiroNome = :pnome";
    consultaTipada = em.createQuery(consultaJpql, ConsumidorConsultas.class);
    consultaTipada.setParameter("pnome", "Bruno");
    assertEquals(2, consultaTipada.getResultList().size());

    consultaJpql = "select c from ConsumidorConsultas c";
    if (algumCriterio)
      consultaJpql += " where c.primeiroNome = ?1";
    consultaTipada = em.createQuery(consultaJpql, ConsumidorConsultas.class);
    consultaTipada.setParameter(1, "Bruno");
    assertEquals(2, consultaTipada.getResultList().size());

    consultaTipada = em.createQuery("select c from ConsumidorConsultas c  where c.primeiroNome = :pnome", ConsumidorConsultas.class);
    consultaTipada.setParameter("pnome", "Bruno");
    consultaTipada.setMaxResults(1);
    assertEquals(1, consultaTipada.getResultList().size());

    consultaTipada = em.createQuery("select c from ConsumidorConsultas c  where c.primeiroNome = :pnome", ConsumidorConsultas.class).setParameter("pnome", "Bruno").setMaxResults(1);
    assertEquals(1, consultaTipada.getResultList().size());

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

  @Test
  public void deveriaEncontrarTodosComUmaConsultaNomeada() throws Exception {

    ConsumidorConsultas consumidor01 = new ConsumidorConsultas("Bruno", "Silva", "bsilva@empresa.com", 14);
    EnderecoConsultas endereco01 = new EnderecoConsultas("Rua Dois", "Rio de Janeiro", "200099111", "BR");
    consumidor01.setEndereco(endereco01);

    ConsumidorConsultas consumidor02 = new ConsumidorConsultas("Bruno", "Penha", "cm.java.frameworks@gmail.com", 45);
    EnderecoConsultas endereco02 = new EnderecoConsultas("Rua Três", "Niteroi", "23222555", "BR");
    consumidor02.setEndereco(endereco02);

    ConsumidorConsultas consumidor03 = new ConsumidorConsultas("Silva", "Joenio", "sjoenio@empresa.com", 58);
    EnderecoConsultas endereco03 = new EnderecoConsultas("Inacio Alfama", "São Paulo", "11222333", "BR");
    consumidor03.setEndereco(endereco03);

    ConsumidorConsultas consumidor04 = new ConsumidorConsultas("Silvara", "Riou", "sriou@empresa.com", 41);
    EnderecoConsultas endereco04 = new EnderecoConsultas("Jardins", "Sao Paulo", "345678", "BR");
    consumidor04.setEndereco(endereco04);

    ConsumidorConsultas consumidor05 = new ConsumidorConsultas("Mario", "Ribeiro", "mario@empresa.com", 14);
    EnderecoConsultas endereco05 = new EnderecoConsultas("Coffey", "Perth", "654F543", "AU");
    consumidor05.setEndereco(endereco05);

    ConsumidorConsultas consumidor06 = new ConsumidorConsultas("David", "Chene", "dch@empresa.com", 89);
    EnderecoConsultas endereco06 = new EnderecoConsultas("Harbour Bridge", "Sydney", "JHG3", "AU");
    consumidor06.setEndereco(endereco06);

    // Persisto os objetos
    tx.begin();
    em.persist(consumidor01);
    em.persist(consumidor02);
    em.persist(consumidor03);
    em.persist(consumidor04);
    em.persist(consumidor05);
    em.persist(consumidor06);
    tx.commit();

    // Consultas
    Query consulta = em.createNamedQuery("encontreTodos");
    List<ConsumidorConsultas> consumidores = consulta.getResultList();
    assertEquals(TODOS, consumidores.size());

    consulta = em.createNamedQuery(ConsumidorConsultas.ENCONTRE_TODOS);
    assertEquals(TODOS, consulta.getResultList().size());

    consulta = em.createNamedQuery("encontreTodos");
    consulta.setMaxResults(3);
    assertEquals(3, consulta.getResultList().size());

    consulta = em.createNamedQuery("encontreBruno");
    assertEquals(2, consulta.getResultList().size());

    consulta = em.createNamedQuery("encontreComParametro");
    consulta.setParameter("pnome", "Bruno");
    assertEquals(2, consulta.getResultList().size());

    // Consulta Tipada - TypedQuery
    TypedQuery<ConsumidorConsultas> consultaTipada = em.createNamedQuery("encontreTodos", ConsumidorConsultas.class);
    consumidores = consultaTipada.getResultList();
    assertEquals(TODOS, consumidores.size());

    consultaTipada = em.createNamedQuery(ConsumidorConsultas.ENCONTRE_TODOS, ConsumidorConsultas.class);
    assertEquals(TODOS, consultaTipada.getResultList().size());

    consultaTipada = em.createNamedQuery("encontreTodos", ConsumidorConsultas.class);
    consultaTipada.setMaxResults(3);
    assertEquals(3, consultaTipada.getResultList().size());

    consultaTipada = em.createNamedQuery("encontreBruno", ConsumidorConsultas.class);
    assertEquals(2, consultaTipada.getResultList().size());

    consultaTipada = em.createNamedQuery("encontreComParametro", ConsumidorConsultas.class);
    consultaTipada.setParameter("pnome", "Bruno");
    assertEquals(2, consultaTipada.getResultList().size());

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

  @Test
  public void deveriaEncontrarTodosComConsultaNativa() throws Exception {

    ConsumidorConsultas consumidor01 = new ConsumidorConsultas("Jose", "Silva", "jsilva@empresa.com", 14);
    EnderecoConsultas endereco01 = new EnderecoConsultas("Rua Dois", "Rio de Janeiro", "200099111", "BR");
    consumidor01.setEndereco(endereco01);

    ConsumidorConsultas consumidor02 = new ConsumidorConsultas("Bruno", "Penha", "cm.java.frameworks@gmail.com", 45);
    EnderecoConsultas endereco02 = new EnderecoConsultas("Rua Três", "Niteroi", "23222555", "BR");
    consumidor02.setEndereco(endereco02);

    ConsumidorConsultas consumidor03 = new ConsumidorConsultas("Silva", "Joenio", "sjoenio@empresa.com", 58);
    EnderecoConsultas endereco03 = new EnderecoConsultas("Inacio Alfama", "São Paulo", "11222333", "BR");
    consumidor03.setEndereco(endereco03);

    ConsumidorConsultas consumidor04 = new ConsumidorConsultas("Silvara", "Riou", "sriou@empresa.com", 41);
    EnderecoConsultas endereco04 = new EnderecoConsultas("Jardins", "Sao Paulo", "345678", "BR");
    consumidor04.setEndereco(endereco04);

    ConsumidorConsultas consumidor05 = new ConsumidorConsultas("Mario", "Ribeiro", "mario@empresa.com", 14);
    EnderecoConsultas endereco05 = new EnderecoConsultas("Coffey", "Perth", "654F543", "AU");
    consumidor05.setEndereco(endereco05);

    ConsumidorConsultas consumidor06 = new ConsumidorConsultas("David", "Chene", "dch@empresa.com", 89);
    EnderecoConsultas endereco06 = new EnderecoConsultas("Harbour Bridge", "Sydney", "JHG3", "AU");
    consumidor06.setEndereco(endereco06);

    // Persisto os objetos
    tx.begin();
    em.persist(consumidor01);
    em.persist(consumidor02);
    em.persist(consumidor03);
    em.persist(consumidor04);
    em.persist(consumidor05);
    em.persist(consumidor06);
    tx.commit();

    // Consultas
    Query consulta = em.createNativeQuery("select * from t_consumidor_consulta", ConsumidorConsultas.class);
    List<ConsumidorConsultas> consumidores = consulta.getResultList();
    assertEquals(TODOS, consumidores.size());

//        consulta = em.createNativeQuery("encontreTodosNativo");
//        consumidores = consulta.getResultList();
//        assertEquals(TODOS, consumidores.size());
//
//        consulta = em.createNativeQuery("select ultimonome from T_CONSUMIDOR_CONSULTAS", String.class);
//        List<String> nomesConsumidores = consulta.getResultList();
//        assertEquals(TODOS, nomesConsumidores.size());

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

  @Test
  public void deveriaExecutarVariasConsultasDinamicas() throws Exception {

   ConsumidorConsultas consumidor01 = new ConsumidorConsultas("Bruno", "Silva", "bsilva@empresa.com", 14);
    EnderecoConsultas endereco01 = new EnderecoConsultas("Rua Dois", "Lisboa", "200099111", "PT");
    consumidor01.setEndereco(endereco01);

    ConsumidorConsultas consumidor02 = new ConsumidorConsultas("Bruno", "Penha", "cm.java.frameworks@gmail.com", 45);
    EnderecoConsultas endereco02 = new EnderecoConsultas("Rua Três", "Niteroi", "23222555", "BR");
    consumidor02.setEndereco(endereco02);

    ConsumidorConsultas consumidor03 = new ConsumidorConsultas("Silva", "Joenio", "sjoenio@empresa.com", 58);
    EnderecoConsultas endereco03 = new EnderecoConsultas("Inacio Alfama", "Paris", "11222333", "FR");
    consumidor03.setEndereco(endereco03);

    ConsumidorConsultas consumidor04 = new ConsumidorConsultas("Silvara", "Riou", "sriou@empresa.com", 41);
    EnderecoConsultas endereco04 = new EnderecoConsultas("Jardins", "Sao Paulo", "345678", "BR");
    consumidor04.setEndereco(endereco04);

    ConsumidorConsultas consumidor05 = new ConsumidorConsultas("Mario", "Ribeiro", "mario@emppresa.com", 14);
    EnderecoConsultas endereco05 = new EnderecoConsultas("Coffey", "Perth", "654F543", "AU");
    consumidor05.setEndereco(endereco05);

    ConsumidorConsultas consumidor06 = new ConsumidorConsultas("David", "Chene", "dch@empresa.com", 89);
    EnderecoConsultas endereco06 = new EnderecoConsultas("Harbour Bridge", "Sydney", "JHG3", "AU");
    consumidor06.setEndereco(endereco06);
    
    // Persisto os objetos
    tx.begin();
    em.persist(consumidor01);
    em.persist(consumidor02);
    em.persist(consumidor03);
    em.persist(consumidor04);
    em.persist(consumidor05);
    em.persist(consumidor06);
    tx.commit();

    Query consulta = em.createQuery("select c from ConsumidorConsultas c");
    assertEquals(TODOS, consulta.getResultList().size());

    consulta = em.createQuery("select c.primeiroNome from ConsumidorConsultas c");
    assertEquals(TODOS, consulta.getResultList().size());

    consulta = em.createQuery("select LOWER(c.primeiroNome) from ConsumidorConsultas c");
    assertEquals(TODOS, consulta.getResultList().size());

    consulta = em.createQuery("select c.primeiroNome, c.ultimoNome  from ConsumidorConsultas c");
    assertEquals(TODOS, consulta.getResultList().size());

    consulta = em.createQuery("select distinct c.primeiroNome from ConsumidorConsultas c");
    assertEquals(TODOS - 1, consulta.getResultList().size());

    consulta = em.createQuery("select c from ConsumidorConsultas c where c.primeiroNome = 'Bruno'");
    assertEquals(2, consulta.getResultList().size());

    consulta = em.createQuery("select c.endereco from ConsumidorConsultas c where c.primeiroNome = 'Bruno'");
    assertEquals(2, consulta.getResultList().size());

    consulta = em.createQuery("select c from ConsumidorConsultas c where c.endereco.pais = 'AU'");
    assertEquals(2, consulta.getResultList().size());

    consulta = em.createQuery("select new cm.java.jpa.consultas.ConsumidorDTO(c.primeiroNome, c.ultimoNome, c.endereco.pais) from ConsumidorConsultas c where c.primeiroNome = 'Bruno'");
    assertEquals(2, consulta.getResultList().size());

    consulta = em.createQuery("select count(c) from ConsumidorConsultas c where c.primeiroNome = 'Bruno'");
    assertEquals(2L, consulta.getSingleResult());

    consulta = em.createQuery("select c from ConsumidorConsultas c where c.idade > 40");
    assertEquals(4, consulta.getResultList().size());

    consulta = em.createQuery("select c from ConsumidorConsultas c where c.idade between 40 and 50");
    assertEquals(2, consulta.getResultList().size());

    consulta = em.createQuery("select c from ConsumidorConsultas c where c.idade not between 40 and 50");
    assertEquals(4, consulta.getResultList().size());

    consulta = em.createQuery("select c from ConsumidorConsultas c where c.endereco.pais in ('FR', 'PT')");
    assertEquals(2, consulta.getResultList().size());

    consulta = em.createQuery("select c from ConsumidorConsultas c where c.email like '%empresa.com'");
    assertEquals(4, consulta.getResultList().size());

    consulta = em.createQuery("select min(c.idade) from ConsumidorConsultas c");
    assertEquals(14, consulta.getSingleResult());

    consulta = em.createQuery("select c.endereco.pais, count(c) from ConsumidorConsultas c group by c.endereco.pais");
    assertEquals(4, consulta.getResultList().size());

    consulta = em.createQuery("select c.endereco.pais, count(c) from ConsumidorConsultas c group by c.endereco.pais having c.endereco.pais <> 'PT'");
    assertEquals(3, consulta.getResultList().size());

    consulta = em.createQuery("select c from ConsumidorConsultas c where c.idade = (select min(cons.idade) from ConsumidorConsultas cons)");
    assertEquals(2, consulta.getResultList().size());

    tx.begin();
    consulta = em.createQuery("update ConsumidorConsultas c set c.primeiroNome = 'MUITO JOVEM' where c.idade < 18");
    assertEquals(2, consulta.executeUpdate());
    tx.commit();

    tx.begin();
    consulta = em.createQuery("delete from ConsumidorConsultas c where c.idade < 18");
    assertEquals(2, consulta.executeUpdate());
    tx.commit();

    // Remove objects
    tx.begin();
    em.remove(consumidor01);
    em.remove(consumidor02);
    em.remove(consumidor03);
    em.remove(consumidor04);
    em.remove(consumidor05);
    em.remove(consumidor06);
    tx.commit();
  }

  @Test
  public void deveriaExecutarConsultasComCase() throws Exception {

    LivroConsultas livro01 = new LivroConsultas("O Guia do Mochileiro das Galaxias", 12F, "O Guia do Mochileiro das Galaxias faz parte de uma série de comédia criada por Douglas Adams.", "1-84023-742-2", 354, false, "Apress");
    LivroConsultas livro02 = new LivroConsultas("Java EE 6", 50F, "Aprenda sobre Java EE 6", "2-84023-742-2", 450, true, "Apress");
    LivroConsultas livro03 = new LivroConsultas("Narcisse e Golmund", 10F, "Um dos melhores livros Herman Hesse", "3-84023-742-2", 153, false, "Pinguin");

    // Persisto os objetos
    tx.begin();
    em.persist(livro01);
    em.persist(livro02);
    em.persist(livro03);
    tx.commit();

    Query consulta = em.createQuery("select b.preco from LivroConsultas b order by b.isbn");
    List<Float> precos = consulta.getResultList();
    assertEquals(3, precos.size());
    assertEquals(new Float(12F), precos.get(0));
    assertEquals(new Float(50F), precos.get(1));
    assertEquals(new Float(10F), precos.get(2));

    consulta = em.createQuery("SELECT CASE WHEN b.editora ='Apress' THEN b.preco * 0.5 ELSE b.preco * 0.8 END FROM LivroConsultas b ORDER BY b.isbn ASC");
    precos = consulta.getResultList();
    assertEquals(3, precos.size());
    assertEquals("12 * 0.5 = 6", new Double(6), precos.get(0));
    assertEquals("50 * 0.5 = 25", new Double(25), precos.get(1));
    assertEquals("10 * 0.8 = 8", new Double(8), precos.get(2));

    // Removo os Livros
    tx.begin();
    em.remove(livro01);
    em.remove(livro02);
    em.remove(livro03);
    tx.commit();
  }
}

