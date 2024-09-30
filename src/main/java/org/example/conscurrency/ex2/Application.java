package org.example.conscurrency.ex2;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        ExpiringCache<String, String> cache = new ExpiringCache<>(1, TimeUnit.SECONDS);

        // Create a scheduled executor service to run tasks in separate threads
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        // Task 1: Put values into the cache
        Runnable putTask = () -> {
            cache.put("key1", "value1");
            cache.put("key2", "value2");
            System.out.println("Put values into the cache");
        };

        // Task 2: Retrieve and print values from the cache
        Runnable getTask = () -> {
            try {
                // Wait for a short time to ensure the putTask has run
                Thread.sleep(500);
                System.out.println("key1: " + cache.get("key1")); // Should print "value1"
                System.out.println("key2: " + cache.get("key2")); // Should print "value2"

                // Wait for more than the expiration duration
                Thread.sleep(1500);

                // Try to retrieve the values again
                System.out.println("key1: " + cache.get("key1")); // Should print "null"
                System.out.println("key2: " + cache.get("key2")); // Should print "null"
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // Schedule the tasks
        executorService.execute(putTask);
        executorService.execute(getTask);

        // Shutdown the executor service after tasks are complete
        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.SECONDS);

        // Shutdown the cache's scheduler
        cache.shutdown();
    }
}
