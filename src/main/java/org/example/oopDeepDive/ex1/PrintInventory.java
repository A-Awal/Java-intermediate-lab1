package org.example.oopDeepDive.ex1;

import java.util.Iterator;

public class PrintInventory {
    private Iterator<BaseInventoryItem> _inventoryIterator;
    private printStrategy printStrategy;

    public PrintInventory(Iterator<BaseInventoryItem> inventory, printStrategy printStrategy) {
        _inventoryIterator = inventory;
        this.printStrategy = printStrategy;
    }

    private void printItem(String itemName) {
        printStrategy.print(itemName);
    }

   public void print(){
        printStrategy.openParentTag();
        _inventoryIterator.forEachRemaining(item -> printItem(item.getName()));
        printStrategy.closeParentTag();
   }
}
