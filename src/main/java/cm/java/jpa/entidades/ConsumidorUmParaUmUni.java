package cm.java.jpa.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Contém os atributos e construtores da entidade ConsumidorUmParamUmUni
 * @author jaison.santos
 */
@Entity
@Table(name = "t_consumidor_11uni")
public class ConsumidorUmParaUmUni {

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
  private EnderecoEnt endereco;

  // ======================================
  // =            Construtores            =
  // ======================================

  public ConsumidorUmParaUmUni() {
  }

  public ConsumidorUmParaUmUni(String firstName, String lastName, String email, String phoneNumber) {
    this.primeiroNome = firstName;
    this.ultimoNome = lastName;
    this.email = email;
    this.numeroTelefone = phoneNumber;
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