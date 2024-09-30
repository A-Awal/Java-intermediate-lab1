package org.example.conscurrency.ex1;

import java.util.Arrays;
import java.util.concurrent.*;


import org.example.conscurrency.ex1.ImageProcessor.MyCallable;

public class Application {
   public static void main(String[] args) {
    MyCallable callable1 = new MyCallable("hello");
    MyCallable callable2 = new MyCallable("world");

    var tasks = Arrays.asList(callable1, callable2);
    ImageProcessor ipProcessor = new ImageProcessor(tasks);
    try{

        var result = ipProcessor.process();
        result.forEach(x -> {
            try {
                System.out.println(x.get());
            } catch (InterruptedException | ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }catch(Exception e){

    }

   }
}


