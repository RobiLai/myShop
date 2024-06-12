package it.myshop.dao.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import it.myshop.dao.ProdottoDao;
import it.myshop.model.Prodotto;

public class ProdottoDaoImpl implements ProdottoDao{

	private JdbcTemplate conn;

	public ProdottoDaoImpl(DataSource ds) {
		conn = new JdbcTemplate(ds);
	}

	@Override
	public void add(Prodotto prodotto) {
		
		String sql = "INSERT INTO prodotto (nome, id_categoria, descrizione, prezzo_unitario,unita_misura)"
					+ "VALUES (?,?,?,?,?)";
		
		conn.update(sql, prodotto.getNome(), prodotto.getCategoria().getId(), 
						 prodotto.getCategoria().getDescrizione(),
						 prodotto.getPrezzo(), prodotto.getUnitaMisura());
		
	}
	
	public void update(Prodotto prodotto) {
		
		String sql = "UPDATE prodotto SET nome = ?, id_categoria = ?, descrizione = ?, "
				   + " prezzo_unitario = ?, unita_misura = ? where id=?";
		
		conn.update(sql, prodotto.getNome(), prodotto.getCategoria().getId(), 
				 		 prodotto.getCategoria().getDescrizione(),
				 		 prodotto.getPrezzo(), prodotto.getUnitaMisura(), prodotto.getId());
		
		
		
	}

	@Override
	public void delete(int id) {
		
		String sql = "DELETE FROM prodotto where id=?";
		
		conn.update(sql, id);
		
	}
	
	@Override
	public int count() {
		
		String sql = "SELECT count(id) FROM prodotto";
		
		int count = conn.queryForObject(sql, Integer.class);
		
		return count;
	}

	@Override
	public int countByCategory(int id) {
		String sql = "SELECT count(id) FROM prodotto where id_categoria = ?";
		
		int count = conn.queryForObject(sql, Integer.class, id);//query,oggetto ritornato,parametro
		
		return count;
	}

	@Override
	public int countByCategoryAndPrice(int id, int price) {
		String sql = "SELECT count(id) FROM prodotto where id_categoria = ? and prezzo_unitario > ?";
		
		int count = conn.queryForObject(sql, Integer.class, id, price);//query,oggetto ritornato,parametro 1, parametro 2
		
		return count;
	}
	
	
	
}
