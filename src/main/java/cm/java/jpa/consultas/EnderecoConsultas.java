package cm.java.jpa.consultas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_endereco_consulta")
public class EnderecoConsultas {

  // ======================================
  // =             Atributos              =
  // ======================================

  @Id
  @GeneratedValue
  private Long id;
  private String rua1;
  private String cidade;
  private String cep;
  private String pais;

  // ======================================
  // =            Construtores            =
  // ======================================

  public EnderecoConsultas() {
  }

  public EnderecoConsultas(String rua1Param, String cidadeParam, String cepParam, String paisParam) {
    rua1 = rua1Param;
    cidade = cidadeParam;
    cep = cepParam;
    pais = paisParam;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRua1() {
    return rua1;
  }

  public void setRua1(String rua1) {
    this.rua1 = rua1;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }
}