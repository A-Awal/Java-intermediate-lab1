package org.example.oopDeepDive.ex4;

import java.util.ArrayList;
import java.util.Iterator;

public class StackStore<E> implements InventoryStore<E>{
        private ArrayList<E> stack = new ArrayList();
        public void push(E e) {
            stack.addFirst(e);
        }
        public E pop() {
            return stack.removeFirst();
        }
        public E peek() {
            return stack.getFirst();
        }
        public boolean isEmpty() {
            return stack.isEmpty();
        }
        public int size() {
            return stack.size();
        }

    @Override
    public Iterator<E> iterator() {
        return stack.iterator();
    }
}
