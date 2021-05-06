package de.tum.in.ase.eist.ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ECommerceFacade {

    private final AdvertisementController advertisementController;
    private final OrderController orderController;
    private final ShippingController shippingController;

    public ECommerceFacade() {
        this.advertisementController = new AdvertisementController();
        this.orderController = new OrderController();
        this.shippingController = new ShippingController();
    }

    public void processOrder(Order order) {
        orderController.processOrder(order);
    }

    public Order retrieveLatestOrder(int id) {
        return orderController.retrieveLatestOrder(id);
    }


    public void playAdvertisement(int ageRestriction) {
        advertisementController.playAdvertisement(ageRestriction);
    }

    public void shipOrder(Order order, String address){
        order.setShipping(shippingController.createShipping(address));
        shippingController.shipOrder(order);
    }

}
