package cm.java.jpa.testes.entidades;

import cm.java.jpa.entidades.Artista;
import cm.java.jpa.entidades.CD;
import cm.java.jpa.testes.TestePersistenciaAbstrato;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ArtistaTesteIntegracao extends TestePersistenciaAbstrato {

  // ======================================
  // =           Testes Unitários         =
  // ======================================

  @Test
  public void shouldCreateThreeCDsAndFourArtists() throws Exception {

    Artista ringo = new Artista("Ringo", "Starr");
    Artista john = new Artista("John", "Lenon");
    Artista franck = new Artista("Franck", "Zappa");
    Artista jimi = new Artista("Jimi", "Hendrix");

    CD zoot = new CD("Zoot Allures", 28.5F, "Lançado em Outubro de 1976, foi considerado o melhor album feito em estúdo");
    CD sgtpepper = new CD("Sergent Pepper", 38.5F, "Melhor Album dos Beatles");
    CD heyjoe = new CD("Hey Joe", 32F, "Hendrix ao vivo, com amigos");

    ringo.apareceEm(sgtpepper);
    john.apareceEm(sgtpepper);
    john.apareceEm(heyjoe);
    franck.apareceEm(zoot);
    franck.apareceEm(heyjoe);
    jimi.apareceEm(heyjoe);
    jimi.apareceEm(sgtpepper);

    zoot.criadoPor(franck);
    sgtpepper.criadoPor(ringo);
    sgtpepper.criadoPor(john);
    heyjoe.criadoPor(jimi);

    tx.begin();
    em.persist(ringo);
    em.persist(john);
    em.persist(franck);
    em.persist(jimi);
    em.persist(zoot);
    em.persist(sgtpepper);
    em.persist(heyjoe);
    tx.commit();
    
    assertNotNull("A ID do Ringo não deveria ser nulo", ringo.getId());
    assertNotNull("A ID do John não deveria ser nulo", john.getId());
    assertNotNull("A ID do Franck não deveria ser nulo", franck.getId());
    assertNotNull("A ID do Zoot não deveria ser nulo", zoot.getId());
    assertNotNull("A ID do Sgt Pepper não deveria ser nulo", sgtpepper.getId());
    assertNotNull("A ID do Hey  não deveria ser nulo", heyjoe.getId());
  }
}