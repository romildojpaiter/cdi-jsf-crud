package br.com.paiter.angelsmt.service.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.paiter.angelsmt.entity.Mercadoria;
import br.com.paiter.angelsmt.service.AbstractPersistence;
import br.com.paiter.angelsmt.service.MercadoriaService;

/**
 * Componente <code>EJB</code> que implementa as operações de negócio da entidade <code>Mercadoria</code>.
 * 
 * <p>Herda <code>AbstractPersistence</code> para resolver as operações básicas da persistência de <code>Mercadoria</code>.</p>
 * 
 * @see br.com.paiter.angelsmt.service.MercadoriaService
 * @author YaW Tecnologia
 */
@Stateless
public class MercadoriaServiceEJB extends AbstractPersistence<Mercadoria, Long> 
	implements MercadoriaService {

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
