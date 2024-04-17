package edu.badpals.galleygrub.extras;

import edu.badpals.galleygrub.order.Comanda;

import java.util.Optional;

public class SauceExtra extends Extra{
    String name = "Sauce";
    Double price = 0.50d;

    public SauceExtra(){}

    @Override
    public void sumExtrasCharge(Comanda order) {
        Optional<Double> SuaceCharge = order.itemList().stream()
                                            .filter(item -> item.extra().equalsIgnoreCase(name))
                                            .map(item -> price)
                                            .reduce(Double::sum);

        if (SuaceCharge.isPresent()) {
            order.updateTotal(SuaceCharge.get());
        }

        this.nextExtra.ifPresent(chain -> chain.sumExtrasCharge(order));
    }
}
