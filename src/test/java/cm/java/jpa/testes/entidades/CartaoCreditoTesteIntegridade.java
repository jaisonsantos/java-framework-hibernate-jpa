package cm.java.jpa.testes.entidades;


import cm.java.jpa.entidades.BandeiraCartaoCredito;
import cm.java.jpa.entidades.CartaoCredito;
import cm.java.jpa.testes.TestePersistenciaAbstrato;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;


public class CartaoCreditoTesteIntegridade extends TestePersistenciaAbstrato {

  // ======================================
  // =           Testes Unitários         =
  // ======================================
  @Test
  public void deveriaCriarUmCartaoCredito() throws Exception {

    CartaoCredito cartaoCredito = new CartaoCredito("123412341234", "12/16", 1253, BandeiraCartaoCredito.AMERICAN_EXPRESS);
    tx.begin();
    em.persist(cartaoCredito);
    tx.commit();
    assertNotNull("A ID não deveria ser nula", cartaoCredito.getNumero());
  }
}