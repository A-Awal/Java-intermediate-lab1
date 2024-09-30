package org.example.oopDeepDive.ex2;

import org.example.oopDeepDive.ex1.Coffebean;

public class Application {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse("OOP warehouse", "machupichu");

        var item1 = new Coffebean( "item1");
        var item2 = new Coffebean( "item2");

        warehouse.addItem(item1);
        warehouse.addItem(item2);
        
        var it1 = warehouse.getItemByName(item1.getName());

       var ite1AuditInfo =  warehouse.getAuditInfo(it1.getId());
        ite1AuditInfo.forEachRemaining(System.out::println);

    }
}
