package com.nttdata.NttDataSpring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.NttDataSpring.persistence.Building;
import com.nttdata.NttDataSpring.persistence.BuildingDaoI;
import com.nttdata.NttDataSpring.persistence.Person;

@Service
public class BuildingServiceImpl implements BuildingServiceI {

	@Autowired
	BuildingDaoI buildingDao;

	/**
	 * Servicio para crear un nuevo edificio
	 * 
	 * @return Building
	 */
	public Building makeNewBuilding() {
		return buildingDao.createBuilding();
	}

	/** Servicio para añadir una persona al edificio */
	@Override
	public void addPersonToBuilding(Building b, Person p) {

		if (b != null && p != null) {
			if (!b.getNeighbours().contains(p)) {
				buildingDao.addPerson(b, p);

			} else {
				System.out.println("Este vecino ya vive en el edificio");
			}
		} else {
			System.out.println("El edificio y la persona no pueden ser nulas");
		}
	}

	/** Servicio para eliminar una persona una edificio */
	@Override
	public void deletePersonFromBuilding(Building b, Person p) {

		if (b != null && p != null) {
			if (b.getNeighbours().contains(p) == true) {
				buildingDao.deletePerson(b, p);
			} else {
				System.out.println("Este vecino no vive en el edificio");
			}
		} else {
			System.out.println("El edificio y la persona no pueden ser nulas");
		}
	}

	/** Servicio para mostrar las personas del edificio */
	@Override
	public void showAllPersonInTheBuilding(Building b) {

		if (b != null && !b.getNeighbours().isEmpty()) {

			List<Person> pResults = buildingDao.getAllPerson(b);

			for (Person p : pResults) {
				System.out.println(p.toString());
			}

		} else {
			System.out.println("El edificio está vacío o es nulo");
		}

	}

	/** Servicio para mostrar el número de personas del edificio */
	@Override
	public void numPersonInTheBuilding(Building b) {
		if (b != null && !b.getNeighbours().isEmpty()) {
			System.out.println("Hay " + buildingDao.numPerson(b) + " personas en el edificio");
		} else {
			System.out.println("El edificio está vacío o es nulo");
		}
	}

}
