package org.example.datastructures.ex2;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MinHeap<T extends Comparable<T>> {
    private int capacity;
    private int size = 0;
    private T[] heap;

    @SuppressWarnings("unchecked")
    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.heap = (T[]) new Comparable[capacity];
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private T leftChild(int parentIndex) {
        return heap[getLeftChildIndex(parentIndex)];
    }

    private T rightChild(int parentIndex) {
        return heap[getRightChildIndex(parentIndex)];
    }

    private T parent(int childIndex) {
        return heap[getParentIndex(childIndex)];
    }

    private void swap(int index1, int index2) {
        T element = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = element;
    }

    private void ensureCapacity() {
        if (size == capacity) {
            heap = Arrays.copyOf(heap, capacity * 2);
            capacity = capacity * 2;
        }
    }

    private T peek() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return heap[0];
    }

    private T poll() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        T element = heap[0];

        heap[0] = heap[size - 1];
        size--;
        heapifyDown();
        return element;
    }

    public void add(T item) {
        ensureCapacity();
        heap[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size - 1;

        while (hasParent(index) && parent(index).compareTo(heap[index]) > 0) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapifyDown() {
        int index = 0;

        while (hasLeftChild(index)) {
            int smallestChildIndex = getLeftChildIndex(index);

            if (hasRightChild(index) && rightChild(index).compareTo(leftChild(index)) < 0) {
                smallestChildIndex = getRightChildIndex(index);
            }

            if (heap[index].compareTo(heap[smallestChildIndex]) <0) {
                break;
            } else {
                swap(index, smallestChildIndex);
            }
            index = smallestChildIndex;
        }
    }

    private void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
    }
}