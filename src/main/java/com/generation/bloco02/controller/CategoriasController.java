package com.generation.bloco02.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.bloco02.model.Categorias;
import com.generation.bloco02.repository.CategoriasRepository;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriasController {

	private final CategoriasRepository categoriasRepository;

	public CategoriasController(CategoriasRepository categoriasRepository) {
		this.categoriasRepository = categoriasRepository;
	}

	@GetMapping
	public ResponseEntity<List<Categorias>> getAll() {
		return ResponseEntity.ok(categoriasRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categorias> getById(@PathVariable Long id) {
		return categoriasRepository.findById(id).map(ResponseEntity::ok)
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@GetMapping("/categoria/{categoria}")
	public ResponseEntity<List<Categorias>> getByTitle(@PathVariable String categoria) {
		return ResponseEntity.ok(categoriasRepository.findAllByCategoriaContainingIgnoreCase(categoria));
	}
	@PostMapping
	public ResponseEntity<Categorias> post(@Valid @RequestBody Categorias categorias) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriasRepository.save(categorias));
	}

	@PutMapping
	public ResponseEntity<Categorias> put(@Valid @RequestBody Categorias categorias) {
		return categoriasRepository.findById(categorias.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(categoriasRepository.save(categorias)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Categorias> categoriasOptional = categoriasRepository.findById(id);
		if (categoriasOptional.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		categoriasRepository.deleteById(id);
	}
}
