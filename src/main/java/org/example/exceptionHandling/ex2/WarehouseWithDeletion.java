package org.example.exceptionHandling.ex2;

import org.example.exceptionHandling.ex1.MyException;
import org.example.exceptionHandling.ex1.ValidatedWarehouse;
import org.example.oopDeepDive.ex1.BaseInventoryItem;

public class WarehouseWithDeletion extends ValidatedWarehouse {
    public WarehouseWithDeletion(String name, String location) {
        super(name, location);
    }

    public void editItem(BaseInventoryItem item, int id) {
        try{
            addValidatedItem(item);
          try{
              edit(item, id);
          }catch(Exception e){
              System.out.println(e);
          }
        }
        catch(MyException e){
            System.out.println(e);
        }
    }

    private static void edit(BaseInventoryItem item, int id) throws MyException {
        if(!_inventory.stream().anyMatch(x -> x.getId() == id))
            throw new MyException("Item does not exist");
            
        for(BaseInventoryItem toEdit: _inventory){
            if(toEdit.getId() == id){
                toEdit.setId(item.getId());
                toEdit.setName(item.getName());
            }
            
        }
    }
}
