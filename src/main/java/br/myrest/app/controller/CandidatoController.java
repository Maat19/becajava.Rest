package br.myrest.app.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.myrest.app.model.Candidato;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/candidato")

public class CandidatoController {
	
	@PostMapping 
	public ResponseEntity criar(@RequestBody Candidato candidato) {
	
		if(candidato.getNome() == "") {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome não informado!");
		}
		
		else if (candidato.getNumero() == "") {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Número não informado!");
		}
		
		else if (candidato.getTipo() == "") {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tipo não informado!");
		}
		
		else {
			return ResponseEntity.status(HttpStatus.CREATED).body("Candidato salvo com sucesso");
		}	
	}
	
	
	@GetMapping
	public ResponseEntity listar() {
		
		List<Candidato> lista = new ArrayList<Candidato>();
		
		Candidato c = new Candidato();
		
		c.setNumero("12345");
		c.setNome("João");
		c.setTipo("Prefeito");
		lista.add(c);
		
		c.setNumero("54321");
		c.setNome("Maria");
		c.setTipo("Vereadora");
		lista.add(c);
		
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
	
//
//	@GetMapping(path = "/{id}")
//	public ResponseEntity byId(@PathVariable Long id) {
//		
//		Candidato c = new Candidato();
//		c.setNumero("54321");
//		c.setNome("Maria");
//		c.setTipo("Vereadora");
//		
//		return ResponseEntity.status(HttpStatus.OK).body(c);
//	}
	
	
	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Candidato candidato, @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(candidato);
	}

	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		System.out.println(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
