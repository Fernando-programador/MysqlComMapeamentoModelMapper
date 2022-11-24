package com.mysql.controllers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.models.Pessoa;

import com.mysql.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaControllers {

	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping()
	public ResponseEntity<List<Pessoa>> obterPessoas() {
		return pessoaService.obterTodos();		
	}
	
	
	@PostMapping()
	public ResponseEntity<Pessoa> adicionar(@RequestBody Pessoa pessoa){
		return pessoaService.create(pessoa);
	}
	
}
