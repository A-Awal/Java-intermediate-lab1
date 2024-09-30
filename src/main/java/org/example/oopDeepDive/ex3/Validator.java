package org.example.oopDeepDive.ex3;

import java.util.function.Predicate;

public interface Validator {
   <T>  boolean isValidate(T input, Predicate<T> validate);

   class BasicValidator implements Validator {
       @Override
       public <T> boolean isValidate(T input, Predicate<T> validate) {
           return validate.test(input);
       }
   }
}
