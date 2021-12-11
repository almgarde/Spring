package com.nttdata.NttDataSpring.persistence;

import java.util.List;

public interface BuildingDaoI {

	/**
	 * Método para crear un nuevo edificio
	 * 
	 * @return Building
	 */
	public Building createBuilding();

	/** Método para añadir una persona al edificio */
	public void addPerson(Building b, Person person);

	/** Método para eliminar una persona una edificio */
	public void deletePerson(Building b, Person person);

	/**
	 * Método para mostrar las personas del edificio
	 * 
	 * @return List<Person>
	 */
	public List<Person> getAllPerson(Building b);

	/**
	 * Método para mostrar el número de personas del edificio
	 * 
	 * @return int
	 */
	public int numPerson(Building b);

}
