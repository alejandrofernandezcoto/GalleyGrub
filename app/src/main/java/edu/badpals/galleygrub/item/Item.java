package edu.badpals.galleygrub.item;

public class Item implements Product{

    String name = "";
    Double price;
    String extra = "";

    public Item(String name, Double price){
        this.name = name;
        this.price = price;
    }

    public Item(String name, Double price, String extra){
        this.name = name + " w/ " + extra;
        this.price = price;
        this.extra = extra;
    }

    @Override
    public String extra() {
        return this.extra;
    }

    @Override
    public Boolean isRegular() {

        return extra.isBlank();
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public Double price() {
        return this.price;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Item){
            return this.name.equals(((Item)obj).name);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public String toString(){
        return RetailPrice.contains(this.extra())? 
        this.name + "...." + String.format("%.2f", this.price) + "$" + " + " + String.format("%.2f", RetailPrice.getPrice(this.extra())) + "$":
        this.name + "...." + String.format("%.2f", this.price) + "$";
    }


    
}
