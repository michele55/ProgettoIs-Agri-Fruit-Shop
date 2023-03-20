package GestioneCarrello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import GestioneProdotti.prodotto;

public class Carrello<T> {
	List<T> items;

	float valorecarrello;
	


	public Carrello() {
		items = new ArrayList<T>();
		valorecarrello=0;
	}
	

	public Carrello(List<T> items, float valorecarrello) {
		super();
		this.items = items;
		this.valorecarrello = valorecarrello;
	}


	public float getValorecarrello() {
		return valorecarrello;
	}

	public void setValorecarrello(float valorecarrello) {
		this.valorecarrello = valorecarrello;
	}

	public int addOggetto(T item) {
		
		items.add(item);
	
		return items.size()-1;
	}

	public void deleteOggetto(String item) {
	

	for(int i=0;i<items.size();i++) {
		if(items.get(i).toString().contains(item)) {
			items.remove(i);
		}
	}
	//items.remove(t);
		/*
		 * for(T it: items) { 
		 * 	if(it.equals(item)) { 
		 * 		items.remove(it); 
		 * 		break; } }
		 */
	}

	public List<T> getOggetto() {
		return items;
	}
	public int getOggetto(String obj) {
		int j = 0;
		for(int i=0;i<items.size();i++) {
			if(items.get(i).toString().contains(obj)) {
				j=i;;
			}
		}
		
		return j;
		
	}
	public void deleteOggetto() {
		items.clear();
	}
}
