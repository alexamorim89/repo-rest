package br.com.local.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "cliente")
@XmlRootElement
public class Cliente implements Serializable {

	/**
	 * 
	 */
	
	
	/* ------------------------------------PROPRIEDADES ESTATICAS----------------------------------------*/
	private static final long serialVersionUID = 653316053889985511L;

	
	
	
	
	/* ------------------------------------PROPRIEDADES-------------------------------------------------*/
	private Long 	id;
	private String  nome;
	private String  cpf;
	private String  endereco;
	private String  numero;
	private String  bairro;
	private String  cidade;
	private String  uf;
	private Integer cep;
	private String  email;
	private Date    dataNascimento;
	private Date 	dataCadastramento;
	private Date    ultimaAtualizacaoReg;
	
	
	
	
	/* ------------------------------------CONSTRUTORES------------------------------------------------*/
	public Cliente() {
		// TODO Auto-generated constructor stub
	}	
	
	
	public Cliente(Long id, String nome, String cpf, String endereco, String numero, String bairro, String cidade,
			String uf, Integer cep, String email, Date dataNascimento, Date dataCadastramento,
			Date ultimaAtualizacaoReg) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.dataCadastramento = dataCadastramento;
		this.ultimaAtualizacaoReg = ultimaAtualizacaoReg;
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
	
	@Column(name = "cpf")
	public String getCpf() {
		return cpf;
	}	
	
	@Column(name = "endereco")
	public String getEndereco() {
		return endereco;
	}	
	
	@Column(name = "numero")
	public String getNumero() {
		return numero;
	}	
	
	@Column(name = "bairro")
	public String getBairro() {
		return bairro;
	}	
	
	@Column(name = "cidade")
	public String getCidade() {
		return cidade;
	}	
	
	@Column(name = "uf")
	public String getUf() {
		return uf;
	}	
	
	@Column(name = "cep")
	public Integer getCep() {
		return cep;
	}	
	
	@Column(name = "email")
	public String getEmail() {
		return email;
	}	
	
	@Column(name = "data_nascimento")
	public Date getDataNascimento() {
		return dataNascimento;
	}	
	
	@Column(name = "data_cadastramento")
	public Date getDataCadastramento() {
		return dataCadastramento;
	}	
	
	@Column(name = "ultima_atualizacao_reg")
	public Date getUltimaAtualizacaoReg() {
		return ultimaAtualizacaoReg;
	}
	
	
	
	
	
	
	/* ------------------------------------SETS------------------------------------------------------*/
	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public void setUf(String uf) {
		this.uf = uf;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setDataCadastramento(Date dataCadastramento) {
		this.dataCadastramento = dataCadastramento;
	}

	public void setUltimaAtualizacaoReg(Date ultimaAtualizacaoReg) {
		this.ultimaAtualizacaoReg = ultimaAtualizacaoReg;
	}




	
	
	/* ------------------------------------HASHCODE E EQUALS---------------------------------------*/
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
	
	/* ------------------------------------TO STRING----------------------------------------------*/
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco + ", numero=" + numero
				+ ", bairro=" + bairro + ", cidade=" + cidade + ", uf=" + uf + ", cep=" + cep + ", email=" + email
				+ ", dataNascimento=" + dataNascimento + ", dataCadastramento=" + dataCadastramento
				+ ", ultimaAtualizacaoReg=" + ultimaAtualizacaoReg + "]";
	}
	










	
	
	
	
	
	
	
	
	

}
