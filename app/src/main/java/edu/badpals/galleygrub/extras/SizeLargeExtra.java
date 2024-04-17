package edu.badpals.galleygrub.extras;

import edu.badpals.galleygrub.order.Comanda;

import java.util.Optional;


public class SizeLargeExtra extends Extra{
    String name = "Large";
    Double price = 0.50d;

    public SizeLargeExtra(){}

    @Override
    public void sumExtrasCharge(Comanda order) {
        Optional<Double> LargeCharge = order.itemList().stream()
                                            .filter(item -> item.extra().equalsIgnoreCase(name))
                                            .map(item -> price)
                                            .reduce(Double::sum);

        if (LargeCharge.isPresent()) {
            order.updateTotal(LargeCharge.get());
        }

        this.nextExtra.ifPresent(chain -> chain.sumExtrasCharge(order));
    }
}

