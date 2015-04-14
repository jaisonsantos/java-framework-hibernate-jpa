package cm.java.jpa.entidades;

public class ItemHerancaTransiente {

  // ======================================
  // =             Atributos              =
  // ======================================

  protected String titulo;
  protected Float preco;
  protected String descricao;

  // ======================================
  // =            Construtores            =
  // ======================================

  public ItemHerancaTransiente() {
  }

  public ItemHerancaTransiente(String tituloParam, Float precoParam, String descricaoParam) {
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