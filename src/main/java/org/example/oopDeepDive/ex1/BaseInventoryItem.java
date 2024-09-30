package org.example.oopDeepDive.ex1;

public class BaseInventoryItem {
    private int id;
    private String  name;

    public BaseInventoryItem(String name) {
        this.id = id;
        this.name = name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}
