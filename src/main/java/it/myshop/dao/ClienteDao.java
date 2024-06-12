package it.myshop.dao;

import it.myshop.model.Cliente;

public interface ClienteDao{

	public void add(Cliente cliente);
	
	public void update(Cliente cliente);
	
	public void delete(int id);
	
	public int count();
	
}
