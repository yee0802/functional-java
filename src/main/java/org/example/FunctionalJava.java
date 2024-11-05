package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FunctionalJava {
    public static void main(String[] args) {
        FunctionalJava functionalJava = new FunctionalJava();

        // functionalJava.printEmailsInList.accept(functionalJava.getEmailAddresses.get());

        List<Integer> numList = new ArrayList<>();
        numList.add(5);
        numList.add(8);
        numList.add(3);
        numList.add(6);
        numList.add(67);

        functionalJava.squareNumbers.andThen(functionalJava.printNumbersInList).accept(numList);
    }

    public Consumer<String[]> indexOfAtSymbol = strings -> Arrays.stream(strings).forEach(s -> System.out.println(s.indexOf("@")));

    public Supplier<String[]> emailAddresses = () -> new String[]{
                "simon.morgan@northcoders.com",
                "chris.ward@northcoders.com",
                "info@stackoverflow.com",
                "hannah.montanna@mileycyrus.com"
        };

    public Consumer<String> isLengthOverFive = s -> {
        if (s.length() > 5) {
            System.out.println(s + "!");
        }
    };
    public Consumer<String> printsUsername = s -> {
        System.out.println(s.split("@")[0]);
    };

    public BiConsumer<String, Integer> printsAgeAndName  = (name, age) -> {
        System.out.println(STR."Hello \{name}! Hope you are well at the age of \{age}!");
    };

    public Supplier<List<String>> getEmailAddresses = () -> Arrays.asList(
            "simon.morgan@northcoders.com",
            "chris.ward@northcoders.com",
            "info@stackoverflow.com",
            "hannah.montanna@mileycyrus.com");

    public Consumer<List<String>> printEmailsInList = emails -> emails.forEach(System.out::println);

    public Consumer<List<Integer>> squareNumbers = nums -> nums.replaceAll(num -> num * num);

    public Consumer<List<Integer>> printNumbersInList = nums -> nums.forEach(System.out::println);
}
