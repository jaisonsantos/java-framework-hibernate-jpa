package cm.java.jpa.entidades;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;


@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "t_item_heranca_supermapeada")
public class ItemHerancaSuperMapeada {

  // ======================================
  // =             Atributos              =
  // ======================================

  @Id
  @GeneratedValue
  protected Long id;
  @Column(length = 50, nullable = false)
  protected String titulo;
  protected Float preco;
  @Column(length = 2000)
  protected String descricao;

  // ======================================
  // =            Construtores            =
  // ======================================

  public ItemHerancaSuperMapeada() {
  }

  public ItemHerancaSuperMapeada(String tituloParam, Float precoParam, String descricaoParam) {
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