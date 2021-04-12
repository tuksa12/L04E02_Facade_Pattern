package de.tum.in.ase.eist.store;

import de.tum.in.ase.eist.ecommerce.AdvertisementController;
import de.tum.in.ase.eist.ecommerce.Order;
import de.tum.in.ase.eist.ecommerce.OrderController;
import de.tum.in.ase.eist.ecommerce.ShippingController;

public class Cinema {

	private static int count = 1;
	private final String address;
	private final String name;
	private final int id;
	private final OrderController orderController;
	private final ShippingController shippingController;
	private final AdvertisementController advertisementController;

	public Cinema(String address, String name) {
		this.address = address;
		this.name = name;
		this.id = generateCinemaId();
		this.orderController = new OrderController();
		this.shippingController = new ShippingController();
		this.advertisementController = new AdvertisementController();
	}

	public void startLiveStream(int ageRestriction) {
		System.out.println("Let's watch some ads at the beginning.");
		advertise(ageRestriction);
		System.out.println("The film starts. Your cinema " + name + " hopes you enjoy the movie.");
	}

	public void stopLiveStream(int ageRestriction) {
		System.out.println("Let's watch some more ads. ");
		advertise(ageRestriction);
		System.out.println("Have a nice evening.");
	}

	public void advertise(int ageRestriction) {
		advertisementController.playAdvertisement(ageRestriction);
	}

	public void deliverPopcorn(String shippingAddress) {
		Order order = orderController.retrieveLatestOrder(id);
		orderController.processOrder(order);
		order.setShipping(shippingController.createShipping(shippingAddress));
		shippingController.shipOrder(order);
	}

	@Override
	public String toString() {
		return "Cinema " + name + ", located at " + address;
	}

	private int generateCinemaId() {
		count *= 2;
		return count;
	}

}
