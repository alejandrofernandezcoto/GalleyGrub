package edu.badpals.galleygrub.extras;

import java.util.Optional;

import edu.badpals.galleygrub.order.*;

public abstract class Extra {
    Optional<Extra> nextExtra = Optional.ofNullable(null);

    public void setNextExtra(Extra nextExtra) {
        this.nextExtra = Optional.of(nextExtra);
    }

    public abstract void sumExtrasCharge(Comanda order);
}
