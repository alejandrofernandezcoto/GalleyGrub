package edu.badpals.galleygrub.receipt;

import edu.badpals.galleygrub.order.*;
import edu.badpals.galleygrub.extras.*;

public interface Ticket {
    Comanda getOrder();
    void setChain(Extra extra);
    Extra getChain();
    Double total();
    void sumExtrasCharge();
    void print();

}
