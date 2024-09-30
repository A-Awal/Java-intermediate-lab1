    package org.example.oopDeepDive.ex3;

public class Application {
    public static void main(String[] args) {
        Validator validator = new Validator.BasicValidator();
        var status = validator.isValidate(2, x -> x>=2);
        System.out.println(status);
    }
}
