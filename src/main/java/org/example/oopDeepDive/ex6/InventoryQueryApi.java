package org.example.oopDeepDive.ex6;

import org.example.oopDeepDive.ex1.BaseInventoryItem;


import java.util.Collection;
import java.util.List;

public class InventoryQueryApi<T extends BaseInventoryItem> {
    private final Collection<T> _warehouse;
    public InventoryQueryApi(Collection<T> warehouse) {
        _warehouse = warehouse;
    }

    public List<T> getInventoryItemByName(String name) {
       return _warehouse.stream().filter(x -> x.getName().toLowerCase().contains(name)).toList();
    }
}
