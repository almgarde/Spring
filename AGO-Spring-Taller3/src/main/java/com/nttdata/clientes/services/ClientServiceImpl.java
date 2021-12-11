package com.nttdata.clientes.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.clientes.persistence.Client;
import com.nttdata.clientes.persistence.ClientRepositoryI;

/**
 * Servicio de gestión de clientes
 * 
 * @author agadelao
 *
 */
@Service
public class ClientServiceImpl implements ClientServiceI {

	/** Logger */
	final static Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);

	/** DAO de la tabla cliente */
	@Autowired
	private ClientRepositoryI clientRep;

	/**
	 * Servicio para añadir nuevos clientes
	 * 
	 * @param insertClient
	 * @return Long
	 */
	@Override
	public Long insertClient(Client insertClient) {

		LOGGER.info("Inicio del método insertClient");

		Long clientIdInserted = null;

		// Condición de verificación
		if (insertClient != null && insertClient.getIdClient() == null) {
			// Añadido de cliente
			clientRep.save(insertClient);
			LOGGER.trace("Se ha añadido el cliente " + insertClient);
		} else {
			LOGGER.error("Se ha introducido un cliente nulo o el cliente a introducir ya existe");
		}
		LOGGER.info("Fin del método insertClient");
		return clientIdInserted;
	}

	/**
	 * Servicio para actualizar clientes
	 * 
	 * @param updateClient
	 */
	@Override
	public void updateClient(Client updateClient) {
		LOGGER.info("Inicio del método updateClient");

		// Condición de verificación
		if (updateClient != null && updateClient.getIdClient() != null) {
			// Actualizado del cliente
			// clientRep.update(updateClient);
			LOGGER.trace("Se ha actualizado el cliente " + updateClient.getIdClient());
		} else {
			LOGGER.error("Se ha introducido un cliente nulo o el cliente a actualizar no existe");
		}
		LOGGER.info("Fin del método updateClient");

	}

	/**
	 * Servicio para buscar clientes por ID
	 * 
	 * @param idClient
	 * @return Client
	 */
	@Override
	public Optional<Client> searchClientById(Long idClient) {

		LOGGER.info("Inicio del método searchClientById");

		Optional<Client> clientSearched = null;

		// Condición de verificación
		if (idClient != null) {
			// Buscado de cliente
			clientSearched = clientRep.findById(idClient);

			LOGGER.trace("Se ha encontrado el cliente " + idClient);
		} else {
			LOGGER.error("No se ha encontrado el cliente con id " + idClient);
		}

		LOGGER.info("Fin del método searchClientById");
		return clientSearched;
	}

	/**
	 * Servicio para traer todos los clientes
	 * 
	 * @return List
	 */
	@Override
	public List<Client> searchAllClients() {

		LOGGER.info("Inicio del método searchAllClients");
		LOGGER.info("Fin del método searchAllClients");
		return clientRep.findAll();

	}

	/**
	 * Servicio para borrar un cliente
	 * 
	 * @param removeClient
	 */
	@Override
	public void deleteClient(Client removeClient) {
		LOGGER.info("Inicio del método deleteClient");

		// Condición de verificación
		if (removeClient != null && removeClient.getIdClient() != null) {
			// Borrado del cliente
			clientRep.delete(removeClient);
			LOGGER.trace("Se ha borrado el cliente" + removeClient.getIdClient());
		} else {
			LOGGER.error("Se ha introducido un cliente nulo o el cliente a borrar no existe");
		}

		LOGGER.info("Fin del método deleteClient");

	}

	/**
	 * Servicio para buscar un cliente por nombre, primer y segundo apellido
	 * 
	 * @param nameClient
	 * @param surname1Client
	 * @param surname2Client
	 * @return Client
	 */
	@Override
	public Client searchClientByNameAndSurnames(String nameClient, String surname1Client, String surname2Client) {

		LOGGER.info("Inicio del método searchClientByNameAndSurnames");

		Client clientSearched = null;

		// Condición de verificación. NOTA: Según la BBDD, el segundo apellido puede ser
		// nulo

		if (nameClient != null && !nameClient.isBlank() && surname1Client != null && !surname1Client.isBlank()) {
			clientSearched = clientRep.findByNameClientAndSurname1ClientAndSurname2Client(nameClient, surname1Client,
					surname2Client);
		} else {
			LOGGER.error("Se ha introducido un nombre o apellido nulos o no se ha encontrado el cliente");
		}

		LOGGER.info("Fin del método searchClientByNameAndSurnames");
		return clientSearched;
	}

}
