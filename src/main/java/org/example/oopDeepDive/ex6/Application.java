package org.example.oopDeepDive.ex6;

import org.example.oopDeepDive.ex1.Coffebean;
import org.example.oopDeepDive.ex2.Warehouse;
import org.w3c.dom.ranges.Range;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;

public class Application {
    public static void main(String[] args) {

        ArrayList<Coffebean> coffebeans = new ArrayList<>();
        for(byte i=0; i<10; i++){
           var bean = i%2==0? new Coffebean(String.format("bean%s", i)):new Coffebean(String.format("oddbean%s", i));
           bean.setId(i);
           coffebeans.add(bean);
        }

        //Shuffle to ensure randomness
        Collections.shuffle(coffebeans);
        System.out.println(coffebeans);

        //sort by name
        Collections.sort(coffebeans ,InventoryComparators.compareName());
        System.out.println(coffebeans);

        Collections.sort(coffebeans,InventoryComparators.compareId());
        
        System.out.println(coffebeans);

        //then create query api
        InventoryQueryApi<Coffebean> queryApi = new InventoryQueryApi<Coffebean>(coffebeans);

        System.out.println(queryApi.getInventoryItemByName("bean4"));
    }
}
