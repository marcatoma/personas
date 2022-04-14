package com.backend.persona.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.persona.model.entity.Persona;
import com.backend.persona.repository.IPersonaDAO;

@Service
public class PersonaService {

	@Autowired
	IPersonaDAO personaDao;

	public List<Persona> ObtenerPersonas() {
		return personaDao.findAll();
	}

	public Persona ObtenerById(Long id) {
		return personaDao.findById(id).orElse(null);
	}

}
