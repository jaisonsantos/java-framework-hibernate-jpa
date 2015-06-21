package cm.java.jpa.entidades;

/**
 * Contém os atributos e construtores da entidade NoticiaIdClasseId
 * @author jaison.santos
 */
public class NoticiaIdClasseId {

  // ======================================
  // =             Atributos              =
  // ======================================

  private String titulo;
  private String idioma;

  // ======================================
  // =            Construtores            =
  // ======================================

  public NoticiaIdClasseId() {
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

  public String getIdioma() {
    return idioma;
  }

  public void setIdioma(String idioma) {
    this.idioma = idioma;
  }

  // ======================================
  // =         hash, equals, toString     =
  // ======================================

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    NoticiaIdClasseId noticiaId = (NoticiaIdClasseId) o;

    if (!idioma.equals(noticiaId.idioma)) return false;
    if (!titulo.equals(noticiaId.titulo)) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = titulo.hashCode();
    result = 31 * result + idioma.hashCode();
    return result;
  }
}