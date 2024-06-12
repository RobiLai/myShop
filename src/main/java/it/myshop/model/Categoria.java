package it.myshop.model;

public class Categoria {

	public Categoria() {
		super();
	}
	
	public Categoria(int id, String nome, String descrizione, Categoria categoriaPadre) {
		super();
		this.id = id;
		this.nome = nome;
		this.descrizione = descrizione;
		this.categoriaPadre = categoriaPadre;
	}
	
	private int id;
	private String nome;
	private String descrizione;
	private Categoria categoriaPadre;
	
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
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Categoria getCategoriaPadre() {
		return categoriaPadre;
	}
	public void setCategoriaPadre(Categoria categoriaPadre) {
		this.categoriaPadre = categoriaPadre;
	}
	
	
	
}
