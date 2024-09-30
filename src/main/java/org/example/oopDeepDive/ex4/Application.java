package org.example.oopDeepDive.ex4;

import org.example.oopDeepDive.ConsoleColors;
import org.example.oopDeepDive.ex1.Coffebean;

public class Application {
    public static void main(String[] args) {
        //Create Stack
        InventoryStore<Coffebean> store = new StackStore<Coffebean>();

        //Add to stack
        store.push(new Coffebean("butu1"));
        store.push(new Coffebean("butu2"));
        store.push(new Coffebean("butu3"));

        System.out.println(ConsoleColors.RED + store.peek().getName()+ ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLACK_BOLD + store.pop().getName() + ConsoleColors.RESET);

    }
}
