package cm.java.jpa.entidades;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * Contém os atributos e construtores da entidade ReciboJoinColumn
 * @author jaison.santos
 */
@Entity
@Table(name = "t_recibo_join_column2")
public class ReciboJoinColumn {

  // ======================================
  // =             Atributos             =
  // ======================================

  @Id
  @GeneratedValue
  private Long id;
  @Temporal(TemporalType.TIMESTAMP)
  private Date dataCriacao;
  @OneToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "ce_recibo")
  private List<ItemCompraJoinColumn> itensCompra;

  // ======================================
  // =            Construtores            =
  // ======================================

  public ReciboJoinColumn() {
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

  public List<ItemCompraJoinColumn> getItensCompra() {
    return itensCompra;
  }

  public void setItensCompra(List<ItemCompraJoinColumn> itensCompra) {
    this.itensCompra = itensCompra;
  }
}