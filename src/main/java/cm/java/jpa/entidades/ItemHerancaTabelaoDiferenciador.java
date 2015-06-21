package cm.java.jpa.entidades;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Contém os atributos e construtores da entidade ItemHerancaTabelaoDiferenciador
 * @author jaison.santos
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "diferenciador", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("I")
@Table(name = "t_item_diferenciador")
public class ItemHerancaTabelaoDiferenciador {

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

  public ItemHerancaTabelaoDiferenciador() {
  }

  public ItemHerancaTabelaoDiferenciador(String tituloParam, Float precoParam, String descricaoParam) {
    titulo = tituloParam;
    preco = precoParam;
    descricao = descricaoParam;
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