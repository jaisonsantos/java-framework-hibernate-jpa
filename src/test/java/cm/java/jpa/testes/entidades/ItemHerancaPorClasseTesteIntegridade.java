package cm.java.jpa.testes.entidades;

import cm.java.jpa.entidades.CDHerancaPorClasse;
import cm.java.jpa.entidades.ItemHerancaPorClasse;
import cm.java.jpa.entidades.LivroHerancaPorClasse;
import cm.java.jpa.testes.TestePersistenciaAbstrato;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ItemHerancaPorClasseTesteIntegridade extends TestePersistenciaAbstrato {

  // ======================================
  // =         Testes Unitários           =
  // ======================================
  @Test
  public void deveriaCriarVariosItens() throws Exception {

    ItemHerancaPorClasse item = new ItemHerancaPorClasse("Item muito caro", 72.50f, "Um pedaço de um item muito caro");
    CDHerancaPorClasse cd01 = new CDHerancaPorClasse("St Pepper", 12.80f, "Obra Prima dos Beatles", "Apple", 1, 53.32f, "Pop/Rock");
    CDHerancaPorClasse cd02 = new CDHerancaPorClasse("The Colour and the Shape ", 20f, "Foi o album com as musicas mais legais do Foo Fighters", "Blue Note", 2, 27.45f, "Rock");
    LivroHerancaPorClasse livro01 = new LivroHerancaPorClasse("O Guia do Mochileiro das Galáxias", 21f, "Melhor livro de tecnologia", "123-456-789", "Pinguin", 321, false);
    LivroHerancaPorClasse livro02 = new LivroHerancaPorClasse("Os Robôs do Amanhecer", 37.5f, "Robos, de novo e de novo", "0-553-29949-2 ", "Foundation", 264, true);
    tx.begin();
    em.persist(item);
    em.persist(cd01);
    em.persist(cd02);
    em.persist(livro01);
    em.persist(livro02);
    tx.commit();
    assertNotNull("O ID do Item não deveria ser nulo", item.getId());
    assertNotNull("O ID do CD1 não deveria ser nulo", cd01.getId());
    assertNotNull("O ID do CD2 não deveria ser nulo", cd02.getId());
    assertNotNull("O ID do Livro1 não deveria ser nulo", livro01.getId());
    assertNotNull("O ID do Livro2 não deveria ser nulo", livro02.getId());
  }
}