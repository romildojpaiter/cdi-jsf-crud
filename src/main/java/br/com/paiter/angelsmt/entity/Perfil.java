package br.com.paiter.angelsmt.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ForeignKey;

import br.com.paiter.core.dominio.DominioAtivoInativo.DOMINIO_ATIVO_INATIVO;
import br.com.paiter.core.dominio.DominioSimNao.DOMINIO_SIM_NAO;
import br.com.paiter.core.entitys.AbstractEntity;

@Entity
@Table(name="perfil")
@SequenceGenerator(name="perfil_sqc", sequenceName = "perfil_sqc", allocationSize = 1)
public class Perfil implements AbstractEntity {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="perfil_sqc")
	private Long idPerfil;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idmodelo")
	@ForeignKey(name = "fk_perfil_modelo")
	@NotNull
	private Modelo modelo;
	
	
	private String nomePerfil;
	
	private String telefone;
	
	private String cidade;
	
	private String idade;
	
	private String corOlhos;
	
	private String altura;
	
	private String peso;
	
	private String manequim;
	
	private Integer tamanhoPes;
	
	private String horarioAtendimento;

	@Embedded
	private InformacoesEspeciais informacoesEspeciais;

	@Enumerated(EnumType.STRING)
	private DOMINIO_SIM_NAO flagDisponivelViagens;
	
	@Enumerated(EnumType.STRING)
	private DOMINIO_SIM_NAO flagPermiteFumar;	
	
	
    @OneToMany(cascade=javax.persistence.CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name="perfil_fotografia",
		joinColumns=@JoinColumn(name="idPerfil"),
		inverseJoinColumns=@JoinColumn(name="idFotografia", unique=false))
	private Set<Fotografia> fotografias;
    
    
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;	
	
	@NotNull
	private DOMINIO_SIM_NAO deleted;
	
	@Version
	private Integer version;
	
	@Enumerated(EnumType.STRING)
	private DOMINIO_ATIVO_INATIVO flagAtivoInativo;    
	

	public Long getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNomePerfil() {
		return nomePerfil;
	}

	public void setNomePerfil(String nomePerfil) {
		this.nomePerfil = nomePerfil;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getCorOlhos() {
		return corOlhos;
	}

	public void setCorOlhos(String corOlhos) {
		this.corOlhos = corOlhos;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getManequim() {
		return manequim;
	}

	public void setManequim(String manequim) {
		this.manequim = manequim;
	}

	public Integer getTamanhoPes() {
		return tamanhoPes;
	}

	public void setTamanhoPes(Integer tamanhoPes) {
		this.tamanhoPes = tamanhoPes;
	}

	public DOMINIO_SIM_NAO getFlagDisponivelViagens() {
		return flagDisponivelViagens;
	}

	public void setFlagDisponivelViagens(DOMINIO_SIM_NAO flagDisponivelViagens) {
		this.flagDisponivelViagens = flagDisponivelViagens;
	}

	public DOMINIO_SIM_NAO getFlagPermiteFumar() {
		return flagPermiteFumar;
	}

	public void setFlagPermiteFumar(DOMINIO_SIM_NAO flagPermiteFumar) {
		this.flagPermiteFumar = flagPermiteFumar;
	}

	public String getHorarioAtendimento() {
		return horarioAtendimento;
	}

	public void setHorarioAtendimento(String horarioAtendimento) {
		this.horarioAtendimento = horarioAtendimento;
	}

	public InformacoesEspeciais getInformacoesEspeciais() {
		return informacoesEspeciais;
	}

	public void setInformacoesEspeciais(InformacoesEspeciais informacoesEspeciais) {
		this.informacoesEspeciais = informacoesEspeciais;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idPerfil == null) ? 0 : idPerfil.hashCode());
		result = prime * result
				+ ((nomePerfil == null) ? 0 : nomePerfil.hashCode());
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
		Perfil other = (Perfil) obj;
		if (idPerfil == null) {
			if (other.idPerfil != null)
				return false;
		} else if (!idPerfil.equals(other.idPerfil))
			return false;
		if (nomePerfil == null) {
			if (other.nomePerfil != null)
				return false;
		} else if (!nomePerfil.equals(other.nomePerfil))
			return false;
		return true;
	}

	@Override
	public Long getId() {
		return this.idPerfil;
	}

	public Set<Fotografia> getFotografias() {
		return fotografias;
	}

	public void setFotografias(Set<Fotografia> fotografias) {
		this.fotografias = fotografias;
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

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	

}
