package de.tum.in.ase.eist.ecommerce;

import java.util.ArrayList;
import java.util.List;

//TODO 1 Add a new class ECommerceFacade in the package ecommerce.
//TODO 2 Implement all public methods of the OrderController and the AdvertisementController in the facade.
//TODO 3 Implement a new shipOrder method in the OrderController according to the problem statement on Artemis.
public class OrderController {

	private static final int MAX_POPCORN_PRICE = 12;
	private static final int MAX_BOOK_PRICE = 10;
	private static final int MAX_NUMBER_OF_GENERATED_ITEMS = 3;

	public void processOrder(Order order) {
		System.out.println("Payment transaction completed.");
		createReceipt(order);
	}

	public Order retrieveLatestOrder(int id) {
		if (id % 2 == 0) {
			System.out.println("Retrieve latest order for cinema " + id);
			return new Order(generateRandomItemList("popcorn", MAX_POPCORN_PRICE));
		} else {
			System.out.println("Retrieve latest order for book store " + id);
			return new Order(generateRandomItemList("book", MAX_BOOK_PRICE));
		}
	}

	private void createReceipt(Order order) {
		System.out.println("Creating receipt for order " + order.getId() + ".");
		System.out.println("Customer has paid price " + String.format("%1$,.2f", order.getPrice()) + " for order " + order.getId());
	}

	private List<Item> generateRandomItemList(String product, double maxPrice) {
		List<Item> items = new ArrayList<>();
		for (int i = 0; i < MAX_NUMBER_OF_GENERATED_ITEMS; i++) {
			items.add(new Item(product + " " + i, Math.random() * maxPrice));
		}
		return items;
	}

}
