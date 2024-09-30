package org.example.exceptionHandling.ex1;

import org.example.oopDeepDive.ex1.Coffebean;

public class Application {
    public static void main(String[] args) {
        ValidatedWarehouse warehouse = new ValidatedWarehouse("hello", "here");
        try{

            test(warehouse, new Coffebean(""));
        }catch (MyException e){
            System.out.println("Caught myexception " + e.getMessage());
        }

    }

    public static void test(ValidatedWarehouse warehouse, Coffebean coffebean) throws MyException{
        try {
            warehouse.addValidatedItem(coffebean);
        } catch (IndexOutOfBoundsException e){
            System.out.println("Caught runtime exception "+e.getMessage());
        }

    }
}
