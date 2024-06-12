package it.myshop.dao;

import java.util.List;

import it.myshop.model.Categoria;

public interface CategoriaDao {

	public void add(Categoria categoria);
	
	public void update(Categoria categoria);
	
	public void delete(int id);
	
	public int count();
	
	public String getNome(int id);
	
	public Categoria getCategoria(int id);
	
	public List<Categoria> getCategorie();
	
}
