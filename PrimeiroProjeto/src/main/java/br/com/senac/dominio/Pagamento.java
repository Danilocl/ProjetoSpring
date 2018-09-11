package br.com.senac.dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import br.com.senac.dominio.enums.StatusPagamento;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // para cada subclasse será criada uma tabela nova
public class Pagamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Pagamento() {
		super();

	}

	public Pagamento(Integer id, StatusPagamento statusPagamento, Pedido pedido) {
		super();
		this.id = id;
		this.statusPagamento = statusPagamento;
		this.pedido = pedido;

	}

	@Id
	private Integer id;

	private StatusPagamento statusPagamento;

	@OneToOne
	@JoinColumn(name = "pedido_id")
	@MapsId
	private Pedido pedido;

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public StatusPagamento getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(StatusPagamento statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
