package it.myshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.myshop.model.Prodotto;

@Controller
@RequestMapping("/")
public class WelcomeController {

	@GetMapping("/")
	public String welcome(ModelMap model) {
		
		model.addAttribute("message", "Ciao, benvenuto nel mio e-commerce");
		
		return "welcome";
		
	}
	
	@GetMapping("/myPage")
	public String myPage(ModelMap model) {
		
		model.addAttribute("user", "Mario");
		model.addAttribute("messaggi", 5);
		
		List<String> codici = new ArrayList<>();
		
		codici.add("1");
		codici.add("2");
		codici.add("3");
		
		model.addAttribute("codici", codici);
		
//		List<Prodotto> prodotti = new ArrayList<>();
//		
//		prodotti.add(new Prodotto(1l, "PC", "Elettronica", 100l));
//		prodotti.add(new Prodotto(2l, "carta", "Altro", 10l));
		
		return "myPage";
		
	}
//	
//	@GetMapping("/prodotto")
//	public String demoProdotto(ModelMap model) {
//		Prodotto prodotto = new Prodotto();
//		prodotto.setId(1l);
//		prodotto.setNome("Telefono");
//		prodotto.setCategoria("Elettronica");
//		prodotto.setPrezzo(100l);
//		
//		model.addAttribute("prodotto", prodotto);
//		
//		return "demoProdotto";
//	}
	
}
