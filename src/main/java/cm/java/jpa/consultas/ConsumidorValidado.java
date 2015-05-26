package cm.java.jpa.consultas;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "T_CONSUMIDOR_VALIDADO")
public class ConsumidorValidado {

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
  private Date dataNascimento;
  @Transient
  private Integer idade;
  @Temporal(TemporalType.TIMESTAMP)
  private Date dataCriacao;

// ======================================
// =            Construtores            =
// ======================================

  public ConsumidorValidado() {
  }

  public ConsumidorValidado(String primeiroNomeParam, String ultimoNomeParam, String emailParam, String numeroTelefoneParam, Date dataNascimentoParam, Date dataCriacaoParam) {
    primeiroNome = primeiroNomeParam;
    ultimoNome = ultimoNomeParam;
    email = emailParam;
    numeroTelefone = numeroTelefoneParam;
    dataNascimento = dataNascimentoParam;
    dataCriacao = dataCriacaoParam;
  }

  public ConsumidorValidado(String primeiroNomeParam, String ultimoNomeParam, String emailParam, String numeroTelefoneParam) {
    primeiroNome = primeiroNomeParam;
    ultimoNome = ultimoNomeParam;
    email = emailParam;
    numeroTelefone = numeroTelefoneParam;
  }

  // ======================================
  // =       Metodos Ciclo de Vida        =
  // ======================================

  @PrePersist
  @PreUpdate
  private void validacao() {
    System.out.println("validacao()");
    if (primeiroNome == null || "".equals(primeiroNome))
      throw new IllegalArgumentException("Primeiro nome invalido");
    if (ultimoNome == null || "".equals(ultimoNome))
      throw new IllegalArgumentException("Ultimo nome invalido");
  }

  @PostLoad
  @PostPersist
  @PostUpdate
  public void calculaIdade() {
    System.out.println("calculaIdade()");
    if (dataNascimento == null) {
      idade = null;
      return;
    }

    Calendar nascimento = new GregorianCalendar();
    nascimento.setTime(dataNascimento);
    Calendar hoje = new GregorianCalendar();
    hoje.setTime(new Date());
    int ajuste = 0;
    if (hoje.get(Calendar.DAY_OF_YEAR) - nascimento.get(Calendar.DAY_OF_YEAR) < 0) {
      ajuste = -1;
    }
    idade = hoje.get(Calendar.YEAR) - nascimento.get(Calendar.YEAR) + ajuste;
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