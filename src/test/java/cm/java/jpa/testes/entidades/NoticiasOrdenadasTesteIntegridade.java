package cm.java.jpa.testes.entidades;

import cm.java.jpa.entidades.ComentarioOrdenado;
import cm.java.jpa.entidades.NoticiaOrdenado;
import cm.java.jpa.testes.TestePersistenciaAbstrato;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NoticiasOrdenadasTesteIntegridade extends TestePersistenciaAbstrato {

  // ======================================
  // =           Testes Unitários         =
  // ======================================
  @Test
  public void shouldCreateOneNewsWithFourComments() throws Exception {

    NoticiaOrdenado noticia = new NoticiaOrdenado("Rio de Janeiro será sede das Olimpíadas em 2016");
    noticia.adicionaComentario(new ComentarioOrdenado("ze", "Terceiro comentario", 1, "03-07-2009"));
    noticia.adicionaComentario(new ComentarioOrdenado("ze praque", "Primeiro comentario", 3, "01-07-2009"));
    noticia.adicionaComentario(new ComentarioOrdenado("ze porque", "Segundo comentario", 5, "02-07-2009"));
    noticia.adicionaComentario(new ComentarioOrdenado("curioso", "Quarto comentario", 2, "06-07-2009"));

    tx.begin();
    em.persist(noticia);
    tx.commit();
    
    Long idNoticiaQueQueroEncontrar = noticia.getId();

    tx.begin();
    NoticiaOrdenado noticiaProcurada = em.find(NoticiaOrdenado.class, idNoticiaQueQueroEncontrar);

    // Sem a chamada do metodo refresh, o teste não irá funcionar
    // A anotação OrderBy especifica a ordenação dos elementos de uma coleção
    // A chave aqui é a frase "quando a associação é recuperada".  
    // Nessa caso, quando o método find for executado, a associação ainda estará gerenciado e nenhuma recuperação lógica é feita.
    em.refresh(noticiaProcurada);

    tx.commit();

    assertEquals("Rio de Janeiro será sede das Olimpíadas em 2016", noticiaProcurada.getConteudo());
    assertEquals(4, noticiaProcurada.getComentarios().size());
    assertEquals("Quarto comentario", noticiaProcurada.getComentarios().get(0).getConteudo());
    assertEquals("Terceiro comentario", noticiaProcurada.getComentarios().get(1).getConteudo());
    assertEquals("Segundo comentario", noticiaProcurada.getComentarios().get(2).getConteudo());
    assertEquals("Primeiro comentario", noticiaProcurada.getComentarios().get(3).getConteudo());
  }
}