package br.com.ilhadaslendas.cartinhas.controller;

import javax.inject.Inject;

import javax.inject.Named;
import java.util.List;
import br.com.ilhadaslendas.cartinhas.model.CBLOLCard;
import br.com.ilhadaslendas.cartinhas.services.CBLOLCardsService;
import javax.enterprise.context.RequestScoped;



@Named("cblol")
@RequestScoped
public class CBLOLCardBean {
	
	@Inject
	private CBLOLCardsService service;
	
	private List<CBLOLCard> cards;
	
	public List<CBLOLCard> getCards() {
    	return cards;
    }
	
	public void allCards() {
		cards = service.getAll();
	}

}
