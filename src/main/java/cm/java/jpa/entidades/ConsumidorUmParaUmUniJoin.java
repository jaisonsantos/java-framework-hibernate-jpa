package cm.java.jpa.entidades;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Contém os atributos e construtores da entidade ConsumidorUmParaUmUniJoin
 * @author jaison.santos
 */
@Entity
@Table(name = "t_consumidor_11uni_join")
public class ConsumidorUmParaUmUniJoin {

  // ======================================
    // =             Atributos              =
    // ======================================
    @Id
    @GeneratedValue
    private Long id;
    private String primeiroNome;
    private String ultimoNome;
    private String email;
    private String numeroTelefone;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ce_endereco", nullable = false)
    private EnderecoEnt endereco;

    // ======================================
    // =            Construtores            =
    // ======================================
    public ConsumidorUmParaUmUniJoin() {
    }

    public ConsumidorUmParaUmUniJoin(String primeiroNomeParam, String ultimoNomeParam, String email, String numeroTelefoneParam) {
        primeiroNome = primeiroNomeParam;
        ultimoNome = ultimoNomeParam;
        email = email;
        numeroTelefone = numeroTelefoneParam;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public EnderecoEnt getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEnt endereco) {
        this.endereco = endereco;
    }

}
