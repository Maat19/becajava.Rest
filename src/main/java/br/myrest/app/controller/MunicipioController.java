package br.myrest.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.myrest.app.model.Municipio;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/municipio")
public class MunicipioController {
	
	@PostMapping 
	public ResponseEntity criar(@RequestBody Municipio municipio) {
	
		if(municipio.getNome() == "") {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome não informado!");
		}
		
		else if (municipio.getPopulacao() <=0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("População não informada!");
		}
	
		else {
			return ResponseEntity.status(HttpStatus.CREATED).body("Municipio salvo com sucesso");
		}	
	}
	
	@GetMapping
	public ResponseEntity listar() {
		
		List<Municipio> lista = new ArrayList<Municipio>();
		
		Municipio m = new Municipio();
		

		m.setNome("São Paulo");
		m.setPopulacao(14000000);
		lista.add(m);
		
		m.setNome("Campinas");
		m.setPopulacao(14000000);
		lista.add(m);
		
		
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
	
//	@GetMapping(path = "/{id}")
//	public ResponseEntity byId(@PathVariable Long id) {
//		
//		Municipio m = new Municipio();
//		m.setNome("Campinas");
//		m.setPopulacao(14000000);
//		
//
//		return ResponseEntity.status(HttpStatus.OK).body(m);
//	}

	
	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Municipio municipio, @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(municipio);
	}

	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		System.out.println(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
}
