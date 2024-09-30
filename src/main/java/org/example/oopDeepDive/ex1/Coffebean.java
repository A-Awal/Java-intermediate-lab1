package org.example.oopDeepDive.ex1;

public class Coffebean extends BaseInventoryItem{
    public Coffebean( String name) {
        super( name);
    }

    @Override
    public String toString() {
        return String.format("{%d, %s}", getId(), getName());
    }
}
