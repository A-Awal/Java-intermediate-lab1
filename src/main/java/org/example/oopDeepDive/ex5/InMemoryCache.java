package org.example.oopDeepDive.ex5;

import java.util.concurrent.ConcurrentHashMap;

public class InMemoryCache<K, V> {

    private final ConcurrentHashMap<K, V> cache;
    private final long maxCapacity; // Optional: Set a maximum number of entries

    public InMemoryCache() {
        this.cache = new ConcurrentHashMap<>( );
        this.maxCapacity = -1; // Default: No limit
    }

    public InMemoryCache(long maxCapacity) {
        this.cache = new ConcurrentHashMap<>();
        this.maxCapacity = maxCapacity;
    }

    public V get(K key) {
        return cache.get(key);
    }

    public V put(K key, V value) {
        if (maxCapacity > 0 && cache.size() >= maxCapacity) {
            return null;
        }
        return cache.put(key, value);
    }

    public V putIfAbsent(K key, V value) {
        return cache.putIfAbsent(key, value);
    }

    public boolean replace(K key, V oldValue, V newValue) {
        return cache.replace(key, oldValue, newValue);
    }


    public V remove(K key) {
        return cache.remove(key);
    }

    public boolean containsKey(K key) {
        return cache.containsKey(key);
    }

    public void clear() {
        cache.clear();
    }
}

