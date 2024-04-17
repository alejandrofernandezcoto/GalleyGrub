package edu.badpals.galleygrub.extras;

import edu.badpals.galleygrub.order.Comanda;

import java.util.Optional;

import edu.badpals.galleygrub.item.*;

public class Regular extends Extra {
    public Regular(){}

    @Override
    public void sumExtrasCharge(Comanda order) {
        Optional<Double> sumRegularPrices = order.itemList().stream().map(Item::price).reduce(Double::sum);

        if (sumRegularPrices.isPresent()) {
            order.updateTotal(sumRegularPrices.get());
        }

        this.nextExtra.ifPresent(chain -> chain.sumExtrasCharge(order));
    }

}
