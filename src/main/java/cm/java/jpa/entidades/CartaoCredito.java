package cm.java.jpa.entidades;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Contém os atributos e construtores da entidade CartaoCredito
 * @author jaison.santos
 */
@Entity
@Table(name = "t_cartao_credito")
public class CartaoCredito {

  // ======================================
  // =             Atributos              =
  // ======================================

  @Id
  private String numero;
  private String dataValidade;
  private Integer numeroControle;
  @Enumerated(EnumType.STRING)
  private BandeiraCartaoCredito bandeiraCartaoCredito;

  // ======================================
  // =            Construtores            =
  // ======================================

  public CartaoCredito() {
  }

  public CartaoCredito(String numeroParam, String dataValidadeParam, Integer numeroControleParam, BandeiraCartaoCredito bandeiraCaratoCreditoParam) {
    numero = numeroParam;
    dataValidade = dataValidadeParam;
    numeroControle = numeroControleParam;
    bandeiraCartaoCredito = bandeiraCaratoCreditoParam;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getDataValidade() {
    return dataValidade;
  }

  public void setDataValidade(String dataValidade) {
    this.dataValidade = dataValidade;
  }

  public Integer getNumeroControle() {
    return numeroControle;
  }

  public void setNumeroControle(Integer numeroControle) {
    this.numeroControle = numeroControle;
  }

  public BandeiraCartaoCredito getType() {
    return bandeiraCartaoCredito;
  }

  public void setType(BandeiraCartaoCredito creditCardType) {
    this.bandeiraCartaoCredito = creditCardType;
  }
}
