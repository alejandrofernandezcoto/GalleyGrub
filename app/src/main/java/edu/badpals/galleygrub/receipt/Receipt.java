package edu.badpals.galleygrub.receipt;

import edu.badpals.galleygrub.order.*;
import edu.badpals.galleygrub.extras.*;

public class Receipt implements Ticket{

    private Double total = 0d;
    private final Comanda order;
    private Extra firstExtra = null;

    public Receipt(Comanda order){
        this.order = order;
        this.total = order.getTotal();

    }

    @Override
    public Comanda getOrder() {
        return this.order;
    }

    @Override
    public void setChain(Extra extra) {
        this.firstExtra = extra;
    }

    @Override
    public Extra getChain() {
        return this.firstExtra;
    }

    @Override
    public Double total() {
        if (total == 0d) {
            this.sumExtrasCharge();
            this.total = this.getOrder().getTotal();
        }
        return total;
    }

    @Override
    public void sumExtrasCharge() {
        if (this.firstExtra != null) {
            this.firstExtra.sumExtrasCharge(this.order);
            
        }
    }

    @Override
    public void print() {
        this.getOrder().display();
        System.out.print("\tTOTAL --------> " + String.format("%.2f", this.total) + "$\n");
    }

}
