package br.com.ilhadaslendas.cartinhas.services;

import java.io.Serializable;

import java.util.List;

import br.com.ilhadaslendas.cartinhas.repository.CBLOLTeams;
import br.com.ilhadaslendas.cartinhas.utils.Transacional;
import br.com.ilhadaslendas.cartinhas.model.CBLOLTeam;

import javax.inject.Inject;

public class CBLOLTeamsService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CBLOLTeams cartinhas;
	
	public CBLOLTeam byId(Integer id) {
		return cartinhas.byId(id);
	}
	
	public List<CBLOLTeam> find_name(String nome) {
		return cartinhas.find_name(nome);
	}
	
	public List<CBLOLTeam> getAll() {
		return cartinhas.getAll();
	}
	
	@Transacional
	public CBLOLTeam save(CBLOLTeam card) {
		return cartinhas.save(card);
	}
	
	@Transacional
	public void remove(CBLOLTeam card) {
		cartinhas.remove(card);
	}
	

}
