package cm.java.jpa.entidades;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "t_cd")
public class CD {

  // ======================================
  // =             Atributos              =
  // ======================================

  @Id
  @GeneratedValue
  private Long id;
  private String titulo;
  private Float preco;
  private String descricao;
  @ManyToMany(mappedBy = "apareceNosCDs")
  private List<Artista> criadoPelosArtistas;

  // ======================================
  // =            Construtores            =
  // ======================================

  public CD() {
  }

  public CD(String tituloParam, Float precoParam, String descricaoParam) {
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

  public List<Artista> getCriadoPelosArtistas() {
    return criadoPelosArtistas;
  }

  public void setCriadoPelosArtistas(List<Artista> criadoPelosArtistas) {
    this.criadoPelosArtistas = criadoPelosArtistas;
  }

  public void criadoPor(Artista artista) {
    if (criadoPelosArtistas == null)
      criadoPelosArtistas = new ArrayList<Artista>();
    criadoPelosArtistas.add(artista);
  }
}