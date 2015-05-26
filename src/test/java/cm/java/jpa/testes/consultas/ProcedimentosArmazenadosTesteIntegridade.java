package cm.java.jpa.testes.consultas;

import cm.java.jpa.testes.TestePersistenciaAbstrato;
import org.junit.Ignore;
import org.junit.Test;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.Date;

public class ProcedimentosArmazenadosTesteIntegridade extends TestePersistenciaAbstrato {

  // ======================================
  // =           Testes Unitários         =
  // ======================================

  @Test 
  public void shouldCallANamedStoredProcedureQuery() throws Exception {

    StoredProcedureQuery consulta = em.createNamedStoredProcedureQuery("arquivarLivrosVelhos");

    // Insere os parametros e executa
    consulta.setParameter("dataArquivamento", new Date());
    consulta.setParameter("maxLivrosArquivados", 1000);
    consulta.execute();
  }

  @Test 
  public void shouldCallAStoredProcedureQuery() throws Exception {

    StoredProcedureQuery consulta = em.createStoredProcedureQuery("pa_arquivar_livros");
    consulta.registerStoredProcedureParameter("dataArquivamento", Date.class, ParameterMode.IN);
    consulta.registerStoredProcedureParameter("maxLivrosArquivados", Integer.class, ParameterMode.IN);

    // Insiro os parametros e executa
    consulta.setParameter("dataArquivamento", new Date());
    consulta.setParameter("maxLivrosArquivados", 1000);
    consulta.execute();
  }
}