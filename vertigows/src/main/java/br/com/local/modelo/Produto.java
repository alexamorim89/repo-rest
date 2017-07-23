package br.com.local.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "produto")
@XmlRootElement
public class Produto implements Serializable {

	/**
	 * 
	 */
	
	
	
	
	/* ------------------------------------PROPRIEDADES ESTATICAS----------------------------------------*/
	private static final long serialVersionUID = 8074207652399258954L;
	
	
	
	
	/* ------------------------------------PROPRIEDADES-------------------------------------------------*/
	private Long 	 id;
	private String 	 nome;
	private Double   valorCusto;
	private Double   valorVenda;
	private Integer  quantidadeEstoque;
	
	
	
	
	/* ------------------------------------CONSTRUTORES------------------------------------------------*/
	public Produto() {
		// TODO Auto-generated constructor stub
	}


	public Produto(long id, String nome, Double valorCusto, Double valorVenda, Integer quantidadeEstoque) {
		this.id = id;
		this.nome = nome;
		this.valorCusto = valorCusto;
		this.valorVenda = valorVenda;
		this.quantidadeEstoque = quantidadeEstoque;
	}


	
	
	
	/* ------------------------------------METODOS--------------------------------------------------*/
	/* ------------------------------------GETS-------------------------------------------------------*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}	
	
	@Column(name = "nome")
	public String getNome() {
		return nome;
	}	
	
	@Column(name= "valor_custo")
	public Double getValorCusto() {
		return valorCusto;
	}	
	
	@Column(name = "valor_venda")
	public Double getValorVenda() {
		return valorVenda;
	}	
	
	@Column(name = "qtde_estoque")
	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}



	
	
	
	
	/* ------------------------------------SETS------------------------------------------------------*/
	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setValorCusto(Double valorCusto) {
		this.valorCusto = valorCusto;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	
	
	
	
	
	/* ------------------------------------HASHCODE E EQUALS---------------------------------------*/	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Produto other = (Produto) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	
	
	
	/* ------------------------------------TO STRING----------------------------------------------*/
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", valorCusto=" + valorCusto + ", valorVenda=" + valorVenda
				+ ", quantidadeEstoque=" + quantidadeEstoque + "]";
	}
	






	

}
