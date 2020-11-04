package br.myrest.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.myrest.app.model.Eleitor;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/eleitor")
public class EleitorController {
	
	@PostMapping 
	public ResponseEntity criar(@RequestBody Eleitor eleitor) {
	
		if(eleitor.getNome() == "") {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome não informado!");
		}
		
		else {
			return ResponseEntity.status(HttpStatus.CREATED).body("Eleitor salvo com sucesso");
		}	
	}
	
	
	@GetMapping
	public ResponseEntity listar() {
		
		List<Eleitor> lista = new ArrayList<Eleitor>();
		
		Eleitor e = new Eleitor();
		
		e.setNome("Mateus");
		lista.add(e);
		
		e.setNome("Eduarda");
		lista.add(e);
		
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
	

//	@GetMapping(path = "/{id}")
//	public ResponseEntity byId(@PathVariable Long id) {
//		
//		Eleitor e = new Eleitor();
//		
//		e.setNome("Mateus");
//		
//		return ResponseEntity.status(HttpStatus.OK).body(e);
//	}
	
	
	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Eleitor eleitor, @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(eleitor);
	}

	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		System.out.println(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	

}
