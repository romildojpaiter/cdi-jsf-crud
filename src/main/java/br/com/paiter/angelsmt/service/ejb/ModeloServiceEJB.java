package br.com.paiter.angelsmt.service.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.paiter.angelsmt.entity.Modelo;
import br.com.paiter.angelsmt.service.AbstractPersistence;
import br.com.paiter.angelsmt.service.ModeloService;

@Stateless
public class ModeloServiceEJB extends AbstractPersistence<Modelo, Long>
		implements ModeloService {

	@PersistenceContext
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public ModeloServiceEJB() {
		super(Modelo.class);
	}

}
