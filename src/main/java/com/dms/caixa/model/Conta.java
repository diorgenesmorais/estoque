package com.dms.caixa.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "conta")
@Entity
@Table(name = "contas")
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "operadora_id")
	private Operadora operadora;
	@ManyToOne
	@JoinColumn(name = "forma_id")
	private Forma forma;
	@ManyToOne
	@JoinColumn(name = "bandeira_id")
	private Bandeira bandeira;
	@Column(name = "dias_venc")
	private int diasVencimento;
	@Column(name = "max_parc")
	private int maximoParcela;
	private BigDecimal taxa;
	@Column(name = "taxa_acima")
	private BigDecimal taxaAcima;

	@JsonIgnore
	@OneToMany(mappedBy = "conta")
	private List<CaixaDetalhe> contas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Operadora getOperadora() {
		return operadora;
	}

	public void setOperadora(Operadora operadora) {
		this.operadora = operadora;
	}

	public Forma getForma() {
		return forma;
	}

	public void setForma(Forma forma) {
		this.forma = forma;
	}

	public Bandeira getBandeira() {
		return bandeira;
	}

	public void setBandeira(Bandeira bandeira) {
		this.bandeira = bandeira;
	}

	public int getDiasVencimento() {
		return diasVencimento;
	}

	public void setDiasVencimento(int diasVencimento) {
		this.diasVencimento = diasVencimento;
	}

	public int getMaximoParcela() {
		return maximoParcela;
	}

	public void setMaximoParcela(int maximoParcela) {
		this.maximoParcela = maximoParcela;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}

	public BigDecimal getTaxaAcima() {
		return taxaAcima;
	}

	public void setTaxaAcima(BigDecimal taxaAcima) {
		this.taxaAcima = taxaAcima;
	}

	public List<CaixaDetalhe> getContas() {
		return contas;
	}

	public void setContas(List<CaixaDetalhe> contas) {
		this.contas = contas;
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
		Conta other = (Conta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
