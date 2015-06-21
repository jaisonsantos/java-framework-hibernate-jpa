package cm.java.jpa.entidades;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Contém os atributos e construtores da entidade embutida EnderecoEmbutido
 * @author jaison.santos
 */
@Embeddable
@Access(AccessType.PROPERTY)
public class EnderecoEmbutido {

  // ======================================
  // =             Atributos              =
  // ======================================

  private String rua1;
  private String rua2;
  private String cidade;
  private String estado;
  private String cep;
  private String pais;

  // ======================================
  // =            Construtores            =
  // ======================================

  public EnderecoEmbutido() {
  }

  public EnderecoEmbutido(String rua1Param, String rua2Param, String cidadeParam, String estadoParam, String cepParam, String paisParam) {
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

  @Column(nullable = false)
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

  @Column(nullable = false, length = 50)
  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  @Column(length = 3)
  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  @Column(name = "zip_code", length = 10)
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