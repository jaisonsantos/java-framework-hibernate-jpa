package cm.java.jpa.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "t_item_heranca_abstrata")
public abstract class ItemHerancaAbstrata {

  // ======================================
  // =             Atributos              =
  // ======================================

  @Id
  @GeneratedValue
  protected Long id;
  protected String titulo;
  protected Float preco;
  protected String descricao;

  // ======================================
  // =            Construtores            =
  // ======================================

  public ItemHerancaAbstrata() {
  }

  public ItemHerancaAbstrata(String tituloParam, Float precoParam, String descricaoParam) {
    titulo = tituloParam;
    preco = precoParam;
    descricao = descricaoParam;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public Float getPreco() {
    return preco;
  }

  public void setPreco(Float preco) {
    this.preco = preco;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
}