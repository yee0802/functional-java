package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalJavaTest {
    FunctionalJava functionalJava;

    @BeforeEach
    void setUp() {
        functionalJava = new FunctionalJava();
    }

    @Test
    @DisplayName("indexOfAtSymbol: should print correct index of @ symbol in given string")
    void testIndexOfAtSymbol() {
        String[] inputData = {
                "simon.morgan@northcoders.com",
                "chris.ward@northcoders.com",
                "info@stackoverflow.com",
                "hannah.montana@mileycyrus.com",
                "testnorthcoders.com"
        };

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream sout = System.out;
        System.setOut(printStream);

        functionalJava.indexOfAtSymbol.accept(inputData);
        String[] outputStrArr = outputStream.toString().split("\n");

        System.setOut(sout);

        int[] resultArr = Arrays.stream(outputStrArr).mapToInt(Integer::parseInt).toArray();

        assertAll("Grouped Assertions for indexOfAtSymbol: ",
                () -> assertEquals(12, resultArr[0]),
                () -> assertEquals(10, resultArr[1]),
                () -> assertEquals(4, resultArr[2]),
                () -> assertEquals(14, resultArr[3]),
                () -> assertEquals(-1, resultArr[4])
                );
    }

    @Test
    @DisplayName("emailAddresses: Testing Supplier that returns a list of emails")
    void testSupplierWithListOfEmails(){
        String[] listOfEmails = {
                "simon.morgan@northcoders.com",
                "chris.ward@northcoders.com",
                "info@stackoverflow.com",
                "hannah.montanna@mileycyrus.com"
        };

        String[] resultList = functionalJava.emailAddresses.get();

        assertAll("Testing elements of the supplier one by one",
                () -> assertEquals(listOfEmails[0], resultList[0]),
                () -> assertEquals(listOfEmails[1], resultList[1]),
                () -> assertEquals(listOfEmails[2], resultList[2]),
                () -> assertEquals(listOfEmails[3], resultList[3]));
    }

    @Test
    @DisplayName("isLengthOverFive: should print correct statement if length of string is over 5")
    void testIsLengthOverFive() {
        var input1 = "hello";
        var input2 = "cat";
        var input3 = "spot";
        var input4 = "astronomical";
        var input5 = "massive";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream sout = System.out;
        System.setOut(printStream);

        functionalJava.isLengthOverFive.accept(input1);
        functionalJava.isLengthOverFive.accept(input2);
        functionalJava.isLengthOverFive.accept(input3);
        functionalJava.isLengthOverFive.accept(input4);
        functionalJava.isLengthOverFive.accept(input5);

        String[] resultArr = outputStream.toString().split("\n");

        System.setOut(sout);

        assertAll("Grouped Assertions for isLengthOverFive: ",
                () -> assertEquals(2, resultArr.length),
                () -> assertEquals("astronomical!", resultArr[0]),
                () -> assertEquals("massive!", resultArr[1])
        );
    }

    @Test
    @DisplayName("printsUsername: should print username of given email address")
    void testPrintsUsername() {
        String[] listOfEmails = {
                "simon.morgan@northcoders.com",
                "chris.ward@northcoders.com",
                "info@stackoverflow.com",
                "hannah.montanna@mileycyrus.com"
        };

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream sout = System.out;
        System.setOut(printStream);

        Arrays.stream(listOfEmails).forEach(s -> functionalJava.printsUsername.accept(s));
        String[] resultArr = outputStream.toString().split("\n");

        System.setOut(sout);

        assertAll("Grouped Assertions for printsUsername: ",
                () -> assertEquals("simon.morgan", resultArr[0]),
                () -> assertEquals("chris.ward", resultArr[1]),
                () -> assertEquals("info", resultArr[2]),
                () -> assertEquals("hannah.montanna", resultArr[3])
        );
    }

    @Test
    @DisplayName("printsAgeAndName: should print greeting with given name & age")
    void testPrintsAgeAndName() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream sout = System.out;
        System.setOut(printStream);

        functionalJava.printsAgeAndName.accept("Kye", 22);
        functionalJava.printsAgeAndName.accept("Victor", 36);
        functionalJava.printsAgeAndName.accept("John", 55);
        functionalJava.printsAgeAndName.accept("Jane", 31);
        functionalJava.printsAgeAndName.accept("Abraham", 92);
        functionalJava.printsAgeAndName.accept("George", 66);

        String[] resultArr = outputStream.toString().split("\n");

        System.setOut(sout);

        assertAll("Grouped Assertions for printsAgeAndName: ",
                () -> assertEquals("Hello Kye! Hope you are well at the age of 22!", resultArr[0]),
                () -> assertEquals("Hello Victor! Hope you are well at the age of 36!", resultArr[1]),
                () -> assertEquals("Hello John! Hope you are well at the age of 55!", resultArr[2]),
                () -> assertEquals("Hello Jane! Hope you are well at the age of 31!", resultArr[3]),
                () -> assertEquals("Hello Abraham! Hope you are well at the age of 92!", resultArr[4]),
                () -> assertEquals("Hello George! Hope you are well at the age of 66!", resultArr[5])
        );
    }

    @Test
    @DisplayName("printEmailsInList: should print each email in given list")
    void testPrintEmailsInList() {
        var emails = functionalJava.getEmailAddresses.get();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream sout = System.out;
        System.setOut(printStream);

        functionalJava.printEmailsInList.accept(emails);

        String[] resultArr = outputStream.toString().split("\n");

        System.setOut(sout);

        assertAll("Grouped Assertions for printEmailsInList: ",
                () -> assertEquals(4, emails.size()),
                () -> assertEquals("simon.morgan@northcoders.com", resultArr[0]),
                () -> assertEquals("chris.ward@northcoders.com", resultArr[1]),
                () -> assertEquals("info@stackoverflow.com", resultArr[2]),
                () -> assertEquals("hannah.montanna@mileycyrus.com", resultArr[3])
        );
    }

    @Test
    @DisplayName("squareNumbers: should square each number in given list")
    void testSquareNumbers() {
        List<Integer> numList = new ArrayList<>();
        numList.add(5);
        numList.add(8);
        numList.add(3);
        numList.add(6);
        numList.add(67);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream sout = System.out;
        System.setOut(printStream);

        functionalJava.squareNumbers.andThen(functionalJava.printNumbersInList).accept(numList);

        String[] outputStrArr = outputStream.toString().split("\n");

        System.setOut(sout);

        int[] resultArr = Arrays.stream(outputStrArr).mapToInt(Integer::parseInt).toArray();

        assertAll("Grouped Assertions for squareNumbers: ",
                () -> assertEquals(25, resultArr[0]),
                () -> assertEquals(64, resultArr[1]),
                () -> assertEquals(9, resultArr[2]),
                () -> assertEquals(36, resultArr[3]),
                () -> assertEquals(4489, resultArr[4])
        );
    }

    @Test
    @DisplayName("compareListOfIntegers: should return true or false if given List of Integers are the same")
    void testCompareListOfIntegers() {
        List<Integer> numList1 = List.of(5,8,3,6,67);
        List<Integer> numList2 = List.of(5,8,3,6,67);
        List<Integer> numList3 = List.of(3,4,42,77,123);
        List<Integer> numList4 = List.of(2,11,54,98,5433);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream sout = System.out;
        System.setOut(printStream);

        functionalJava.compareListOfIntegers.accept(numList1, numList2);
        functionalJava.compareListOfIntegers.accept(numList2, numList2);
        functionalJava.compareListOfIntegers.accept(numList2, numList3);
        functionalJava.compareListOfIntegers.accept(numList3, numList4);

        String[] resultArr = outputStream.toString().split("\n");

        System.setOut(sout);

        assertAll("Grouped Assertions for compareListOfIntegers: ",
                () -> assertTrue(Boolean.parseBoolean(resultArr[0])),
                () -> assertTrue(Boolean.parseBoolean(resultArr[1])),
                () -> assertFalse(Boolean.parseBoolean(resultArr[2])),
                () -> assertFalse(Boolean.parseBoolean(resultArr[3]))
        );
    }

    @Test
    @DisplayName("filterEmailAddresses: should filter commercial emails in given list")
    void testFilterEmailAddressesShouldReturnValidCommercialEmails() {
        var emailsList = functionalJava.emailAddressSupplier;

        var resultList = functionalJava.filterEmailAddresses.apply(emailsList, FunctionalJava.isValidCommercialEmail);

        assertAll("Grouped Assertions for filterEmailAddresses for commercial emails: ",
                () -> assertEquals(3, resultList.size()),
                () -> assertEquals("simon.morgan@northcoders.com", resultList.getFirst()),
                () -> assertEquals("chris.ward@northcoders.com", resultList.get(1)),
                () -> assertEquals("shrek@duloc.com", resultList.getLast())
                );
    }

    @Test
    @DisplayName("filterEmailAddresses: should filter British emails in given list")
    void testFilterEmailAddressesShouldReturnValidBritishEmails() {
        var emailsList = functionalJava.emailAddressSupplier;

        var resultList = functionalJava.filterEmailAddresses.apply(emailsList, FunctionalJava.isValidBritishEmail);

        assertAll("Grouped Assertions for filterEmailAddresses for British emails: ",
                () -> assertEquals(2, resultList.size()),
                () -> assertEquals("link@hyrule.co.uk", resultList.getFirst()),
                () -> assertEquals("ziggy@spidersfrommars.co.uk", resultList.getLast())
        );
    }

    @Test
    @DisplayName("filterEmailAddresses: should filter non commercial or British emails in given list")
    void testFilterEmailAddressesShouldReturnNonBritishOrCommercialEmails() {
        var emailsList = functionalJava.emailAddressSupplier;

        var resultList = functionalJava.filterEmailAddresses.apply(emailsList, Predicate.not(FunctionalJava.isValidCommercialEmail.or(FunctionalJava.isValidBritishEmail)));

        assertAll("Grouped Assertions for filterEmailAddresses for non commercial or British emails: ",
                () -> assertEquals(5, resultList.size()),
                () -> assertEquals("mario@plumbing.it", resultList.getFirst()),
                () -> assertEquals("ellie@northcoders.js", resultList.get(1)),
                () -> assertEquals("java@oracle.jvm", resultList.get(2)),
                () -> assertEquals("lemmy@motorhead.co,uk", resultList.get(3)),
                () -> assertEquals("me@myhouse.sleep", resultList.getLast())

        );
    }
}
