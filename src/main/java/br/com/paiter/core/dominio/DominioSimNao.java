package br.com.paiter.core.dominio;

import org.apache.commons.lang.StringUtils;

import br.com.paiter.core.dominio.inter.BaseDominioInterface;


public class DominioSimNao {
	
	public enum DOMINIO_SIM_NAO implements BaseDominioInterface<DOMINIO_SIM_NAO> {

		SIM("Sim"), 
		NAO("Não");

		private String descricao;
		private String longDesc;

		DOMINIO_SIM_NAO(String desc) {
			this.descricao = desc;
			this.longDesc = desc;
		}

		DOMINIO_SIM_NAO(String desc, String longDesc) {
			this.descricao = desc;
			this.longDesc = longDesc;
		}

		public DOMINIO_SIM_NAO valueOf(int ord) {
			return values()[ord];
		}

		public String toString() {
			return this.getName();
		}

		public String getLongDesc() {
			return (StringUtils.isBlank(this.longDesc)) ? this.descricao : this.longDesc;
		}

		public Integer getSize() {
			return values().length;
		}

		public boolean isValido(int cdItemDominio) {
			return (getSize() >= cdItemDominio) ? true : false;
		}

		public Integer getOrdinal() {
			return this.ordinal();
		}

		public String getDesc() {
			return this.descricao;
		}

		public String getName() {
			return this.name();
		}
	}

}
