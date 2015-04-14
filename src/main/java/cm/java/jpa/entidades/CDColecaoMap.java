package cm.java.jpa.entidades;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

@Entity
@Table(name = "t_cd_colecao_map")
public class CDColecaoMap {

  // ======================================
  // =             Atributos              =
  // ======================================

  @Id
  @GeneratedValue
  private Long id;
  private String titulo;
  private Float preco;
  private String descricao;
  @Lob
  private byte[] capa;
  @ElementCollection
  @CollectionTable(name = "t_trilha")
  @MapKeyColumn(name = "posicao")
  @Column(name = "titulo")
  private Map<Integer, String> trilhas = new HashMap<>();

  // ======================================
  // =            Construtores            =
  // ======================================

  public CDColecaoMap() {
  }

  public CDColecaoMap(String tituloParam, Float precoParam, String descricaoParam, HashMap<Integer, String> trilhasParam) {
    titulo = tituloParam;
    preco = precoParam;
    descricao = descricaoParam;
    trilhas = trilhasParam;
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

  public byte[] getCapa() {
    return capa;
  }

  public void setCapa(byte[] capa) {
    this.capa = capa;
  }

  public Map<Integer, String> getTrilhas() {
    return trilhas;
  }

  public void setTracks(HashMap<Integer, String> tracks) {
    this.trilhas = tracks;
  }
}
