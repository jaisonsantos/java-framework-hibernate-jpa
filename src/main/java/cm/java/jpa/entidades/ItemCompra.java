package cm.java.jpa.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Contém os atributos e construtores da entidade ItemCompra
 * @author jaison.santos
 */
@Entity
@Table(name = "t_item_compra")
public class ItemCompra {

  // ======================================
  // =             Atributos              =
  // ======================================

  @Id
  @GeneratedValue
  private Long id;
  private String item;
  private Double precoUnitario;
  private Integer quantidade;

  // ======================================
  // =            Construtores            =
  // ======================================

  public ItemCompra() {
  }

  public ItemCompra(String itemParam, Double precoUnitarioParam, Integer quantidadeParam) {
    item = itemParam;
    precoUnitario = precoUnitarioParam;
    quantidade = quantidadeParam;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public Double getPrecoUnitario() {
    return precoUnitario;
  }

  public void setPrecoUnitario(Double precoUnitario) {
    this.precoUnitario = precoUnitario;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }
}