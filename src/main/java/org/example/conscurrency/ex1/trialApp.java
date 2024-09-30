package org.example.conscurrency.ex1;

class Babble extends Thread {
    static boolean doYield; // yield to other threads?
    static int howOften; // how many times to print
    private String word; // my word
    Babble(String whatToSay) {
        word = whatToSay;
    }
    public void run() {
        for (int i = 0; i < howOften; i++) {
            System.out.println(word);
            file:///D|/1/0321349806/ch14lev1sec6.html (2 von 4) [11.01.2008 03:37:32]
            if (doYield)
                Thread.yield(); // let other threads run
        }
    }
    public static void main(String[] args) {
        doYield = Boolean.valueOf(args[0]);
        howOften = Integer.parseInt(args[1]);
// create a thread for each word
        for (int i = 2; i < args.length; i++)
            new Babble(args[i]).start();
    }
}
