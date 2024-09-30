package org.example.oopDeepDive.ex5;

public class Application {
    public static void main(String[] args) {
        int capacity= 100;
        var cache = new InMemoryCache<Integer, Integer>(capacity);

        var action = new Runnable() {
            public void run(){
                for(int i=0; i< capacity; i++){
                    var value = cache.get(i);
                    if(value == null){
                        cache.put(i, i^2);
                        System.out.println(Thread.currentThread().getName() + "->" + i);;
                    }
                }

            }
        };

        Thread thread1 = new Thread(action, "T1");
        Thread thread2 = new Thread(action, "T2");

        thread1.start();
        thread2.start();
    }
    
}
