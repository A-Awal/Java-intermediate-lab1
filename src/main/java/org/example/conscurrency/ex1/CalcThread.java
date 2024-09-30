package org.example.conscurrency.ex1;

class CalcThread extends Thread {
    private double result;
    public void run() {
        result = calculate();
    }
    public double getResult() {
        return result;
    }
    public double calculate() {
// ... calculate a value for "result"
        return  0;
    }
}
class ShowJoin {
    public static void main(String[] args) {
        CalcThread calc = new CalcThread();
        calc.start();
//        doSomethingElse();
        try {
            calc.join();
            System.out.println("result is "
                    + calc.getResult());
        } catch (InterruptedException e) {
            System.out.println("No answer: interrupted");
        }
    }
// ... definition of doSomethingElse ...
}