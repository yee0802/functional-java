package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

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
                () -> assertEquals("Chris.ward", resultArr[1]),
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
}
