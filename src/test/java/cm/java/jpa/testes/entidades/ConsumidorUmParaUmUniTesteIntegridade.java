package cm.java.jpa.testes.entidades;


import cm.java.jpa.entidades.ConsumidorUmParaUmUni;
import cm.java.jpa.entidades.EnderecoEnt;
import cm.java.jpa.testes.TestePersistenciaAbstrato;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 * Classe responsável pelo teste unitario de ConsumidorUmParaUmUniTesteIntegridade
 * @author jaison.santos
 */
public class ConsumidorUmParaUmUniTesteIntegridade extends TestePersistenciaAbstrato {

  // ======================================
  // =           Testes Unitários         =
  // ======================================

  @Test
  public void deveriaCriarUmConsumidorComUmEndereco() throws Exception {

    ConsumidorUmParaUmUni consumidor = new ConsumidorUmParaUmUni("Bruno", "Penha", "cm.java.frameworks@gmail.com", "1234565");
    EnderecoEnt endereco = new EnderecoEnt("Rua da Assembleia, 10", "Bairro: Centro", "Rio de Janeiro", "RJ", "20011-901", "BR");
    consumidor.setEndereco(endereco);
    tx.begin();
    em.persist(consumidor);
    em.persist(endereco);
    tx.commit();
    assertNotNull("O ID não deveria ser nulo...", consumidor.getId());

    consumidor = em.find(ConsumidorUmParaUmUni.class, consumidor.getId());
    assertNotNull("O endereco do consumidor não deveria ser nulo", consumidor.getEndereco());
  }
}