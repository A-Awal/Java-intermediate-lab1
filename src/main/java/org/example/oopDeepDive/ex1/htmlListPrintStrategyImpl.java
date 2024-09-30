package org.example.oopDeepDive.ex1;

public class htmlListPrintStrategyImpl implements printStrategy {

    @Override
    public void openParentTag() {
        System.out.println("<ul>");
    }

    @Override
    public void print(String itemName) {
        System.out.println("<li>" + itemName + "</li>\n");
    }

    @Override
    public void closeParentTag() {
        System.out.println("</ul>");
    }
}
