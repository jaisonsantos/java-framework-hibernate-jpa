package cm.java.jpa.testes.consultas;

import cm.java.jpa.consultas.ConsumidorCache;
import cm.java.jpa.consultas.EnderecoConsultas;
import cm.java.jpa.consultas.EnderecoSemCache;
import cm.java.jpa.consultas.LivroConsultas;
import cm.java.jpa.consultas.LivroSemCache;
import cm.java.jpa.testes.TestePersistenciaAbstrato;
import org.junit.Test;

import javax.persistence.Cache;

import static org.junit.Assert.*;

/**
 * Classe que contém os testes unitários CacheTesteIntegridade
 * @author jaison
 */
public class CacheTesteIntegridade extends TestePersistenciaAbstrato {

  // ======================================
  // =           Testes unitários         =
  // ======================================

   @Test
  public void deveriaVerificarQueLivroNaoEstaNoCachePorPadrao() throws Exception {

    LivroSemCache livro = new LivroSemCache(getIdRandomico(),"O Guia do Mochileiro das Galaxias", 12F, "O Guia do Mochileiro das Galaxias faz parte de uma série de comédia criada por Douglas Adams.", "1-84023-742-2", 354, false);
        
    // Persisto o objeto
    tx.begin();
    em.persist(livro);
    tx.commit();

    assertNotNull(livro.getId());

    Cache cache = emf.getCache();

    // Livro nao deveria estar no cache por padrao
    assertFalse(cache.contains(LivroConsultas.class, livro.getId()));
  }  
    
  @Test
  public void deveriaVerificarSeEsseEnderecoNaoEstaComCache() throws Exception {

    EnderecoSemCache endereco = new EnderecoSemCache("Rua Dois", "Rio de Janeiro", "20770111", "BR");
    
    // Persisto o Objeto
    tx.begin();
    em.persist(endereco);
    tx.commit();

    assertNotNull(endereco.getId());

    Cache cache = emf.getCache();

    // O endereco nao deveria estar no cache
    assertFalse(cache.contains(EnderecoConsultas.class, endereco.getId()));
  }

  @Test
  public void deveriaVerificarQueConsumidorPossuiCache() throws Exception {

    ConsumidorCache consumidor = new ConsumidorCache("Bruno", "Penha", "cm.java.frameworks@gmail.com");

    // Persisto o objeto
    tx.begin();
    em.persist(consumidor);
    tx.commit();

    assertNotNull(consumidor.getId());

    Cache cache = emf.getCache();

    //O consumidor deveria estar no Cache
    assertTrue(cache.contains(ConsumidorCache.class, consumidor.getId()));

    cache.evict(ConsumidorCache.class);

    // After clearing the cache Customer should not be in the cache
    // Depois de limpar o cache, o ConsumidorCache não deveria estar no cache
    assertFalse(cache.contains(ConsumidorCache.class, consumidor.getId()));
  }
 
}