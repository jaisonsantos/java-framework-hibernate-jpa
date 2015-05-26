package cm.java.jpa.consultas;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ExcludeSuperclassListeners;
import javax.persistence.Transient;

@ExcludeSuperclassListeners()
@EntityListeners(OuvinteConsumidor.class)
@Entity
public class ConsumidorCicloVida extends PessoaCicloVida {

    // ======================================
    // =             Atributos              =
    // ======================================
    private String email;
    private String numeroTelefone;
    @Transient
    private Integer idade;

    // ======================================
    // =            Construtores            =
    // ======================================

    public ConsumidorCicloVida() {
    }

    public ConsumidorCicloVida(String primeiroNomeParam, String ultimoNomeParam, String emailParam, String numeroTelefoneParam) {
        super(primeiroNomeParam, ultimoNomeParam);
        email = emailParam;
        numeroTelefone = numeroTelefoneParam;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

}