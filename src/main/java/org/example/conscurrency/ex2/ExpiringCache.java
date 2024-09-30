package org.example.conscurrency.ex2;

import java.util.concurrent.*;
import java.util.function.Function;

public class ExpiringCache<K, V> {
    private final ConcurrentMap<K, V> cache = new ConcurrentHashMap<>();
    private final ConcurrentMap<K, Long> timestamps = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final long expirationDuration;
    private final TimeUnit timeUnit;

    public ExpiringCache(long expirationDuration, TimeUnit timeUnit) {
        this.expirationDuration = expirationDuration;
        this.timeUnit = timeUnit;
        scheduler.scheduleAtFixedRate(this::removeExpiredEntries, expirationDuration, expirationDuration, timeUnit);
    }

    public V get(K key) {
        return cache.get(key);
    }

    public V put(K key, V value) {
        timestamps.put(key, System.nanoTime());
        return cache.put(key, value);
    }

    public V putIfAbsent(K key, V value) {
        timestamps.putIfAbsent(key, System.nanoTime());
        return cache.putIfAbsent(key, value);
    }

    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        timestamps.putIfAbsent(key, System.nanoTime());
        return cache.computeIfAbsent(key, k -> {
            V value = mappingFunction.apply(k);
            timestamps.put(k, System.nanoTime());
            return value;
        });
    }

    public boolean remove(K key, V value) {
        timestamps.remove(key);
        return cache.remove(key, value);
    }

    private void removeExpiredEntries() {
        long expirationThreshold = System.nanoTime() - timeUnit.toNanos(expirationDuration);
        for (K key : timestamps.keySet()) {
            if (timestamps.get(key) < expirationThreshold) {
                timestamps.remove(key);
                cache.remove(key);
            }
        }
    }

    public void shutdown() {
        scheduler.shutdown();
    }
}


