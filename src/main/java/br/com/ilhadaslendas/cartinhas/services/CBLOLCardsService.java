package br.com.ilhadaslendas.cartinhas.services;

import java.io.Serializable;

import java.util.List;

import br.com.ilhadaslendas.cartinhas.repository.CBLOLCards;
import br.com.ilhadaslendas.cartinhas.utils.Transacional;
import br.com.ilhadaslendas.cartinhas.model.CBLOLCard;
import javax.inject.Inject;

public class CBLOLCardsService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CBLOLCards cartinhas;
	
	public CBLOLCard byId(Integer id) {
		return cartinhas.byId(id);
	}
	
	public List<CBLOLCard> find_name(String nome) {
		return cartinhas.find_name(nome);
	}
	
	public List<CBLOLCard> getAll() {
		return cartinhas.getAll();
	}
	
	@Transacional
	public CBLOLCard save(CBLOLCard card) {
		return cartinhas.save(card);
	}
	
	@Transacional
	public void remove(CBLOLCard card) {
		cartinhas.remove(card);
	}
	

}
