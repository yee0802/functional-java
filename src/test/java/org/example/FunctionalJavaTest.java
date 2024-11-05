package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class FunctionalJavaTest {
    FunctionalJava functionalJava;

    @BeforeEach
    void setUp() {
        functionalJava = new FunctionalJava();
    }

    @Test
    @DisplayName("indexOfAtSymbol: should return correct index of @ symbol in given string")
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
        PrintStream oldOut = System.out;
        System.setOut(printStream);

        functionalJava.indexOfAtSymbol.accept(inputData);

        String[] outputStrArr = outputStream.toString().split("\n");

        System.setOut(oldOut);

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
    @DisplayName("Testing Supplier that returns a list of emails")
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
}
