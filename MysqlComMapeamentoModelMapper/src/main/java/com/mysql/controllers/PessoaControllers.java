package com.mysql.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.service.PessoaService;

import com.mysql.share.PessoaVo;

@RestController
@RequestMapping("/pessoa")
public class PessoaControllers {

	@Autowired
	private PessoaService pessoaService;

	@GetMapping()
	public List<PessoaVo> obterPessoas() {
		return pessoaService.obterTodos();
	}

	@PostMapping()
	public PessoaVo adicionar(@RequestBody PessoaVo pessoa) {
		return pessoaService.create(pessoa);

	}

	@GetMapping("/{id}")
	public Optional<PessoaVo> obterPorId(@PathVariable("id") Long id) {
		return pessoaService.obterPorId(id);
	}

	@PutMapping("/{id}")
	public PessoaVo upgradePessoa(@RequestBody PessoaVo pessoaVo, @PathVariable("id") Long Id) {
		return pessoaService.update(pessoaVo, Id);
	}

	@DeleteMapping()
	public ResponseEntity<HttpStatus> deletarTodos() {
		pessoaService.deleteTodos();
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deletePorId(@PathVariable("id") Long id) {
		pessoaService.deletarPorId(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
}