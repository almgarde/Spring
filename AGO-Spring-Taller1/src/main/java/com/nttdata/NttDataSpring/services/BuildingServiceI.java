package com.nttdata.NttDataSpring.services;

import com.nttdata.NttDataSpring.persistence.Building;
import com.nttdata.NttDataSpring.persistence.Person;

public interface BuildingServiceI {
	
	/** Servicio para crear un nuevo edificio 
	 * 
	 * @return Building
	 */
	public Building makeNewBuilding();
	
	/** Servicio para añadir una persona al edificio */
	public void addPersonToBuilding(Building b, Person p);

	/** Servicio para eliminar una persona una edificio */
	public void deletePersonFromBuilding(Building b, Person person);

	/** Servicio para mostrar las personas del edificio */
	public void showAllPersonInTheBuilding(Building b);

	/** Servicio para mostrar el número de personas del edificio */
	public void numPersonInTheBuilding(Building b);


}
