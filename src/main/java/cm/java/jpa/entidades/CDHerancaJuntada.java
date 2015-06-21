package cm.java.jpa.entidades;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Contém os atributos e construtores da entidade cdHerancaJuntada
 * @author jaison
 */
@Entity
@Table(name = "t_cd_heranca_juntada")
public class CDHerancaJuntada extends ItemHerancaJuntada {

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

  public CDHerancaJuntada() {
  }

  public CDHerancaJuntada(String tituloParam, Float precoParam, String descricaoParam, String gravadoraParam, Integer numeroDeCDsParam, Float duracaoTotalParam, String estiloParam) {
    super(tituloParam, precoParam, descricaoParam);
    gravadora = gravadoraParam;
    numeroDeCDs = numeroDeCDsParam;
    duracaoTotal = duracaoTotalParam;
    estilo = estiloParam;
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