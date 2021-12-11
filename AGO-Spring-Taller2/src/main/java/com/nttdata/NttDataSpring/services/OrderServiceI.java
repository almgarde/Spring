package com.nttdata.NttDataSpring.services;

import java.util.List;

import com.nttdata.NttDataSpring.persistence.Order;
import com.nttdata.NttDataSpring.persistence.Product;

public interface OrderServiceI {

	/** Servicio para crear un nuevo pedido */
	public Order makeNewOrder();

	/** Servicio para añadir un producto a un pedido */
	public void addProductToOrder(Order o, Product p);

	/** Servicio para eliminar un producto de un pedido */
	public void deleteProductFromOrder(Order o, Product p);

	/** Servicio para mostrar todos los productos de un pedido */
	public void showAllProductInTheOrder(Order o);

	/** Servicio para mostrar el número de productos de un pedido */
	public void numProductsInTheOrder(Order o);

}
