package org.example.conscurrency.ex3;

public class Application {
    public static void main(String[] args) {
        ConcurrentStore stoConcurrentStore = new ConcurrentStore();
        Runnable runnable = new Runnable() {
            public void run(){
                for(int i=0; i<20; i++){
                    System.out.println(Thread.currentThread().getName() + " increased it to " + stoConcurrentStore.addToSharedVar(1));
                }
            }
        };

        Thread thread_1 = new Thread(runnable, "thread_1");
        Thread thread_2 = new Thread(runnable, "thread_2");

        thread_1.start();
        thread_2.start();
    }
}
