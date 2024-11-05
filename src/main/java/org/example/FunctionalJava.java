package org.example;

import java.util.Arrays;
import java.util.function.Consumer;

public class FunctionalJava {
    public static void main(String[] args) {

    }

    public Consumer<String[]> indexOfAtSymbol = strings -> {
        Arrays.stream(strings).forEach(s -> System.out.println(s.indexOf("@")));
    };

}
