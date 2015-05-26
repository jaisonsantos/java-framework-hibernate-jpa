package cm.java.jpa.consultas;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@EntityListeners({OuvinteValidacaoData.class, OuvinteCalculoIdade.class})
@Entity
@Table(name = "t_consumidor_valid_ouvinte")
public class ConsumidorValidadoComOuvinte {

    // ======================================
    // =             Atributos              =
    // ======================================
    @Id
    @GeneratedValue
    private Long id;
    private String primeioNome;
    private String ultimoNome;
    private String email;
    private String numeroTelefone;
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Transient
    private Integer idade;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

// ======================================
// =            Construtores            =
// ======================================

    public ConsumidorValidadoComOuvinte() {
    }

    public ConsumidorValidadoComOuvinte(String primeiroNomeParam, String ultimoNomeParam, String emailParam, String numeroTelefoneParam, Date dataNascimentoParam, Date dataCriacaoParam) {
        primeioNome = primeiroNomeParam;
        ultimoNome = ultimoNomeParam;
        email = emailParam;
        numeroTelefone = numeroTelefoneParam;
        dataNascimento = dataNascimentoParam;
        dataCriacao = dataCriacaoParam;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Long getId() {
        return id;
    }

    public String getPrimeioNome() {
        return primeioNome;
    }

    public void setPrimeioNome(String primeioNome) {
        this.primeioNome = primeioNome;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

}