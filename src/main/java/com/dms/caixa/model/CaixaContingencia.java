package com.dms.caixa.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "caixa_contingencia")
public class CaixaContingencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "usuario_id")
	private Integer usuario;
	private Integer pedido;
	private BigDecimal valor = BigDecimal.ZERO;

	@JsonIgnore
	@OneToMany(mappedBy = "caixa", fetch = FetchType.EAGER)
	private List<CaixaDetalhe> caixas = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public Integer getPedido() {
		return pedido;
	}

	public void setPedido(Integer pedido) {
		this.pedido = pedido;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public List<CaixaDetalhe> getCaixas() {
		return caixas;
	}

	public void setCaixas(List<CaixaDetalhe> caixas) {
		this.caixas = caixas;
	}

	public BigDecimal getTotalPago() {
		return caixas.stream().map(CaixaDetalhe::getPago).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
	}

	public BigDecimal getTroco() {
		return getTotalPago().subtract(getValor());
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
		CaixaContingencia other = (CaixaContingencia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
