package cm.java.jpa.entidades;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_cd_heranca_por_classe_sobrescrita")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "cd_id")),
        @AttributeOverride(name = "titulo", column = @Column(name = "cd_titulo")),
        @AttributeOverride(name = "descricao", column = @Column(name = "cd_descricao"))
})
public class CDHerancaPorClasseSobrescrita extends ItemHerancaPorClasseSobrescrita {

  // ======================================
  // =             Atributos              =
  // ======================================

  private String gravadora;
  private Integer numeroDeCDs;
  private Float duracaoTotal;
  private String estilo;

  // ======================================
  // =            Construtores            =
  // ======================================

  public CDHerancaPorClasseSobrescrita() {
  }

  public CDHerancaPorClasseSobrescrita(String tituloParam, Float precoParam, String descricaoParam, String gravadoraParam, Integer numeroDeCDsParam, Float duracaoTotalParam, String estiloParam) {
    super(tituloParam, precoParam, descricaoParam);
    this.gravadora = gravadoraParam;
    this.numeroDeCDs = numeroDeCDsParam;
    this.duracaoTotal = duracaoTotalParam;
    this.estilo = estiloParam;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getGravadora() {
    return gravadora;
  }

  public void setGravadora(String gravadora) {
    this.gravadora = gravadora;
  }

  public Integer getNumeroDeCDs() {
    return numeroDeCDs;
  }

  public void setNumeroDeCDs(Integer numeroDeCDs) {
    this.numeroDeCDs = numeroDeCDs;
  }

  public Float getDuracaoTotal() {
    return duracaoTotal;
  }

  public void setDuracaoTotal(Float duracaoTotal) {
    this.duracaoTotal = duracaoTotal;
  }

  public String getEstilo() {
    return estilo;
  }

  public void setEstilo(String estilo) {
    this.estilo = estilo;
  }
}