package br.myrest.app.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.myrest.app.model.Zona;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/zona")
public class ZonaController {

	@PostMapping 
	public ResponseEntity criar(@RequestBody Zona zona) {
	
		if(zona.getNome() == "") {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome não informado!");
		}
		
		else {
			return ResponseEntity.status(HttpStatus.CREATED).body("Eleitor salvo com sucesso");
		}	
	}
	
	@GetMapping
	public ResponseEntity listar() {
		
		List<Zona> lista = new ArrayList<Zona>();
		
		Zona z = new Zona();
		
		z.setNome("Escola Estadual");
		lista.add(z);
		
		z.setNome("Faculdade 8 de Julho");
		lista.add(z);
		
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
	
//	@GetMapping(path = "/{id}")
//	public ResponseEntity byId(@PathVariable Long id) {
//		
//		Zona z = new Zona();
//		
//		z.setNome("Faculdade 8 de Julho");
//		
//			
//		return ResponseEntity.status(HttpStatus.OK).body(z);
//	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Zona zona, @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(zona);
	}

	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		System.out.println(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
}
