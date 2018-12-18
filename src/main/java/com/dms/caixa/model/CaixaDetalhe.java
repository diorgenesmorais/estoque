package com.dms.caixa.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "caixa_detalhes")
public class CaixaDetalhe implements Serializable {

	private static final long serialVersionUID = 4301484435479985537L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "caixa_id")
	private CaixaContingencia caixa;
	@ManyToOne
	@JoinColumn(name = "conta_id")
	private Conta conta;
	private BigDecimal pago = BigDecimal.ZERO;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CaixaContingencia getCaixa() {
		return caixa;
	}

	public void setCaixa(CaixaContingencia caixa) {
		this.caixa = caixa;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public BigDecimal getPago() {
		return pago;
	}

	public void setPago(BigDecimal pago) {
		this.pago = pago;
	}

}
