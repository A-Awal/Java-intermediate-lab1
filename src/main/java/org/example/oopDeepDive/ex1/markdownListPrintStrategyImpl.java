package org.example.oopDeepDive.ex1;

public class markdownListPrintStrategyImpl implements printStrategy {
    @Override
    public void openParentTag() {
        System.out.println("");
    }

    @Override
    public void print(String itemName) {
        System.out.println("*" + itemName);
    }

    @Override
    public void closeParentTag() {
        System.out.println("");
    }
}
