package br.com.paiter.angelsmt.action;

import static javax.faces.context.FacesContext.getCurrentInstance;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.paiter.angelsmt.entity.Modelo;
import br.com.paiter.angelsmt.service.ModeloService;
import br.com.paiter.core.dominio.DominioSimNao.DOMINIO_SIM_NAO;

@Named
@RequestScoped
public class ModeloMB implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private ModeloService modeloService;
	
	@Inject
	private Modelo modelo;
	
	private Long idSelecionado;
	
	private List<Modelo> modelos;
	
	public ModeloMB() {
	}

	public ModeloService getModeloService() {
		return modeloService;
	}

	public void setModeloService(ModeloService modeloService) {
		this.modeloService = modeloService;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Long getIdSelecionado() {
		return idSelecionado;
	}

	public void setIdSelecionado(Long idSelecionado) {
		this.idSelecionado = idSelecionado;
	}

	public List<Modelo> getModelos() {
		if (modelos == null) {
			modelos = modeloService.findAll();
		}
		
		return modelos;
	}
	
	
	public void editar() {
		if (idSelecionado == null) {
			return;
		}
		modelo = modeloService.find(idSelecionado);
		//log.debug("Pronto pra editar");
	}
	
	public String salvar() {
		try {
			System.out.println("modeloService: " + modeloService);
			validateSalvar();
			modeloService.save(modelo);
		} catch(Exception ex) {
			//log.error("Erro ao salvar mercadoria.", ex);
			addMessage(getMessageFromI18N("msg.erro.salvar.modelo"), ex.getMessage());
			return "";
		}
		//log.debug("Salvour mercadoria "+mercadoria.getId());
		return "listaModelos";
	}
	
	private void validateSalvar() {
		if(modelo.getIdModelo()!= null){
			Modelo modeloLocal = modeloService.find(modelo.getIdModelo());
			modelo.setDataCadastro(modeloLocal.getDataCadastro());
			modelo.setDeleted(modeloLocal.getDeleted());
			modelo.setVersion(modeloLocal.getVersion());
		}
		
		if (modelo.getDeleted() == null){
			modelo.setDeleted(DOMINIO_SIM_NAO.NAO);
		}
		if(modelo.getDataCadastro() == null){
			modelo.setDataCadastro(new Date());
		}
		
	}

	public String remover() {
		try {
			modeloService.remove(modelo);
		} catch(Exception ex) {
			//log.error("Erro ao remover mercadoria.", ex);
			addMessage(getMessageFromI18N("msg.erro.remover.modelo"), ex.getMessage());
			return "";
		}
		//log.debug("Removeu mercadoria "+mercadoria.getId());
		return "listaModelos";
	}
	
	/**
	 * @param key
	 * @return Recupera a mensagem do arquivo properties <code>ResourceBundle</code>.
	 */
	private String getMessageFromI18N(String key) {
		ResourceBundle bundle = ResourceBundle.getBundle("messages_labels", getCurrentInstance().getViewRoot().getLocale());
		return bundle.getString(key);
	}
	
	/**
	 * Adiciona um mensagem no contexto do Faces (<code>FacesContext</code>).
	 * @param summary
	 * @param detail
	 */
	private void addMessage(String summary, String detail) {
		getCurrentInstance().addMessage(null, new FacesMessage(summary, summary.concat("<br/>").concat(detail)));
	}
	

	

}
