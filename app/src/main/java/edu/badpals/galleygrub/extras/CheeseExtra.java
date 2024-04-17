package edu.badpals.galleygrub.extras;

import edu.badpals.galleygrub.order.Comanda;

import java.util.Optional;

public class CheeseExtra extends Extra{
    String name = "cheese";
    Double price = 0.25d;

    public CheeseExtra(){}

    @Override
    public void sumExtrasCharge(Comanda order) {
        Optional<Double> cheeseCharge = order.itemList().stream()
                                            .filter(item -> item.extra().equalsIgnoreCase(name))
                                            .map(item -> price)
                                            .reduce(Double::sum);

        if (cheeseCharge.isPresent()) {
            order.updateTotal(cheeseCharge.get());
        }

        this.nextExtra.ifPresent(chain -> chain.sumExtrasCharge(order));
    }
}
