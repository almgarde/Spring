package com.nttdata.NttDataSpring.persistence;

import java.util.List;

public interface OrderDaoI {

	/** Método para crear un nuevo pedido */
	public Order createNewOrder();

	/** Método para añadir un producto a un pedido */
	public void addProduct(Order o, Product product);

	/** Método para eliminar un producto de un pedido */
	public void deleteProduct(Order o, Product product);

	/** Método para mostrar todos los productos de un pedido */
	public List<Product> showAllProducts(Order o);

	/** Método para mostrar el número de productos de un pedido */
	public int numProducts(Order o);

}
