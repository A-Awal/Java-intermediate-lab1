package org.example.oopDeepDive.ex6;

import org.example.oopDeepDive.ex1.BaseInventoryItem;

import java.util.Comparator;

public class InventoryComparators  {

   public static Comparator<BaseInventoryItem> compareName() {

       return  new Comparator<BaseInventoryItem>() {
           public int compare(BaseInventoryItem o1, BaseInventoryItem o2) {
               return o1.getName().compareTo(o2.getName());
           }
       };

   }

   public static Comparator<BaseInventoryItem> compareId() {
       return (o1, o2)-> o1.getId() - o2.getId();
   }
}
