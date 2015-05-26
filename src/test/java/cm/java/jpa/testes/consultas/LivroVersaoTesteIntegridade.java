package cm.java.jpa.testes.consultas;

import cm.java.jpa.consultas.LivroVersao;
import cm.java.jpa.testes.TestePersistenciaAbstrato;
import org.junit.Test;

import javax.persistence.LockModeType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LivroVersaoTesteIntegridade extends TestePersistenciaAbstrato {

  // ======================================
  // =           Testes unitários         =
  // ======================================

  @Test
  public void deveriaCriarUmLivro() throws Exception {

    // Cria um livro e o valor da versao deveria ser 1
    LivroVersao livro = new LivroVersao("Guia do Mochileiro das Galáxias", 12.5F, "O Guia do Mochileiro das Galáxias é uma série de comédia ficção científica criada por Douglas Adams.", "1-84023-742-2", 354, false);
    tx.begin();
    em.persist(livro);
    tx.commit();
    assertNotNull("O id não deveria ser nulo", livro.getId());
    assertEquals("O numero da versao deveria ser 1", new Integer(1), livro.getVersao());

    // Atualizo o mesmo livro
    tx.begin();
    livro = em.find(LivroVersao.class, livro.getId());
    livro.setDescricao("nova descricao");
    tx.commit();
    assertEquals("O numero da versao deveria ser 2", new Integer(2), livro.getVersao());
  }

  @Test
  public void deveriaCriarUmLivroEAumentarOPreco() throws Exception {

    // Cria um livro e o valor da versao deveria ser 1
    LivroVersao livro = new LivroVersao("Guia do Mochileiro das Galáxias", 12.5F, "O Guia do Mochileiro das Galáxias é uma série de comédia ficção científica criada por Douglas Adams.", "1-84023-742-2", 354, false);
    
    tx.begin();
    em.persist(livro);
    tx.commit();
    assertNotNull("O id não deveria ser nulo", livro.getId());
    assertEquals("O numero da versão deveria ser 1", new Integer(1), livro.getVersao());

    // Atualizo o mesmo livro
    tx.begin();
    livro.aumentoOPrecoEmDoisReais();
    tx.commit();
    assertEquals("O numero de versão deveria ser 2", new Integer(2), livro.getVersao());
  }

  @Test
  public void deveriaLerEDepoisTravar() throws Exception {
  
    // Cria um livro e o valor da versao deveria ser 1
    LivroVersao livro = new LivroVersao("Guia do Mochileiro das Galáxias", 12.5F, "O Guia do Mochileiro das Galáxias é uma série de comédia ficção científica criada por Douglas Adams.", "1-84023-742-2", 354, false);
    
    tx.begin();
    em.persist(livro);
    tx.commit();
    assertNotNull("O id não deveria ser nulo", livro.getId());
    assertEquals("O numero da versão deveria ser 1", new Integer(1), livro.getVersao());

    // Faço a leitura e travo
    tx.begin();
    livro = em.find(LivroVersao.class, livro.getId());
    em.lock(livro, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
    livro.aumentoOPrecoEmDoisReais();
    tx.commit();
    assertEquals("O numero da versão deveria ser 2", new Integer(2), livro.getVersao());
    assertEquals("O preço deveria ter aumentado em 2 reais", new Float(14.5), livro.getPreco());
  }

  @Test
  public void deveriaLerETravar() throws Exception {

    // Cria um livro e o valor da versao deveria ser 1
    LivroVersao livro = new LivroVersao("Guia do Mochileiro das Galáxias", 12.5F, "O Guia do Mochileiro das Galáxias é uma série de comédia ficção científica criada por Douglas Adams.", "1-84023-742-2", 354, false);
    
    tx.begin();
    em.persist(livro);
    tx.commit();
    assertNotNull("O id não deveria ser nulo", livro.getId());
    assertEquals("O numero da versão deveria ser 1", new Integer(1), livro.getVersao());

    // Leio e travo
    tx.begin();
    livro = em.find(LivroVersao.class, livro.getId(), LockModeType.OPTIMISTIC_FORCE_INCREMENT);
    livro.aumentoPrecoEmCincoReais();
    tx.commit();
    assertEquals("O numero da Versão deveria ser 2", new Integer(2), livro.getVersao());
    assertEquals("O preço deveria ser aumentado em cinco reais", new Float(17.5), livro.getPreco());
  }
}