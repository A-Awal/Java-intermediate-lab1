package org.example.exceptionHandling.ex2;

import org.example.oopDeepDive.ex1.Coffebean;

public class Application {
    public static void main(String[] args) {
        WarehouseWithDeletion warehouse = new WarehouseWithDeletion("toedit", "here");
        //add coffe
        warehouse.addItem(new Coffebean("milk"));
        warehouse.getItems().forEachRemaining(System.out::println);

        //edit
        warehouse.editItem(new Coffebean("creamer"), 0);
        warehouse.getItems().forEachRemaining(System.out::println);
    }
}
