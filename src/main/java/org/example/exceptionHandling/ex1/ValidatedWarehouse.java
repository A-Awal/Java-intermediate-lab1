package org.example.exceptionHandling.ex1;

import org.example.oopDeepDive.ex1.BaseInventoryItem;
import org.example.oopDeepDive.ex2.Warehouse;

public class ValidatedWarehouse extends Warehouse {
    public ValidatedWarehouse(String name, String location) {
        super(name, location);
    }


    public void addValidatedItem(BaseInventoryItem item) throws MyException {
        if(validateInput(item, x-> x.getName().isEmpty())){
            throw new MyException("Name is empty");
        }

        try {
             item.getName().substring(3);

        }catch ( IndexOutOfBoundsException e){
            throw e;
        }

    }




}
