package cm.java.jpa.inicial.test;

import cm.java.jpa.entidades.ComentarioIndexado;
import cm.java.jpa.entidades.NoticiaIndexado;
import cm.java.jpa.inicial.TestePersistenciaAbstrato;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NoticiasIndexadoTesteIntegrado extends TestePersistenciaAbstrato {

  // ======================================
  // =           Testes Unitários         =
  // ======================================
  @Test
  //@Ignore("@OrderColumn parece não funcionar")
  public void deveriaCriarUmaNoticiaComQuatroComentarios() throws Exception {

    NoticiaIndexado noticia = new NoticiaIndexado("Rio de Janeiro será sede das Olimpíadas em 2016");
    noticia.adicionaComentario(new ComentarioIndexado("ze", "Terceiro comentario", 1));
    noticia.adicionaComentario(new ComentarioIndexado("ze praque", "Primeiro comentario", 3));
    noticia.adicionaComentario(new ComentarioIndexado("ze porque", "Segundo comentario", 5));
    noticia.adicionaComentario(new ComentarioIndexado("curioso", "Quarto comentario", 2));

    tx.begin();
    em.persist(noticia);
    tx.commit();
    
    Long idNoticiaQueQueroEncontrar = noticia.getId();

    tx.begin();
    NoticiaIndexado noticiaProcurada = em.find(NoticiaIndexado.class, idNoticiaQueQueroEncontrar);

    // Sem a chamada do metodo refresh, o teste não irá funcionar
    // A anotação OrderColumn especifica a ordenação dos elementos de uma coleção
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