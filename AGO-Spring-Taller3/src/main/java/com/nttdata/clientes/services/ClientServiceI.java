package com.nttdata.clientes.services;

import java.util.List;
import java.util.Optional;

import com.nttdata.clientes.persistence.Client;

/**
 * Interfaz de gestión de clientes
 * 
 * @author agadelao
 *
 */

public interface ClientServiceI {

	/**
	 * Servicio para añadir nuevos clientes
	 * 
	 * @param insertClient
	 * @return Long
	 */
	public Long insertClient(final Client insertClient);

	/**
	 * Servicio para actualizar clientes
	 * 
	 * @param updateClient
	 */
	public void updateClient(final Client updateClient);

	/**
	 * Servicio para buscar clientes por ID
	 * 
	 * @param idClient
	 * @return Client
	 */
	public Optional<Client> searchClientById(Long idClient);

	/**
	 * Servicio para traer todos los clientes
	 * 
	 * @return List
	 */
	public List<Client> searchAllClients();

	/**
	 * Servicio para borrar un cliente
	 * 
	 * @param removeClient
	 */
	public void deleteClient(final Client removeClient);

	/**
	 * Servicio para buscar un cliente por nombre, primer y segundo apellido
	 * 
	 * @param nameClient
	 * @param surname1Client
	 * @param surname2Client
	 * @return Client
	 */
	public Client searchClientByNameAndSurnames(String nameClient, String surname1Client, String surname2Client);

}
