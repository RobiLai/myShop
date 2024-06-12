package it.myshop.dao;

import it.myshop.model.Prodotto;

public interface ProdottoDao {

	public void add(Prodotto prodotto);
	
	public void update(Prodotto prodotto);
	
	public void delete(int id);
	
	public int count();
	
	public int countByCategory(int id);
	
	public int countByCategoryAndPrice(int id, int price);
	
}
