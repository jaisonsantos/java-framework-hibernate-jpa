package cm.java.jpa.entidades;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_comentarios_ordenado")
public class ComentarioOrdenado {

  // ======================================
  // =             Atributos              =
  // ======================================

  @Id
  @GeneratedValue
  private Long id;
  private String apelido;
  private String conteudo;
  private Integer nota;
  @Column(name = "data_publicacao")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dataPublicacao;

  // ======================================
  // =            Construtores            =
  // ======================================

  public ComentarioOrdenado() {
  }

  public ComentarioOrdenado(String apelidoParam, String conteudo, Integer nota, String dataPublicacao) {
    this.apelido = apelidoParam;
    this.conteudo = conteudo;
    this.nota = nota;

    try {
      DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
      this.dataPublicacao = df.parse(dataPublicacao);
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public String getApelido() {
    return apelido;
  }

  public void setApelido(String apelido) {
    this.apelido = apelido;
  }

  public String getConteudo() {
    return conteudo;
  }

  public void setConteudo(String conteudo) {
    this.conteudo = conteudo;
  }

  public Integer getNota() {
    return nota;
  }

  public void setNota(Integer nota) {
    this.nota = nota;
  }
  
  
}