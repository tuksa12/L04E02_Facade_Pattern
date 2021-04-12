package de.tum.in.ase.eist.ecommerce;

import java.util.List;

public class Order {

	private Shipping shipping;
	private final double price;
	private final int id;
	private final List<Item> items;
	private static int count = 0;

	public Order(List<Item> items) {
		this.items = items;
		this.price = calculateTotalSum();
		this.id = generateId();
	}

	public Shipping getShipping() {
		return shipping;
	}

	public double getPrice() {
		return price;
	}

	public static int getCount() {
		return count;
	}

	public int getId() {
		return id;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}

	private int generateId() {
		return ++count;
	}

	private double calculateTotalSum() {
		return items.stream().mapToDouble(Item::getPrice).sum();
	}

}
