package com.backend.persona.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.persona.model.entity.Persona;

public interface IPersonaDAO extends JpaRepository<Persona, Long> {

	Persona findByCedula(String cedula);

}
