package com.nttdata.clientes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.clientes.persistence.Client;
import com.nttdata.clientes.services.ClientServiceI;

/**
 * CLIENTES
 * 
 * @author agadelao
 *
 */
@SpringBootApplication
public class ClientesMain implements CommandLineRunner {

	/** Servicio de gestión de clientes */
	@Autowired
	private ClientServiceI clientService;

	/**
	 * Clase principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ClientesMain.class, args);
	}

	public void run(String... args) throws Exception {

		final Client client1 = new Client();
		client1.setNameClient("Alma");
		client1.setSurname1Client("García");
		client1.setSurname2Client("Obra");
		client1.setDniClient("22D");

		final Client client2 = new Client();
		client2.setNameClient("Samy");
		client2.setSurname1Client("Pastor");
		client2.setSurname2Client("Alemán");
		client2.setDniClient("4R");

		clientService.insertClient(client1);
		clientService.insertClient(client2);

		client2.setDniClient("5R");
		clientService.updateClient(client2);

		List<Client> clients = clientService.searchAllClients();
		for (Client c : clients) {
			System.out.println(c);
		}

		System.out.println("----------------------------");

		Optional<Client> c1 = clientService.searchClientById(20L);
		System.out.println(c1.toString());

		System.out.println("----------------------------");

		Client c2 = clientService.searchClientByNameAndSurnames("Samy", "Pastor", "Alemán");
		System.out.println(c2.toString());

	}
}
