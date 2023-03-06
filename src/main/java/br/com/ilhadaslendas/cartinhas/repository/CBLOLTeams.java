package br.com.ilhadaslendas.cartinhas.repository;

import java.io.Serializable;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import br.com.ilhadaslendas.cartinhas.model.CBLOLTeam;


public class CBLOLTeams implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public CBLOLTeams() {
		
	}
	
	public CBLOLTeams(EntityManager manager) {
		this.manager = manager;
	}
	
	public CBLOLTeam byId(Integer id) {
		return manager.find(CBLOLTeam.class, id);
	}
	
	public List<CBLOLTeam> find_name(String nome) {
		String jpql = " from CBLOLTeam where nome like :nomeBuscado";
		TypedQuery<CBLOLTeam> query = manager.createQuery(jpql, CBLOLTeam.class);
		query.setParameter("nomeBuscado", nome + "%");
		return query.getResultList();
	}
	
	public List<CBLOLTeam> getAll() {
		String jpql = " from CBLOLTeam";
		TypedQuery<CBLOLTeam> query = manager.createQuery(jpql, CBLOLTeam.class);
		return query.getResultList();
	}

	public CBLOLTeam save(CBLOLTeam card) {
		return manager.merge(card);
	}
	
	public void remove(CBLOLTeam card) {
		card = byId(card.getId());
		manager.remove(card);
	}
}
