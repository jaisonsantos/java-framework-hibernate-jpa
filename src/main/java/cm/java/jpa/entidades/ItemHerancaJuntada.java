package cm.java.jpa.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "t_item_heranca_juntada")
public class ItemHerancaJuntada {

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

  public ItemHerancaJuntada() {
  }

  public ItemHerancaJuntada(String title, Float price, String description) {
    this.titulo = title;
    this.preco = price;
    this.descricao = description;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

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