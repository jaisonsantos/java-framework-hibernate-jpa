package cm.java.jpa.entidades;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Contém os atributos e construtores da entidade CDHerancaPorClasse
 * @author jaison.santos
 */
@Entity
@Table(name = "t_cd_heranca_por_classe")
public class CDHerancaPorClasse extends ItemHerancaPorClasse {

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

  public CDHerancaPorClasse() {
  }

  public CDHerancaPorClasse(String tituloParam, Float precoParam, String descricaoParam, String gravadoraParam, Integer numeroDeCDsParam, Float duracaoTotalParam, String estiloParam) {
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