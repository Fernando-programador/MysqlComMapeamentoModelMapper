package com.mysql.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.mysql.exception.ResourceNotFoundException;

import com.mysql.models.Pessoa;
import com.mysql.repository.PessoaRepository;
import com.mysql.share.PessoaVo;

@Service
public class PessoaService {

	private Logger logger = LoggerFactory.getLogger(PessoaService.class);

	@Autowired
	private PessoaRepository pessoaRepository;

	public List<PessoaVo> obterTodos() {
		logger.info("PessoaService rodando obterTodos");

		var pessoas = pessoaRepository.findAll();

		return pessoas.stream().map(pessoa -> new ModelMapper().map(pessoa, PessoaVo.class))
				.collect(Collectors.toList());

	}

	public Optional<PessoaVo> obterPorId(Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		logger.info("PessoaService rodandado obterPorId");
		PessoaVo pessoaVo = new ModelMapper().map(pessoa.get(), PessoaVo.class);
		return Optional.of(pessoaVo);

	}

	public PessoaVo create(PessoaVo pessoaVo) {
		logger.info("PessoaService rodandado create");

		pessoaVo.setId(null);

		ModelMapper mapper = new ModelMapper();

		Pessoa pessoa = mapper.map(pessoaVo, Pessoa.class);

		pessoa = pessoaRepository.save(pessoa);

		pessoaVo.setId(pessoa.getId());

		return pessoaVo;

	}

	public PessoaVo update(PessoaVo pessoaVo, Long id) {

		pessoaVo.setId(id);

		ModelMapper mapper = new ModelMapper();

		Pessoa pessoa = mapper.map(pessoaVo, Pessoa.class);

		pessoa = pessoaRepository.save(pessoa);

		pessoaVo.setId(pessoa.getId());

		return pessoaVo;

	}

	public ResponseEntity<HttpStatus> deleteTodos() {
		try {
			pessoaRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	public void deletarPorId(@PathVariable("id") Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		if (pessoa.isEmpty()) {
			throw new ResourceNotFoundException("Não encontrado o id " + id);
		}
		pessoaRepository.deleteById(id);

	}

}
