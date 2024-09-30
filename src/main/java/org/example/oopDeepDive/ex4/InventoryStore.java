package org.example.oopDeepDive.ex4;

import java.util.ArrayList;

public interface InventoryStore<E> extends Iterable<E> {
    public void push(E e);
    public E pop();
    public E peek() ;
    public boolean isEmpty();
    public int size();
}
