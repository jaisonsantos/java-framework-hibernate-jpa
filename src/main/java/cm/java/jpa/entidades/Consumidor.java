package cm.java.jpa.entidades;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Contém os atributos e construtores da entidade Consumidor
 * @author jaison.santos
 */
@Entity
@Table(name = "t_consumidor")
public class Consumidor {

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
  @Temporal(TemporalType.DATE)
  private Date dataDeNascimento;
  @Transient
  private Integer idade;
  @Temporal(TemporalType.TIMESTAMP)
  private Date dataCriacao;

  // ======================================
  // =            Construtores            =
  // ======================================

  public Consumidor() {
  }

  public Consumidor(String primeiroNomeParam, String ultimoNomeParam, String emailParam, String numeroTelefoneParam, Date dataNascimentoParam, Date dataCriacaoParam) {
    primeiroNome = primeiroNomeParam;
    ultimoNome = ultimoNomeParam;
    email = emailParam;
    numeroTelefone = numeroTelefoneParam;
    dataDeNascimento = dataNascimentoParam;
    dataCriacao = dataCriacaoParam;
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

  public Date getDataDeNascimento() {
    return dataDeNascimento;
  }

  public void setDataDeNascimento(Date dataDeNascimento) {
    this.dataDeNascimento = dataDeNascimento;
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
