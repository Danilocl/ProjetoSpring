package br.com.senac.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import br.com.senac.dominio.enums.StatusPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento implements Serializable {

	public PagamentoComBoleto(Integer id, StatusPagamento statusPagamento, Pedido pedido, Date dataPagamento, Date dataVencimento) {
		super(id, statusPagamento, pedido);
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;

	}

	private static final long serialVersionUID = 1L;

	public PagamentoComBoleto() {
		super();
	}

	private Date dataVencimento;
	private Date dataPagamento;

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
