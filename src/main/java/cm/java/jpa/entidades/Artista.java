package cm.java.jpa.entidades;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "t_artistas")
public class Artista {

  // ======================================
  // =             Atributos              =
  // ======================================

  @Id
  @GeneratedValue
  private Long id;
  private String primeiroNome;
  private String ultimoNome;
  @ManyToMany
  @JoinTable(name = "t_junc_arts_cd", 
          joinColumns = @JoinColumn(name = "ce_artista"), 
          inverseJoinColumns = @JoinColumn(name = "ce_cd"))
  private List<CD> apareceNosCDs;

  // ======================================
  // =            Construtores            =
  // ======================================

  public Artista() {
  }

  public Artista(String primeiroNomeParam, String ultimoNomeParam) {
    primeiroNome = primeiroNomeParam;
    ultimoNome = ultimoNomeParam;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public String getPrimeiroNome() {
    return primeiroNome;
  }

  public void setPrimeiroNome(String primeiroNome) {
    this.primeiroNome = primeiroNome;
  }

  public String getUltimoNome() {
    return ultimoNome;
  }

  public void setUltimoNome(String ultimoNome) {
    this.ultimoNome = ultimoNome;
  }

  public List<CD> getApareceNosCDs() {
    return apareceNosCDs;
  }

  public void setApareceNosCDs(List<CD> apareceNosCDs) {
    this.apareceNosCDs = apareceNosCDs;
  }

  public void apareceEm(CD cd) {
    if (apareceNosCDs == null)
      apareceNosCDs = new ArrayList<CD>();
    apareceNosCDs.add(cd);
  }

}