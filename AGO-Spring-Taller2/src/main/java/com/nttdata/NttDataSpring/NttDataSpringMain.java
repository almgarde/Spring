package com.nttdata.NttDataSpring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.NttDataSpring.persistence.Order;
import com.nttdata.NttDataSpring.persistence.Product;
import com.nttdata.NttDataSpring.services.OrderServiceI;

@SpringBootApplication
public class NttDataSpringMain implements CommandLineRunner {

	/** Servicio de pedidos a la Península */
	@Autowired
	@Qualifier("Peninsula")
	private OrderServiceI orderServicePen;

	/** Servicio de pedidos a Ceuta, Melilla y Canarias */
	@Autowired
	@Qualifier("CeuMelCan")
	private OrderServiceI orderServiceCeuMelCan;

	/** Método principal */
	public static void main(String[] args) {
		SpringApplication.run(NttDataSpringMain.class, args);

	}

	public void run(String... args) throws Exception {
		Order o1 = orderServiceCeuMelCan.makeNewOrder();
		o1.setAddressee("Fulanito");
		o1.setAddress("Ceuta");

		Order o2 = orderServicePen.makeNewOrder();
		o1.setAddressee("Menganito");
		o1.setAddress("Sevilla");

		Product p1 = new Product();
		p1.setId("1");
		p1.setName("Tijeras");
		p1.setPriceNoTax(2);

		Product p2 = new Product();
		p2.setId("2");
		p2.setName("Libro");
		p2.setPriceNoTax(10);

		Product p3 = new Product();
		p3.setId("3");
		p3.setName("Madeja de hilo");
		p3.setPriceNoTax(3);

		orderServicePen.addProductToOrder(o2, p1);
		orderServicePen.addProductToOrder(o2, p2);

		orderServicePen.showAllProductInTheOrder(o2);
		orderServicePen.numProductsInTheOrder(o2);

		System.out.println("--------------------------");

		orderServiceCeuMelCan.addProductToOrder(o1, p1);
		orderServiceCeuMelCan.addProductToOrder(o1, p3);

		orderServiceCeuMelCan.showAllProductInTheOrder(o1);
		orderServiceCeuMelCan.numProductsInTheOrder(o1);

		System.out.println("--------------------------");

		orderServiceCeuMelCan.deleteProductFromOrder(o1, p3);
		orderServiceCeuMelCan.showAllProductInTheOrder(o1);
		orderServiceCeuMelCan.numProductsInTheOrder(o1);

	}
}
