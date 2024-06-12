package it.myshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.myshop.dao.CategoriaDao;
import it.myshop.model.Categoria;

@Controller
@RequestMapping("/Categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaDao categoriaService;
	
	@GetMapping("/add")
	public String add() {
		
		Categoria c = new Categoria(0, "TV", "Qui trovi le tue TV", null);
		
		categoriaService.add(c);
		
		return "welcome";
		
	}

	
	@GetMapping("/update")
	public String update() {
		
		Categoria c = new Categoria(1, "TV Nuove", "Qui trovi le tue nuove TV", null);
		
		categoriaService.update(c);
		
		return "welcome";
	}
	
	@GetMapping("/delete")
	public String delete() {
		
		categoriaService.delete(1);
		
		return "welcome";	
	}
	
	
	@GetMapping("/count")
	public String count() {
		
		System.out.println(categoriaService.count());
		
		return "welcome";
	}
	
	@GetMapping("/nomeCatgeoria")
	public String getNome() {
		
		System.out.println(categoriaService.getNome(2));
		
		return "welcome";
	}
	
	@GetMapping("/getCatgeoria")
	public String getCategoria() {
		
		Categoria c = categoriaService.getCategoria(2);
		
		System.out.println(c.getId());
		System.out.println(c.getNome());
		System.out.println(c.getDescrizione());
		
		return "welcome";
	}
	
	@GetMapping("/getCatgeorie")
	public String getCategorie() {
		
		List<Categoria> categoria = categoriaService.getCategorie();
		
		System.out.println(categoria.size());
		
		return "welcome";
	}
	
}
