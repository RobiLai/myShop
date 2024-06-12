package it.myshop.model;

public class Prodotto {

	public Prodotto() {
		super();

	}
	public Prodotto(int id, String nome, Categoria categoria, int prezzo, String unitaMisura) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.prezzoUnitario = prezzo;
		this.unitaMisura = unitaMisura;
	}
	private int id;
	private String nome;
	private Categoria categoria;
	private int prezzoUnitario;
	private String unitaMisura;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public int getPrezzo() {
		return prezzoUnitario;
	}
	public void setPrezzo(int prezzo) {
		this.prezzoUnitario = prezzo;
	}
	public String getUnitaMisura() {
		return unitaMisura;
	}
	public void setUnitaMisura(String unitaMisura) {
		this.unitaMisura = unitaMisura;
	}
	
}
