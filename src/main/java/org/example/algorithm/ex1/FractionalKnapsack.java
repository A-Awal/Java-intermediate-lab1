package org.example.algorithm.ex1;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    
    private  Item[] items;

    public FractionalKnapsack(int[] weights, int[] values) {
        int numberOfItems = weights.length;
        items = new Item[numberOfItems];
        
        // create item array
        for (int i = 0; i < numberOfItems; i++) {
            items[i] = new Item(weights[i], values[i]);
        }
        
     // Sort items by value per weight in descending order
        Arrays.sort(items, Comparator.comparingDouble(item -> -item.valuePerWeight()));
        
    }
    
    public double solveForCapacity(int capacity) {
     
        double totalValue = 0.0;
        int currentWeight = 0;

        for (Item item : items) {
            if (currentWeight + item.weight() <= capacity) {
                currentWeight += item.weight();
                totalValue += item.value();
            } else {
                int remainingCapacity = capacity - currentWeight;
                totalValue += item.valuePerWeight() * remainingCapacity;
                break;
            }
        }

        return totalValue;
        
    }
    

    public static void main(String[] args) {
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 50;

        FractionalKnapsack napsack = new FractionalKnapsack(weights, values);
        System.out.println("Maximum value = " + napsack.solveForCapacity(capacity));
        
    }
}

