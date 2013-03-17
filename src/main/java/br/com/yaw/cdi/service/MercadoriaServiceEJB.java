package br.com.yaw.cdi.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.yaw.cdi.model.Mercadoria;

@Stateless
public class MercadoriaServiceEJB extends AbstractPersistence<Mercadoria, Long> implements MercadoriaService {

	@PersistenceContext
    private EntityManager em;
	
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public MercadoriaServiceEJB() {
		super(Mercadoria.class);
	}
	
	
}
