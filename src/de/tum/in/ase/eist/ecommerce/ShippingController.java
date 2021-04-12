package de.tum.in.ase.eist.ecommerce;

public class ShippingController {

	public void shipOrder(Order order) {
		System.out.println("Shipping of order " + order.getId() + " to " + order.getShipping().getAddress() + " has " +
				"started.");
	}

	public Shipping createShipping(String address) {
		return new Shipping(address);
	}

	// Due to our rapid growth we may need external support to deliver all parcels in time.
	public void commissionExternalParcelService() {
		System.out.println("Commission external parcel service due to high shipping demand.");
	}

}
