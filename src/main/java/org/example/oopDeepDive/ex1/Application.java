package org.example.oopDeepDive.ex1;

import org.example.oopDeepDive.ex2.Warehouse;

public class Application {
    public static void main(String[] args) {
        //Create a Warehouse
        Warehouse warehouse = new Warehouse("OOP warehouse", "machupichu");

        //Add items
        var item1 = new Coffebean( "item1");
        var item2 = new Coffebean( "item2");
        warehouse.addItem(item1);
        warehouse.addItem(item2);

        //Print with variouse strategies
        PrintInventory printInventory = new PrintInventory(warehouse.getItems(), new htmlListPrintStrategyImpl());
        printInventory.print();
    }
}
