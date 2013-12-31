package br.com.paiter.angelsmt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.paiter.core.dominio.DominioAtivoInativo.DOMINIO_ATIVO_INATIVO;
import br.com.paiter.core.dominio.DominioSexo.DOMINIO_SEXO;
import br.com.paiter.core.dominio.DominioSimNao.DOMINIO_SIM_NAO;
import br.com.paiter.core.entitys.AbstractEntity;

@Entity
@Table(name="modelo")
@SequenceGenerator(name="modelo_sqc", sequenceName = "modelo_sqc", allocationSize = 1)
public class Modelo implements AbstractEntity {
	
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="modelo_sqc")
	private Long idModelo;
	
	@NotNull	
	private String nomeModelo;
	
	@Enumerated(EnumType.STRING)
	private DOMINIO_SEXO flagSexo;
	
	@Embedded
	private Endereco endereco;
				
	
	@NotNull
	@Length(max=14)
	@Column(unique=true)
	private String cpf;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataNascimento;
	
	
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;	
	
	@NotNull
	private DOMINIO_SIM_NAO deleted;
	
	@Version
	private Integer version;
	
	@Enumerated(EnumType.STRING)
	private DOMINIO_ATIVO_INATIVO flagAtivoInativo;
	
	
	@Override
	public Long getId() {
		return this.idModelo;
	}

	public Long getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(Long idModelo) {
		this.idModelo = idModelo;
	}

	public String getNomeModelo() {
		return nomeModelo;
	}

	public void setNomeModelo(String nomeModelo) {
		this.nomeModelo = nomeModelo;
	}

	public DOMINIO_SEXO getFlagSexo() {
		return flagSexo;
	}

	public void setFlagSexo(DOMINIO_SEXO flagSexo) {
		this.flagSexo = flagSexo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public DOMINIO_SIM_NAO getDeleted() {
		return deleted;
	}

	public void setDeleted(DOMINIO_SIM_NAO deleted) {
		this.deleted = deleted;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public DOMINIO_ATIVO_INATIVO getFlagAtivoInativo() {
		return flagAtivoInativo;
	}

	public void setFlagAtivoInativo(DOMINIO_ATIVO_INATIVO flagAtivoInativo) {
		this.flagAtivoInativo = flagAtivoInativo;
	}


}
