package com.generation.bloco02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.bloco02.model.Produtos;


public interface ProdutosRepository extends JpaRepository<Produtos, Long>{
	public List<Produtos> findAllByNomeProdutoContainingIgnoreCase(@Param("nomeProduto") String nomeProduto);

}
