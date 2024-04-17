package edu.badpals.galleygrub.extras;

import java.util.Optional;

import edu.badpals.galleygrub.order.Comanda;

public class SizeMediumExtra extends Extra{
    String name = "medium";
    Double price = 0.25d;

    public SizeMediumExtra(){}

    @Override
    public void sumExtrasCharge(Comanda order) {
        Optional<Double> MediumCharge = order.itemList().stream()
                                            .filter(item -> item.extra().equalsIgnoreCase(name))
                                            .map(item -> price)
                                            .reduce(Double::sum);

        if (MediumCharge.isPresent()) {
            order.updateTotal(MediumCharge.get());
        }

        this.nextExtra.ifPresent(chain -> chain.sumExtrasCharge(order));
    }
}

