package cm.java.jpa.consultas;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "t_consumidor_consulta")
@NamedQueries({
        @NamedQuery(name = "encontreTodos", query = "select c from ConsumidorConsultas c"),
        @NamedQuery(name = ConsumidorConsultas.ENCONTRE_TODOS, query = "select c from ConsumidorConsultas c"),
        @NamedQuery(name = "encontreBruno", query = "select c from ConsumidorConsultas c where c.primeiroNome = 'Bruno'"),
        @NamedQuery(name = "encontreComParametro", query = "select c from ConsumidorConsultas c where c.primeiroNome = :pnome")
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "encontreTodosNativo", query = "select * from JPQL_CONSUMIDOR", resultClass = ConsumidorConsultas.class)
})
public class ConsumidorConsultas {

  public static final String ENCONTRE_TODOS = "ConsumidorConsultas.encontreTodos";

  // ======================================
  // =             Atributos              =
  // ======================================

  @Id
  @GeneratedValue
  private Long id;
  private String primeiroNome;
  private String ultimoNome;
  private Integer idade;
  private String email;
  @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
  @JoinColumn(name = "ce_endereco")
  private EnderecoConsultas endereco;

  // ======================================
  // =            Construtores            =
  // ======================================

  public ConsumidorConsultas() {
  }

  public ConsumidorConsultas(String primeiroNomeParam, String ultimoNomeParam, String emailParam, Integer idadeParam) {
    primeiroNome = primeiroNomeParam;
    ultimoNome = ultimoNomeParam;
    email = emailParam;
    idade = idadeParam;
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

  public EnderecoConsultas getEndereco() {
    return endereco;
  }

  public void setEndereco(EnderecoConsultas endereco) {
    this.endereco = endereco;
  }

  public Integer getIdade() {
    return idade;
  }

  public void setIdade(Integer idade) {
    this.idade = idade;
  }
}