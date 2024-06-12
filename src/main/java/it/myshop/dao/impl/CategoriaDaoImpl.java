package it.myshop.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import it.myshop.dao.CategoriaDao;
import it.myshop.model.Categoria;

public class CategoriaDaoImpl implements CategoriaDao{

	private JdbcTemplate conn;
	
	private final RowMapper<Categoria> categoriaMapper = (resulSet, rowNum) -> {
		
		Categoria categoria = new Categoria();
		
		categoria.setId(resulSet.getInt("id"));
		categoria.setNome(resulSet.getString("nome"));
		categoria.setDescrizione(resulSet.getString("descrizione"));
		
		int id_padre = resulSet.getInt("id_categoria_padre");
		
		if(id_padre > 0) {
			Categoria cp = new Categoria();
			cp.setId(id_padre);
			categoria.setCategoriaPadre(cp);
		}
		
		return categoria;	
	};

	public CategoriaDaoImpl(DataSource ds) {
		conn = new JdbcTemplate(ds);
	}

	@Override
	public void add(Categoria categoria) {
		
		String sql = "INSERT INTO categoria (nome, descrizione, id_categoria_padre)"
				   + "VALUES(?,?,?)";
		
		int categoriaPadre = 0;
		if(categoria.getCategoriaPadre() != null)
			categoriaPadre = categoria.getCategoriaPadre().getId();
		
		conn.update(sql, categoria.getNome(), categoria.getDescrizione(), categoriaPadre);
		
	}	
	
	public void update(Categoria categoria) {
		
		String sql = "UPDATE categoria set"
				   + " nome = ?"
				   + " descrizione = ?"
				   + " id_categoria_padre = ?"
				   + " id = ?";
		
		int categoriaPadre = 0;
		if(categoria.getCategoriaPadre() != null)
			categoriaPadre = categoria.getCategoriaPadre().getId();
		
		conn.update(sql, categoria.getNome(), categoria.getDescrizione(), categoria.getCategoriaPadre(), categoria.getId());
				
		
	}

	@Override
	public void delete(int id) {
		
		String sql = "DELETE FROM categoria where id=?";
		
		conn.update(sql, id);
		
	}

	@Override
	public int count() {
		
		String sql = "SELECT count(id) FROM categoria";
		
		int count = conn.queryForObject(sql, Integer.class);
		
		return count;
	}

	@Override
	public String getNome(int id) {
		String sql = "SELECT nome FROM categoria where id = ?";
		String nome = conn.queryForObject(sql, String.class, 2);
		
		return nome;
	}

	@Override
	public Categoria getCategoria(int id) {
		
		String sql = "SELECT id,nome,descrizione,id_categoria_padre FROM categoria where id = ?";
		
		Categoria categoria = conn.queryForObject(sql, categoriaMapper, id);
		
		return categoria;
	}

	@Override
	public List<Categoria> getCategorie() {
		
		String sql = "SELECT id,nome,descrizione,id_categoria_padre FROM categoria";
		
		return conn.query(sql, categoriaMapper);
	}
	
	
}
