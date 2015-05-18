package cm.java.jpa.consultas;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "t_consumidor_manip")
public class ConsumidorManip {

  // ======================================
  // =             Atributos              =
  // ======================================

  @Id
  @GeneratedValue
  private Long id;
  private String primeiroNome;
  private String ultimoNome;
  private String email;
  @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
  @JoinColumn(name = "ce_endereco")
  private EnderecoManip endereco;

  // ======================================
  // =            Construtores            =
  // ======================================

  public ConsumidorManip() {
  }

  public ConsumidorManip(String primeiroNomeParam, String ultimoNomeParam, String emailParam) {
    primeiroNome = primeiroNomeParam;
    ultimoNome = ultimoNomeParam;
    email = emailParam;
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

  public EnderecoManip getEndereco() {
    return endereco;
  }

  public void setEndereco(EnderecoManip endereco) {
    this.endereco = endereco;
  }
}