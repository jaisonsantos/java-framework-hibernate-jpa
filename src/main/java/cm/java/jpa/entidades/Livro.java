package cm.java.jpa.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * Contém os atributos e construtores da entidade Livro
 * @author jaison.santos
 */
@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;
    private Float preco;
    private String descricao;
    private String isbn;
    private String editora;
    private Integer nroDePaginas;
    private Boolean ilustracoes;

    public Livro() {

    }

    public Livro(Long idParam, String tituloParam, Float precoParam, String descricaoParam, String isbnParam, Integer nroDePaginasParam, Boolean ilustracoesParam) {
        id = idParam;
        titulo = tituloParam;
        preco = precoParam;
        descricao = descricaoParam;
        isbn = isbnParam;
        nroDePaginas = nroDePaginasParam;
        ilustracoes = ilustracoesParam;
    }

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Integer getNroDePaginas() {
        return nroDePaginas;
    }

    public void setNroDePaginas(Integer nroDePaginas) {
        this.nroDePaginas = nroDePaginas;
    }

    public Boolean isIlustracoes() {
        return ilustracoes;
    }

    public void setIlustracoes(Boolean ilustracoes) {
        this.ilustracoes = ilustracoes;
    }

}
