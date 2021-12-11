package com.nttdata.NttDataSpring.persistence;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl implements OrderDaoI {

	/**
	 * Método para crear un nuevo pedido
	 * 
	 * @return Order
	 */
	@Override
	public Order createNewOrder() {
		final Order o = new Order();
		return o;
	}

	/** Método para añadir un producto a un pedido */
	@Override
	public void addProduct(Order o, Product product) {
		o.getProducts().add(product);
	}

	/** Método para eliminar un producto de un pedido */
	@Override
	public void deleteProduct(Order o, Product product) {
		o.getProducts().remove(product);
	}

	/**
	 * Método para mostrar todos los productos de un pedido
	 * 
	 * @return List<Product>
	 */
	@Override
	public List<Product> showAllProducts(Order o) {
		return o.getProducts();
	}

	/**
	 * Método para mostrar el número de productos de un pedido
	 * 
	 * @return int
	 */
	@Override
	public int numProducts(Order o) {
		return o.getProducts().size();

	}

}
