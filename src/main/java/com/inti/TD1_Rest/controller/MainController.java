package com.inti.TD1_Rest.controller;

import java.util.List;

import com.inti.TD1_Rest.model.Utilisateur;
import com.inti.TD1_Rest.repository.UtilisateurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController 
{
	@Autowired
	UtilisateurRepository utilisateurRepository;

	@GetMapping("/hello")
	public String hello()
	{
	return "Hello World!";
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<Utilisateur> getAllUser()
	{
		return utilisateurRepository.findAll();
	}
	
	@PostMapping("/saveUser")
	public String saveUser()
	{
		Utilisateur u = new Utilisateur("login", "login");
		utilisateurRepository.save(u);
		return "user saved";
	}

}
