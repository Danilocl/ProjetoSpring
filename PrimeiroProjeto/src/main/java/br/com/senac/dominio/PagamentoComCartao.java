package br.com.senac.dominio;

import java.io.Serializable;

import javax.persistence.Entity;

import br.com.senac.dominio.enums.StatusPagamento;

@Entity
public class PagamentoComCartao extends Pagamento implements Serializable {

	public PagamentoComCartao(Integer id, StatusPagamento statusPagamento, Pedido pedido, Integer numeroDaParcela) {
		super(id, statusPagamento, pedido);
		this.numeroDeparcelas = numeroDaParcela;
	}

	private static final long serialVersionUID = 1L;

	private Integer numeroDeparcelas;

	public Integer getNumeroDeparcelas() {
		return numeroDeparcelas;
	}

	public void setNumeroDeparcelas(Integer numeroDeparcelas) {
		this.numeroDeparcelas = numeroDeparcelas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
