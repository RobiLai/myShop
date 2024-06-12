package it.myshop.dao.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import it.myshop.dao.ClienteDao;
import it.myshop.model.Categoria;
import it.myshop.model.Cliente;

public class ClienteDaoImpl implements ClienteDao{

	private JdbcTemplate conn;

	public ClienteDaoImpl(DataSource ds) {
		conn = new JdbcTemplate(ds);
				}
	
	@Override
	public void add(Cliente cliente) {
		
		String sql = "INSERT INTO cliente (nome, cognome, codice_fiscale, email, telefono, username, password)"
				   + "VALUES(?,?,?,?,?,?,?)";
		
		conn.update(sql, cliente.getNome(), cliente.getCognome(), cliente.getCodiceFiscale(),
					     cliente.getEmail(), cliente.getTelefono(), cliente.getUsername(), 
					     cliente.getPassword());
		
	}	
	
	public void update(Cliente cliente) {
		
		String sql = "UPDATE cliente SET nome = ?, cognome= ?, codice_fiscale= ?, email= ?,"
				   + " telefono = ?, username = ? "
				   + " WHERE id= ?";
		
		conn.update(sql, cliente.getNome(), cliente.getCognome(), cliente.getCodiceFiscale(),
			     cliente.getEmail(), cliente.getTelefono(), cliente.getUsername(), 
			     cliente.getId());
		
	}

	@Override
	public void delete(int id) {
		
		String sql = "DELETE FROM cliente where id=?";
		
		conn.update(sql, id);
		
	}
	
	@Override
	public int count() {
		
		String sql = "SELECT count(id) FROM cliente";
		
		int count = conn.queryForObject(sql, Integer.class);
		
		return count;
	}
	
	
}
