package com.dms.caixa.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "v_contas")
public class VContas {

	@Id
	private Integer id;
	private String conta;
	@Column(name = "dias_venc")
	private int diasVencimento;
	@Column(name = "max_parc")
	private int maximoParcela;
	private BigDecimal taxa;
	@Column(name = "taxa_acima")
	private BigDecimal taxaAcima;

	public Integer getId() {
		return id;
	}

	public String getConta() {
		return conta;
	}

	public int getDiasVencimento() {
		return diasVencimento;
	}

	public int getMaximoParcela() {
		return maximoParcela;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public BigDecimal getTaxaAcima() {
		return taxaAcima;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VContas other = (VContas) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
