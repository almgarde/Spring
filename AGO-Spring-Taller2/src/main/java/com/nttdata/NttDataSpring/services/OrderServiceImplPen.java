package com.nttdata.NttDataSpring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.NttDataSpring.persistence.Order;
import com.nttdata.NttDataSpring.persistence.OrderDaoI;
import com.nttdata.NttDataSpring.persistence.Product;

@Service("Peninsula")
public class OrderServiceImplPen implements OrderServiceI {

	@Autowired
	OrderDaoI orderDao;

	/**
	 * Servicio para crear un nuevo pedido a la Península
	 * 
	 * @return Order
	 */
	@Override
	public Order makeNewOrder() {
		Order o = orderDao.createNewOrder();
		o.setCeuMelCan(false);
		return o;
	}

	/**
	 * Servicio para crear un nuevo pedido a la Península
	 * 
	 * @return Order
	 */
	@Override
	public void addProductToOrder(Order o, Product p) {

		if (o != null && p != null) {
			double priceWithTax = p.getPriceNoTax() + p.getPriceNoTax() * 0.21;
			p.setPrice(priceWithTax);
			orderDao.addProduct(o, p);

		} else {
			System.out.println("El pedido y el producto no pueden ser nulos");
		}
	}

	/** Servicio para eliminar un producto de un pedido a la Península */
	@Override
	public void deleteProductFromOrder(Order o, Product p) {

		if (o != null && p != null) {
			if (o.getProducts().contains(p)) {
				orderDao.deleteProduct(o, p);
			} else {
				System.out.println("El producto no está en el pedido");
			}
		} else {
			System.out.println("El producto y el pedido no pueden ser nulos");
		}
	}

	/**
	 * Servicio para mostrar todos los productos de un pedido a la Península
	 * 
	 * @return List<Product>
	 */
	@Override
	public void showAllProductInTheOrder(Order o) {

		if (o != null && !o.getProducts().isEmpty()) {
			List<Product> productos = orderDao.showAllProducts(o);

			for (Product p : productos) {
				System.out.println(p.toString());
			}
		} else {
			System.out.println("El pedido está vacío o es nulo");
		}
	}

	/**
	 * Servicio para mostrar el número de productos de un pedido a la Península
	 * 
	 * @return int
	 */
	@Override
	public void numProductsInTheOrder(Order o) {
		if (o != null && !o.getProducts().isEmpty()) {
			System.out.println("Hay " + orderDao.numProducts(o) + " productos en el pedido");
		} else {
			System.out.println("El pedido está vacío o es nulo");
		}
	}

}
