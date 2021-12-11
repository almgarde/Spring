package com.nttdata.clientes.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * INTERFAZ DAO CLIENT
 * 
 * @author agadelao
 *
 */
@Repository
public interface ClientRepositoryI extends JpaRepository<Client, Long> {

	/**
	 * Método para buscar clientes por nombre y apellidos
	 * 
	 * @param nameClient
	 * @param surname1Client
	 * @param surname2Client
	 * @return Client
	 */
	public Client findByNameClientAndSurname1ClientAndSurname2Client(final String nameClient,
			final String surname1Client, final String surname2Client);

}