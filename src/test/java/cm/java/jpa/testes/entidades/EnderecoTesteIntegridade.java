package cm.java.jpa.testes.entidades;

import cm.java.jpa.entidades.Endereco;
import cm.java.jpa.testes.TestePersistenciaAbstrato;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class EnderecoTesteIntegridade extends TestePersistenciaAbstrato {

  // ======================================
  // =              Testes unitários      =
  // ======================================

  @Test
  public void deveriaCriarUmEndereco() throws Exception {

    Endereco endereco = new Endereco(getIdRandomico(), "Rua da Assembléia 10", "Bairro: Centro", "Rio de Janeiro", "RJ", "20011901", "BR");
    tx.begin();
    em.persist(endereco);
    tx.commit();
    assertNotNull("O Id não deveria ser nulo", endereco.getId());
  }
}