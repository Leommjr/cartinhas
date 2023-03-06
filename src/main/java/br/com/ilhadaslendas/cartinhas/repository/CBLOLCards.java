package br.com.ilhadaslendas.cartinhas.repository;

import java.io.Serializable;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import br.com.ilhadaslendas.cartinhas.model.CBLOLCard;


public class CBLOLCards implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public CBLOLCards() {
		
	}
	
	public CBLOLCards(EntityManager manager) {
		this.manager = manager;
	}
	
	public CBLOLCard byId(Integer id) {
		return manager.find(CBLOLCard.class, id);
	}
	
	public List<CBLOLCard> find_name(String nome) {
		String jpql = " from CBLOLCard where nome like :nomeBuscado";
		TypedQuery<CBLOLCard> query = manager.createQuery(jpql, CBLOLCard.class);
		query.setParameter("nomeBuscado", nome + "%");
		return query.getResultList();
	}
	
	public List<CBLOLCard> getAll() {
		String jpql = " from CBLOLCard";
		TypedQuery<CBLOLCard> query = manager.createQuery(jpql, CBLOLCard.class);
		return query.getResultList();
	}

	public CBLOLCard save(CBLOLCard card) {
		return manager.merge(card);
	}
	
	public void remove(CBLOLCard card) {
		card = byId(card.getId());
		manager.remove(card);
	}
}
