//package com.array.onlineshopspring.validation;
//
//import org.springframework.stereotype.Service;
//
//import java.util.function.Predicate;
//
//@Service
//public class EmailValidator implements Predicate<String> {
//
//    private final String EMAIL = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";
//
//    @Override
//    public boolean test(String s) {
//        if (!s.equals(EMAIL)) {
//            return false;
//        } else return true;
//    }
//}
