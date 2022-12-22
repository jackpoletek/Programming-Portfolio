package com.array.onlineshopspring.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {

    public static boolean matchDescription(String catDescription, String prodDescription) {
        Pattern pattern = Pattern.compile(catDescription, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(prodDescription);

        return matcher.find();
    }
}
