package cm.java.jpa.consultas;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_livro_cache")
public class LivroSemCache {

    // ======================================
    // =             Atributos              =
    // ======================================
    @Id
    private Long id;
    private String titulo;
    private Float preco;
    private String description;
    private String isbn;
    private Integer nroDePaginas;
    private Boolean ilustracoes;

    // ======================================
    // =            Construtores            =
    // ======================================

    public LivroSemCache() {
    }

    public LivroSemCache(Long idParam, String tituloParam, Float precoParam, String descricaoParam, String isbnParam, Integer nroDePaginasParam, Boolean ilustracoesParam) {
        id = idParam;
        titulo = tituloParam;
        preco = precoParam;
        description = descricaoParam;
        isbn = isbnParam;
        nroDePaginas = nroDePaginasParam;
        ilustracoes = ilustracoesParam;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getNroDePaginas() {
        return nroDePaginas;
    }

    public void setNroDePaginas(Integer nroDePaginas) {
        this.nroDePaginas = nroDePaginas;
    }

    public Boolean getIlustracoes() {
        return ilustracoes;
    }

    public void setIlustracoes(Boolean ilustracoes) {
        this.ilustracoes = ilustracoes;
    }
}