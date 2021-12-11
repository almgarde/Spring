package com.nttdata.NttDataSpring.persistence;

import java.io.Serializable;

public class Product implements Serializable {

	/** SERIAL */
	private static final long serialVersionUID = 1L;

	/** ID del producto */
	private String id;

	/** Nombre del producto */
	private String name;

	/** Precio del producto */
	private double price;

	/** Precio del producto sin impuestos */
	private double priceNoTax;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the priceNoTax
	 */
	public double getPriceNoTax() {
		return priceNoTax;
	}

	/**
	 * @param priceNoTax the priceNoTax to set
	 */
	public void setPriceNoTax(double priceNoTax) {
		this.priceNoTax = priceNoTax;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", priceNoTax=" + priceNoTax + "]";
	}

}
