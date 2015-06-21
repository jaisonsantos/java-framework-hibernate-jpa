package cm.java.jpa.entidades;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Contém os atributos e construtores da entidade ConsumidorPorMetodos
 * @author jaison.santos
 */
@Entity
@Table(name = "T_consumidor_metodos")
@Access(AccessType.FIELD)
public class ConsumidorPorMetodos {

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

  // ======================================
  // =            Construtores            =
  // ======================================

  public ConsumidorPorMetodos() {
  }

  public ConsumidorPorMetodos(String primeiroNomeParam, String ultimoNomeParam, String emailParam, String numeroTelefoneParam) {
    primeiroNome = primeiroNomeParam;
    ultimoNome = ultimoNomeParam;
    email = emailParam;
    numeroTelefone = numeroTelefoneParam;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  @Id
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  @Access(AccessType.PROPERTY)
  @Column(name = "numero_telefone", length = 555)
  public String getNumeroTelefone() {
    return numeroTelefone;
  }

  public void setNumeroTelefone(String numeroTelefone) {
    this.numeroTelefone = numeroTelefone;
  }

}