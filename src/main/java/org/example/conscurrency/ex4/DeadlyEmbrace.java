package org.example.conscurrency.ex4;

public class DeadlyEmbrace {
    private Hello hello = new Hello();
    private Hi hi = new Hi();

    public static void main(String[] args) {
    
        DeadlyEmbrace deadlyEmbrace = new DeadlyEmbrace();

        Thread thread_1 = new Thread(new Runnable() {
            public void run(){
                deadlyEmbrace.sayHello();
            }
        }, "thread_1");

        Thread thread_2 = new Thread(new Runnable() {
            public void run(){
                deadlyEmbrace.sayHi();
            }
        }, "thread_2");

        thread_2.start();
        thread_1.start();

    }

    public void sayHello(){
        synchronized(hello){
            hello.sayHello();
            sayHi();
        }
    }

    public void sayHi(){
        synchronized(hi){
            hi.respondHi();
           printSome();
        }
    }

    public void printSome(){
        synchronized(hello){
            System.out.println("x_2");
        }
    }
    
}
