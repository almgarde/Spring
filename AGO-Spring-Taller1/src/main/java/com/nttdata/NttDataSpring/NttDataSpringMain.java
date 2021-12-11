package com.nttdata.NttDataSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.NttDataSpring.persistence.Building;
import com.nttdata.NttDataSpring.persistence.Person;
import com.nttdata.NttDataSpring.services.BuildingServiceI;

@SpringBootApplication
public class NttDataSpringMain implements CommandLineRunner {

	/** Servicio de gestión del edificio */
	@Autowired
	private BuildingServiceI buildingService;

	/** Método principal */
	public static void main(String[] args) {
		SpringApplication.run(NttDataSpringMain.class, args);

	}

	public void run(String... args) throws Exception {

		final Building b = buildingService.makeNewBuilding();

		Person p1 = new Person();
		p1.setName("Alice");
		p1.setSurName("Cooper");

		Person p2 = new Person();
		p2.setName("Thomas");
		p2.setSurName("Bergensen");

		Person p3 = new Person();
		p3.setName("Yuki");
		p3.setSurName("Kajiura");

		buildingService.addPersonToBuilding(b, p1);
		buildingService.showAllPersonInTheBuilding(b);

		System.out.println("-----------------");

		buildingService.addPersonToBuilding(b, p2);
		buildingService.showAllPersonInTheBuilding(b);

		System.out.println("-----------------");

		buildingService.addPersonToBuilding(b, p3);
		buildingService.showAllPersonInTheBuilding(b);

		System.out.println("-----------------");

		buildingService.numPersonInTheBuilding(b);

		System.out.println("-----------------");

		buildingService.deletePersonFromBuilding(b, p2);
		buildingService.showAllPersonInTheBuilding(b);
		buildingService.numPersonInTheBuilding(b);

	}

}
