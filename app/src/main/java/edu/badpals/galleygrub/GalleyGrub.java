package edu.badpals.galleygrub;

import edu.badpals.galleygrub.item.RetailPrice;

public class GalleyGrub {
    public static void main( String[] args )
    {

        /**
         * Crea un diccionario con los precios
         * de los extras.
         *  
         *  Los precios de los extras son estos:
         *  - cheese +0.25
         *  - sauce +0.50
         *  - medium +0.25
         *  - large +0.50
         * 
         * Lee los precios de los items en la imagen 
         * del menu proporcionada.
         */

        RetailPrice.init_prices();

        // formatea la salida de cada entrada del diccionario como prefieras
        System.out.print("\n\t --- PRICES ---  \n");
        RetailPrice.display();

        /**
         * Crea los items del menu 
         * y printa sus datos.
         * 
         * Krabby Patty
         * Coral Bits
         * Kelp Rings
         * Golden Loaf
         * Seafoam Soda
         * 
         * Incluye los metodos sobrescritos
         * equals y hascode para comparar objetos
         * de tipo Item.
         */

        System.out.print("\n\t --- GALLEY GRUB ---  \n");
        
        Product patty = new Item("Krabby Patty", 1.25);
        display(patty);
        Product bits = new Item("Coral Bits", 1.00);
        display(bits);
        Product rings = new Item("Kelp Rings", 1.50);
        display(rings);
        Product loaf = new Item("Golden Loaf", 2.00);
        display(loaf);
        Product soda = new Item("Seafoam Soda", 1.00);
        display(soda);

    }
}
