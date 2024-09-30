package org.example.exceptionHandling.ex4;

import org.example.exceptionHandling.ex1.MyException;
import org.example.exceptionHandling.ex1.ValidatedWarehouse;
import org.example.oopDeepDive.ex1.Coffebean;

public class Application {
    public static void main(String[] args) {
        ValidatedWarehouse warehouse = new ValidatedWarehouse("hello", "here");
        test(warehouse, new Coffebean("hello"));

    }

    public static void test(ValidatedWarehouse warehouse, Coffebean coffebean){

        try {
            warehouse.addValidatedItem(coffebean);
        }catch (MyException e){
            System.out.println("Caught myexception " + e.getMessage());
        } catch (IndexOutOfBoundsException e){
            System.out.println("Caught runtime exception "+e.getMessage());
        }

    }
}
