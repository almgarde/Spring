package com.nttdata.NttDataSpring.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class BuildingDaoImpl implements BuildingDaoI {

	/**
	 * Método para crear un nuevo edificio
	 * 
	 * @return Building
	 */
	public Building createBuilding() {

		// Resultado.
		final Building edificio = new Building();

		return edificio;
	}

	/** Método para añadir una persona al edificio */
	@Override
	public void addPerson(Building b, Person person) {
		b.getNeighbours().add(person);
	}

	/** Método para eliminar una persona una edificio */
	@Override
	public void deletePerson(Building b, Person person) {
		b.getNeighbours().remove(person);
	}

	/**
	 * Método para mostrar las personas del edificio
	 * 
	 * @return List<Person>
	 */
	@Override
	public List<Person> getAllPerson(Building b) {

		return b.getNeighbours();

	}

	/**
	 * Método para mostrar el número de personas del edificio
	 * 
	 * @return int
	 */
	@Override
	public int numPerson(Building b) {
		return b.getNeighbours().size();
	}

}
