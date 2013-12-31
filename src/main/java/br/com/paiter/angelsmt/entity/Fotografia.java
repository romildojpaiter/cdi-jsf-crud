package br.com.paiter.angelsmt.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import br.com.paiter.core.dominio.DominioAtivoInativo.DOMINIO_ATIVO_INATIVO;
import br.com.paiter.core.dominio.DominioSimNao.DOMINIO_SIM_NAO;
import br.com.paiter.core.entitys.AbstractEntity;

@Entity
@Table(name="fotografia")
@SequenceGenerator(name="fotografia_sqc", sequenceName = "fotografia_sqc", allocationSize = 1)
public class Fotografia implements AbstractEntity  {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="fotografia_sqc")
	private Long idFotografia;	
	
	
	private String descricao;
	
	@Lob
	@Column(length = 2147483647)
	@Basic(fetch = FetchType.LAZY)
	private byte[] fotografiaBinario;
	
	
	@NotNull
	private String contentType;
	
	@NotNull
	private long tamanho;
	
	
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;	
	
	@NotNull
	private DOMINIO_SIM_NAO deleted;
	
	@Version
	private Integer version;
	
	@Enumerated(EnumType.STRING)
	private DOMINIO_ATIVO_INATIVO flagAtivoInativo;	
	
	

	public Long getIdFotografia() {
		return idFotografia;
	}

	public void setIdFotografia(Long idFotografia) {
		this.idFotografia = idFotografia;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public byte[] getFotografiaBinario() {
		return fotografiaBinario;
	}

	public void setFotografiaBinario(byte[] fotografiaBinario) {
		this.fotografiaBinario = fotografiaBinario;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public long getTamanho() {
		return tamanho;
	}

	public void setTamanho(long tamanho) {
		this.tamanho = tamanho;
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

	@Override
	public Long getId() {
		return this.idFotografia;
	}
	
	
	
	

}

