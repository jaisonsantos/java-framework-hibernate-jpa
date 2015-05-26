
package cm.java.jpa.testes.entidades;
import cm.java.jpa.entidades.Pessoa;
import cm.java.jpa.testes.TestePersistenciaAbstrato;
import javax.validation.ConstraintViolationException;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import org.junit.Test;

public class PessoaTesteIntegridade extends TestePersistenciaAbstrato{

  // ======================================
  // =           Testes Unitarios         =
  // ======================================
    
    @Test
    public void deveriaEncontrarPessoaMaria() throws Exception {
        Pessoa pessoa = em.find(Pessoa.class, 1001L);
        assertEquals("Maria", pessoa.getPrimeiroNome());
    }

    @Test
    public void deveriaCriarPessoaJose() throws Exception {
        Pessoa pessoa = new Pessoa("222222","Bruno", "Penha");
        tx.begin();
        em.persist(pessoa);
        tx.commit();

        assertNotNull("A ID não deveria ser nula", pessoa.getId());

        pessoa = em.createNamedQuery("encontrePessoaBruno", Pessoa.class).getSingleResult();
        assertEquals("Bruno Penha", pessoa.getPrimeiroNome() + " " + pessoa.getUltimoNome());
    }  
    

    @Test(expected = ConstraintViolationException.class)
    public void deveriaDarExcecaoViolacaoConstraint() {
        Pessoa pessoa = new Pessoa(null,"Sem Primeiro Nome ", "ultimo nome nulo");
        em.persist(pessoa);
    }
    
  
   
    
   
}
