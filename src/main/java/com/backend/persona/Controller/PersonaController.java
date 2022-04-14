package com.backend.persona.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.persona.model.entity.Persona;
import com.backend.persona.model.service.PersonaService;

@RestController
@RequestMapping("/persona")
@CrossOrigin("*")
public class PersonaController {

	@Autowired
	private PersonaService personaService;

	@GetMapping("/")
	private ResponseEntity<List<Persona>> ListarPersonas() {
		return ResponseEntity.ok(personaService.ObtenerPersonas());
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<?> ObtenerPorId(@PathVariable Long codigo) {
		Persona per = new Persona();
		Map<String, Object> response = new HashMap<>();
		try {
			per = personaService.ObtenerById(codigo);
		} catch (DataAccessException e) {
			System.out.println(e.getMostSpecificCause().getMessage());
			response.put("error", e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		response.put("content", per);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
