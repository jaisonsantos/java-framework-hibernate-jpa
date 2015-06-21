package cm.java.jpa.principal;

import cm.java.jpa.entidades.Pessoa;
import cm.java.jpa.entidades.Livro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Classe Principal onde são executadas as instâncias com objetos preenchidos.
 * @author jaison.santos
 */
public class Principal {

    public static void main(String args[]) {

        // 1 - Crio uma instancia 
        Pessoa pessoa = new Pessoa("1111111111","Bruno", "Penha");
        
        
        Livro livro = new Livro();
        livro.setTitulo("Beginning Java EE7");
        livro.setDescricao("Livro utilizado na disciplina Java Frameworks");
        livro.setPreco(30.01f);
        livro.setEditora("Apress");
        livro.setIlustracoes(Boolean.TRUE);
        livro.setIsbn("978-1-4302-4626-8");
        livro.setNroDePaginas(573);
        
      
        // 2 - Obtem um gerenciador de entidades e uma transação
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("cmJavaJPA");

        EntityManager em = emf.createEntityManager();

        // 3 - Persiste o objeto pessoa no banco de dados
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(pessoa);
         em.persist(livro);
         tx.commit();

        // 4 - Executa a "named query"
        pessoa
                = em.createNamedQuery("encontrePessoaBruno", Pessoa.class).getSingleResult();
        
        
        List<Livro> livros = em.createQuery("Select l from Livro l", Livro.class).getResultList();
     
        // 5 - Encerra o EntityManager e o EntityManagerFactory
        em.close();
        emf.close();
    }
}
