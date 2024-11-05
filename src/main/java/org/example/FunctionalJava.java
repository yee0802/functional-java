package org.example;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FunctionalJava {
    public static void main(String[] args) {

    }

    public Consumer<String[]> indexOfAtSymbol = strings -> {
        Arrays.stream(strings).forEach(s -> System.out.println(s.indexOf("@")));
    };

    public Supplier<String[]> emailAddresses = () -> new String[]{
                "simon.morgan@northcoders.com",
                "chris.ward@northcoders.com",
                "info@stackoverflow.com",
                "hannah.montanna@mileycyrus.com"
        };

}
