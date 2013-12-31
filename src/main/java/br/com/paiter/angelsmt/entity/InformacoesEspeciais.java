package br.com.paiter.angelsmt.entity;

import javax.persistence.Embeddable;

import org.hibernate.validator.constraints.Email;

@Embeddable
public class InformacoesEspeciais {
	
	@Email
	private String email;
	
	private String facoPerfil;
	
	private String acompanho;
	
	private String atendo;
	
	private String especialidades;

	public String getFacoPerfil() {
		return facoPerfil;
	}

	public void setFacoPerfil(String facoPerfil) {
		this.facoPerfil = facoPerfil;
	}

	public String getAcompanho() {
		return acompanho;
	}

	public void setAcompanho(String acompanho) {
		this.acompanho = acompanho;
	}

	public String getAtendo() {
		return atendo;
	}

	public void setAtendo(String atendo) {
		this.atendo = atendo;
	}

	public String getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(String especialidades) {
		this.especialidades = especialidades;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
