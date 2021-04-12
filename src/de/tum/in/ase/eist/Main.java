package de.tum.in.ase.eist;

import de.tum.in.ase.eist.store.BookStore;
import de.tum.in.ase.eist.store.Cinema;

public final class Main {

	private static final int ADULT_AGE_RESTRICTION = 18;

	private Main() {
	}

	public static void main(String[] args) {
		Cinema cinema = new Cinema("Boltzmannstraße 3, Garching", "TUM-Cinema");
		BookStore bookStore = new BookStore("Arcisstraße 21, München", "TUM-Books");

		cinema.startLiveStream(ADULT_AGE_RESTRICTION);
		cinema.stopLiveStream(ADULT_AGE_RESTRICTION);

		bookStore.acceptOrder();
		cinema.deliverPopcorn("Ludwigstraße 117a, München");
	}

}
