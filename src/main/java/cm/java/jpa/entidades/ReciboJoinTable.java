package cm.java.jpa.entidades;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * Contém os atributos e construtores da entidade ReciboJoinTable
 * @author jaison.santos
 */
@Entity
@Table(name = "t_recibo_join_column")
public class ReciboJoinTable {

  // ======================================
  // =             Atributos             =
  // ======================================

  @Id
  @GeneratedValue
  private Long id;
  @Temporal(TemporalType.TIMESTAMP)
  private Date dataCriacao;
  @OneToMany
  @JoinTable(name = "t_item_compra_join_column", 
             joinColumns = @JoinColumn(name = "ce_recibo"), 
             inverseJoinColumns = @JoinColumn(name = "ce_item_compra"))
  private List<ItemCompraJoinTable> itensCompra;

  // ======================================
  // =            Construtores            =
  // ======================================

  public ReciboJoinTable() {
    this.dataCriacao = new Date();
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public Date getDataCriacao() {
    return dataCriacao;
  }

  public void setDataCriacao(Date dataCriacao) {
    this.dataCriacao = dataCriacao;
  }

  public List<ItemCompraJoinTable> getItensCompra() {
    return itensCompra;
  }

  public void setItensCompra(List<ItemCompraJoinTable> itensCompra) {
    this.itensCompra = itensCompra;
  }
}