package cm.java.jpa.entidades;

import javax.persistence.*;

/**
 * Contém os atributos e construtores da entidade Endereco
 * @author jaison.santos
 */
@Entity
@Table(name = "t_endereco")
@SecondaryTables({
        @SecondaryTable(name = "t_cidade"),
        @SecondaryTable(name = "t_pais")
})
public class Endereco {

  // ======================================
  // =             Atributos             =
  // ======================================

  @Id
  private Long id;
  private String rua1;
  private String rua2;
  @Column(table = "t_cidade")
  private String cidade;
  @Column(table = "t_cidade")
  private String estado;
  @Column(table = "t_cidade")
  private String cep;
  @Column(table = "t_pais")
  private String pais;

  // ======================================
  // =            Construtores            =
  // ======================================

  public Endereco() {
  }

  public Endereco(Long idParam, String rua1Param, String rua2Param, String cidadeParam, String estadoParam, String cepParam, String paisParam) {
    id = idParam;
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