package com.generation.bloco02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.bloco02.model.Categorias;

public interface CategoriasRepository extends JpaRepository<Categorias, Long> {
	public List<Categorias> findAllByCategoriaContainingIgnoreCase(@Param("categoria") String categoria);

}
