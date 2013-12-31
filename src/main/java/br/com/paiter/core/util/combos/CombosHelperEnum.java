package br.com.paiter.core.util.combos;

import javax.enterprise.inject.Produces;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

import br.com.paiter.core.dominio.DominioAtivoInativo.DOMINIO_ATIVO_INATIVO;
import br.com.paiter.core.dominio.DominioSexo.DOMINIO_SEXO;
import br.com.paiter.core.dominio.DominioSimNao.DOMINIO_SIM_NAO;

@Named
@ApplicationScoped
public class CombosHelperEnum {
	
	DOMINIO_ATIVO_INATIVO[] dominioAtivoInativo;
	
	DOMINIO_SIM_NAO[] dominioSimNao;
	
	DOMINIO_SEXO[] dominioSexo;

	@Produces
	public DOMINIO_ATIVO_INATIVO[] listarDominioAtivoInativoCombo() {
		this.dominioAtivoInativo =  DOMINIO_ATIVO_INATIVO.values();
		return dominioAtivoInativo;
	}

	@Produces
	public DOMINIO_SIM_NAO[] listarDominioSimNaoCombo() {
		this.dominioSimNao =  DOMINIO_SIM_NAO.values();
		return dominioSimNao;
	}

	@Produces
	public DOMINIO_SEXO[] listarDominioSexoCombo() {
		this.dominioSexo =  DOMINIO_SEXO.values();
		return dominioSexo;
	}

}
