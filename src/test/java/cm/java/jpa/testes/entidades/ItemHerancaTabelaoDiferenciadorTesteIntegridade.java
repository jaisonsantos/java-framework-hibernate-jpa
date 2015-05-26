package cm.java.jpa.testes.entidades;

import cm.java.jpa.entidades.CDHerancaTabelaoDiferenciador;
import cm.java.jpa.entidades.ItemHerancaTabelaoDiferenciador;
import cm.java.jpa.entidades.LivroHerancaTabelaoDiferenciador;
import cm.java.jpa.testes.TestePersistenciaAbstrato;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ItemHerancaTabelaoDiferenciadorTesteIntegridade extends TestePersistenciaAbstrato {

  // ======================================
    // =           Testes unitários         =
    // ======================================
    @Test
    public void deveriaCriarVariosItens() throws Exception {

        ItemHerancaTabelaoDiferenciador item = new ItemHerancaTabelaoDiferenciador("Item muito caro", 72.50f, "Um pedaço de um item muito caro");
        CDHerancaTabelaoDiferenciador cd01 = new CDHerancaTabelaoDiferenciador("St Pepper", 12.80f, "Obra Prima dos Beatles", "Apple", 1, 53.32f, "Pop/Rock");
        CDHerancaTabelaoDiferenciador cd02 = new CDHerancaTabelaoDiferenciador("The Colour and the Shape ", 20f, "Foi o album com as musicas mais legais do Foo Fighters", "Blue Note", 2, 27.45f, "Rock");
        LivroHerancaTabelaoDiferenciador livro01 = new LivroHerancaTabelaoDiferenciador("O Guia do Mochileiro das Galáxias", 21f, "Melhor livro de tecnologia", "123-456-789", "Pinguin", 321, false);
        LivroHerancaTabelaoDiferenciador livro02 = new LivroHerancaTabelaoDiferenciador("Os Robôs do Amanhecer", 37.5f, "Robos, de novo e de novo", "0-553-29949-2 ", "Foundation", 264, true);

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
