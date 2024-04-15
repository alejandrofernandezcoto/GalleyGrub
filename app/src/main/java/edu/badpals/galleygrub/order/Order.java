package edu.badpals.galleygrub.order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.badpals.galleygrub.item.*;
public class Order implements Comanda{
    private Double total = 0d;
    private final List<Item> items = new ArrayList<Item>();

    public Order(){}


    @Override
    public void addItem(String name, double price) {
        Item item = new Item(name, price);
        items.add(item);
    }
    @Override
    public void addItem(String name, double price, String extra) {
        Item item = new Item(name, price, extra);
        items.add(item);
    }
    @Override
    public int size() {
        return items.size();
    }
    @Override
    public List<Item> itemList() {
        return Collections.unmodifiableList(items);
    }
    @Override
    public Double getTotal() {
        return this.total;
    }
    @Override
    public void updateTotal(Double total) {
        this.total += total;
    }
    @Override
    public void display() {
        System.out.println("\n\t --- ORDER --- \n");
        itemList().stream().forEach(t -> itemDisplay(t));
    }

    private static void itemDisplay(Item item) {
        System.out.print("\t" + item.toString() + "\n");
    }

    


}
