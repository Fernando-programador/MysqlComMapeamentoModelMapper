package com.mysql.service;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.mysql.models.Pessoa;
import com.mysql.repository.PessoaRepository;

@Service
public class PessoaService {

	private Logger logger = Logger.getLogger(PessoaService.class.getName()); 
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public ResponseEntity<List<Pessoa>> obterTodos() {
		
		logger.info("PessoaService rodando");
		List<Pessoa> pessoas = pessoaRepository.findAll();
		return new ResponseEntity<>(pessoas, HttpStatus.OK);

	}
	
	public ResponseEntity<Pessoa> create(@RequestBody Pessoa pessoa){
		
	try {
		Pessoa p1 = pessoaRepository.save(new Pessoa(pessoa.getFistName(),
				pessoa.getLastName(),
				pessoa.getAddress(),
				pessoa.getGender()));
		return new ResponseEntity<>(p1, HttpStatus.CREATED);
		
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	
	
}
