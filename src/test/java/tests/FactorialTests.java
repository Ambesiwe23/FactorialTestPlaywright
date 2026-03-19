package tests;

import org.testng.annotations.Test;
import pages.FactorialPage;

import java.util.PrimitiveIterator;

import static org.testng.Assert.*;

public class FactorialTests extends BaseTest {

    @Test
    public void testValidFactorial() {
        FactorialPage factorialPage = new FactorialPage(page);

        String result = factorialPage.calculateFactorial("5");

        assertTrue(result.contains("120"));
    }

    @Test
    public void testZero() {
        FactorialPage factorialPage = new FactorialPage(page);

        String result = factorialPage.calculateFactorial("0");

        assertTrue(result.contains("1"));
    }

     @Test
   public void testLargeFactorialNumbers() {
    FactorialPage factorialPage = new FactorialPage(page);

    int[] testNumbers = {170, 171, 500, 991, 1000};

    for (int num : testNumbers) {
        String result = factorialPage.calculateFactorial(String.valueOf(num));
        System.out.println("Input: " + num + " | Output: " + result);

        if (num <= 170) {
            assertFalse(result.isEmpty(), "Result should display for " + num);
        } else if (num <= 991) {
            assertTrue(result.contains("Infinity") || result.contains("overflow"),
                    "Expected 'Infinity' or overflow for " + num);
        } else {
            assertTrue(result.isEmpty() || result.toLowerCase().contains("error"),
                    "No response expected for " + num);
        }
    }

    @Test
    public void testNegativeInput() {
        FactorialPage factorialPage = new FactorialPage(page);

        String result = factorialPage.calculateFactorial("-5");

        assertTrue(result.toLowerCase().contains("error") ||
                result.contains("non-negative"));
    }

    @Test
    public void testEmptyInput() {
        FactorialPage factorialPage = new FactorialPage(page);

        String result = factorialPage.calculateFactorial("");

        assertTrue(result.toLowerCase().contains("enter"));
    }

    @Test
    public void testNonNumeric() {
        FactorialPage factorialPage = new FactorialPage(page);

        String result = factorialPage.calculateFactorial("abc");

        assertTrue(result.toLowerCase().contains("enter"));
    }

    @Test
    public void testDecimalInput() {
        FactorialPage factorialPage = new FactorialPage(page);

        String result = factorialPage.calculateFactorial("3.5");

        assertTrue(result.toLowerCase().contains("integer"));
    }

    @Test
    public void testPageTitle() {
        FactorialPage factorialPage = new FactorialPage(page);

        assertEquals(factorialPage.getPageTitle(), "The greatest factorial calculator!");
    }

    @Test
    public void testHyperlinks() {
        FactorialPage factorialPage = new FactorialPage(page);

        String[] links = {"About","Terms and Conditions", "Privacy"};

        for (String link : links) {
            factorialPage.clickLink(link);
            assertTrue(page.url().toLowerCase().contains(link.toLowerCase()));
            page.goBack();
        }
    }
}
