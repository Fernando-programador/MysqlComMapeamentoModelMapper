package com.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mysql.models.Pessoa;


@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	
	
	
}
