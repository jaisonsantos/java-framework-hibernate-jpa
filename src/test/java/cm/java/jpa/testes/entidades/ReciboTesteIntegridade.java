package cm.java.jpa.testes.entidades;

import cm.java.jpa.entidades.ItemCompra;
import cm.java.jpa.entidades.Recibo;
import cm.java.jpa.testes.TestePersistenciaAbstrato;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ReciboTesteIntegridade extends TestePersistenciaAbstrato {

  // ======================================
  // =           Testes unitários         =
  // ======================================
  @Test
  public void deveriaCriarUmReciboComDoisPedidos() throws Exception {

    Recibo recibo = new Recibo();
    ItemCompra ic1 = new ItemCompra("H2OH", 4d, 1);
    ItemCompra ic2 = new ItemCompra("Barra de Cereal", 1.5d, 2);
    List<ItemCompra> itensCompra = new ArrayList<>();
    itensCompra.add(ic1);
    itensCompra.add(ic2);
    recibo.setItensCompra(itensCompra);
    tx.begin();
    em.persist(recibo);
    em.persist(ic1);
    em.persist(ic2);
    tx.commit();
    assertNotNull("O ID do recibo não deveria ser nulo", recibo.getId());
    assertNotNull("O ID do ic1 não deveria ser nulo", ic1.getId());
    assertNotNull("O ID do ic2 não deveria ser nulo", ic2.getId());

    recibo = em.find(Recibo.class, recibo.getId());
    assertNotNull("Os itens de compra não deveriam ser nulos", recibo.getItensCompra());
    assertEquals("Deveriam ter 2 itens de compra", recibo.getItensCompra().size(), 2);
  }
}