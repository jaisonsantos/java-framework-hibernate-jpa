package cm.java.jpa.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Contém os atributos e construtores da entidade EnderecoEnt
 * @author jaison.santos
 */
@Entity
@Table(name = "t_endereco")
public class EnderecoEnt {

  // ======================================
  // =             Atributos              =
  // ======================================

  @Id
  @GeneratedValue
  private Long id;
  private String rua1;
  private String rua2;
  private String cidade;
  private String estado;
  private String cep;
  private String pais;

  // ======================================
  // =            Construtores            =
  // ======================================

  public EnderecoEnt() {
  }

  public EnderecoEnt(String rua1Param, String rua2Param, String cidadeParam, String estadoParam, String cepParam, String paisParam) {
    rua1 = rua1Param;
    rua2 = rua2Param;
    cidade = cidadeParam;
    estado = estadoParam;
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

  public String getRua2() {
    return rua2;
  }

  public void setRua2(String rua2) {
    this.rua2 = rua2;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
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