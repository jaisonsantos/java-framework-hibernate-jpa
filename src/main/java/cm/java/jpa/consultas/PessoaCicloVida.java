package cm.java.jpa.consultas;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Contém os atributos e construtores da entidade PessoaCicloVida
 * @author jaison.santos
 */
@EntityListeners(OuvinteDepuracao.class)
@Entity
@Table(name = "t_consumidor_ciclo_vida")
public class PessoaCicloVida implements Serializable {

    // ======================================
    // =             Atributos              =
    // ======================================
    @Id
    @GeneratedValue
    private Long id;
    private String primeiroNome;
    private String ultimoNome;

// ======================================
// =            Construtores            =
// ======================================

    public PessoaCicloVida() {
    }

    public PessoaCicloVida(String primeiroNomeParam, String ultimoNomeParam) {
        primeiroNome = primeiroNomeParam;
        ultimoNome = ultimoNomeParam;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Long getId() {
        return id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }
}