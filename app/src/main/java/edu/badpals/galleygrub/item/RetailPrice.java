package edu.badpals.galleygrub.item;

import java.util.HashMap;
import java.util.Map;

public class RetailPrice {
    static Map<String,Double> prices = new HashMap<String,Double>();

    public RetailPrice(){
    };

    public static void init_prices(){
        prices.put("cheese",0.25);
        prices.put("sauce",0.50);
        prices.put("medium",0.25);
        prices.put("large",0.50);
    };

    public static double getPrice(String item) {
        return prices.get(item);
    }

    public static boolean contains(String item){
        return prices.containsKey(item);
    }

    public static void display(){
        prices.entrySet().stream().forEach(entry -> System.out.println("\t" + entry));
    }
}
