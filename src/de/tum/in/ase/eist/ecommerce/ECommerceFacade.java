package de.tum.in.ase.eist.ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ECommerceFacade {

    public AdvertisementController advertisementController;
    public OrderController orderController;
    public ShippingController shippingController;

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
    }

}
