package org.example.algorithm.ex1;

public record Item(int weight, int value) {
   
    public double valuePerWeight() {
        return value / weight;
    }
}
