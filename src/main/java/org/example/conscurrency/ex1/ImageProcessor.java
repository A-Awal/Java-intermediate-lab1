package org.example.conscurrency.ex1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class ImageProcessor {
    private final  int CORE_POOL_SIZE = 5;
    private final  int MAX_POOL_SIZE = 10;
    private final  int KEEP_ALIVE_TIME = 1000;
    private final  int QUEUE_CAPACITY = 30;

    private Collection<MyCallable> _tasks;

    public ImageProcessor(List<MyCallable> tasks) {
        _tasks = tasks;
    }

    public List<Future<String>> process() throws InterruptedException {
        ExecutorService imageExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(QUEUE_CAPACITY));

       return imageExecutor.invokeAll(_tasks);
    }

    static class MyCallable implements Callable<String> {

        private String message;

        public MyCallable(String message){
            this.message = message;

        }
        @Override
        public String call() throws Exception {
            return "\n" +message;
        }
    }
}
