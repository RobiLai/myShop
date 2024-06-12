package it.myshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.myshop.dao.ClienteDao;
import it.myshop.model.Cliente;

@Controller
@RequestMapping("/Cliente")
public class ClienteController {
	
	@Autowired
	private ClienteDao clienteService;
	
	
	@GetMapping("/add")
	public String add() {
		
		clienteService.add(new Cliente(0, "Mario", "Rossi", "abc123", "abc123@gmail.com", "123", "Mariuccio", "password"));
		
		return "welcome";
	}
	
	@GetMapping("/update")
	public String update() {
		
		clienteService.update(new Cliente(1, "MarioNuovo", "Rossi", "abc123", "abc123@gmail.com", "123", "MariuccioNuovo", "password"));
		
		return "welcome";
	}
	
	@GetMapping("/delete")
	public String delete() {
		
		clienteService.delete(1);
		
		return "welcome";	
	}
	
	@GetMapping("/count")
	public String count() {
		
		System.out.println(clienteService.count());
		
		return "welcome";
	}

}
