package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class FunctionalJava {
    public static void main(String[] args) {
        FunctionalJava functionalJava = new FunctionalJava();

        /* functionalJava.printEmailsInList.accept(functionalJava.getEmailAddresses.get());

        List<Integer> numList = new ArrayList<>();
        numList.add(5);
        numList.add(8);
        numList.add(3);
        numList.add(6);
        numList.add(67);

        functionalJava.squareNumbers.andThen(functionalJava.printNumbersInList).accept(numList);
        */

        var filteredEmails1 = functionalJava.filterEmailAddresses.apply(functionalJava.emailAddressSupplier, isValidCommercialEmail);
        System.out.println(filteredEmails1);

        var filteredEmails2 = functionalJava.filterEmailAddresses.apply(functionalJava.emailAddressSupplier, isValidBritishEmail);
        System.out.println(filteredEmails2);

        var filteredEmails3 = functionalJava.filterEmailAddresses.apply(functionalJava.emailAddressSupplier, Predicate.not(isValidCommercialEmail.or(isValidBritishEmail)));
        System.out.println(filteredEmails3);
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

    public BiConsumer<List<Integer>, List<Integer>> compareListOfIntegers = (nums1, nums2) -> {
            System.out.println(nums1.equals(nums2));
    };

    public Supplier<List<String>> emailAddressSupplier = () -> Arrays.asList(
            "simon.morgan@northcoders.com",
            "chris.ward@northcoders.com",
            "mario@plumbing.it",
            "link@hyrule.co.uk",
            "shrek@duloc.com",
            "ellie@northcoders.js",
            "java@oracle.jvm",
            "ziggy@spidersfrommars.co.uk",
            "lemmy@motorhead.co,uk",
            "me@myhouse.sleep"
            );

    public static Predicate<String> isValidCommercialEmail = s -> s.endsWith(".com");

    public static Predicate<String> isValidBritishEmail = s -> s.endsWith(".co.uk");

    public BiFunction<Supplier<List<String>>, Predicate<String>, List<String>> filterEmailAddresses = (listSupplier, stringPredicate) -> {
        List<String> filteredEmails = listSupplier.get().stream().filter(stringPredicate).toList();

        return filteredEmails;
    };
}
