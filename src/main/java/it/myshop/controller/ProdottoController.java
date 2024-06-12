package it.myshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.myshop.dao.ProdottoDao;
import it.myshop.model.Categoria;
import it.myshop.model.Prodotto;

@Controller
@RequestMapping("/Prodotto")
public class ProdottoController {

	@Autowired
	private ProdottoDao prodottoService;
	
	@GetMapping("/add")
	public String add() {
		
		Categoria c = new  Categoria();
		c.setId(1);
		
		prodottoService.add(new Prodotto(0, "Samsung", c, 10, "pollici"));
		
		return "welcome";
	}
	
	@GetMapping("update")
	public String update() {
		
		Categoria c = new  Categoria();
		c.setId(1);
		
		prodottoService.update(new Prodotto(1, "LG", c, 15, "pollici"));
		
		return "welcome";
	}
	
	@GetMapping("/delete")
	public String delete() {
		
		prodottoService.delete(1);
		
		return "welcome";	
	}
	
	@GetMapping("/count")
	public String count() {
		
		System.out.println(prodottoService.count());
		
		return "welcome";
	}
	
	@GetMapping("/countByCategory")
	public String countByCategory() {
		
		System.out.println(prodottoService.countByCategory(2));
		
		return "welcome";
	}
	
	@GetMapping("/countByCategoryAndPrice")
	public String countByCategoryAndPrice() {
		
		System.out.println(prodottoService.countByCategoryAndPrice(2,50));
		
		return "welcome";
	}
	
}
