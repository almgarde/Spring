package com.nttdata.NttDataSpring.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {

	/** SERIAL */
	private static final long serialVersionUID = 1L;

	/** ID del pedido */
	private String id;

	/** Destinatario del pedido */
	private String addressee;

	/** Dirección del pedido */
	private String address;

	/** Indicador si es para Ceuta, Melilla o Canarias */
	private boolean ceuMelCan;

	/** Lista de productos del pedido */
	private List<Product> products;

	/** Método constructor */
	public Order() {
		this.products = new ArrayList<Product>();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the addressee
	 */
	public String getAddressee() {
		return addressee;
	}

	/**
	 * @param addressee the addressee to set
	 */
	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the ceuMelCan
	 */
	public boolean isCeuMelCan() {
		return ceuMelCan;
	}

	/**
	 * @param ceuMelCan the ceuMelCan to set
	 */
	public void setCeuMelCan(boolean ceuMelCan) {
		this.ceuMelCan = ceuMelCan;
	}

	/**
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", addressee=" + addressee + ", address=" + address + ", ceuMelCan=" + ceuMelCan
				+ "]";
	}

}
