package cm.java.jpa.entidades;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Contém os atributos e construtores da entidade ConsumidorComEndereco
 * @author jaison.santos
 */
@Entity
@Table(name = "t_consumidor_com_endereco")
@Access(AccessType.FIELD)
public class ConsumidorComEndereco {

  // ======================================
  // =             Atributos              =
  // ======================================

  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "primeiro_nome", nullable = false, length = 50)
  private String primeiroNome;
  @Column(name = "ultimo_nome", nullable = false, length = 50)
  private String ultimoNome;
  private String email;
  @Column(name = "numero_telefone", length = 15)
  private String numeroTelefone;
  @Embedded
  private EnderecoEmbutido endereco;

  // ======================================
  // =            Construtores            =
  // ======================================

  public ConsumidorComEndereco() {
  }

  public ConsumidorComEndereco(String primeiroNomeParam, String ultimoNomeParam, String emailParam, String numeroTelefoneParam) {
    
    primeiroNome = primeiroNomeParam;
    ultimoNome = ultimoNomeParam;
    email = emailParam;
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

  public EnderecoEmbutido getEndereco() {
    return endereco;
  }

  public void setEndereco(EnderecoEmbutido endereco) {
    this.endereco = endereco;
  }
}