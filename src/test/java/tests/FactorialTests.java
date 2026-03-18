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

        assertEquals(factorialPage.getPageTitle(), "Factorial Calculator");
    }

    @Test
    public void testHyperlinks() {
        FactorialPage factorialPage = new FactorialPage(page);

        String[] links = {"About", "Help", "Contact"};

        for (String link : links) {
            factorialPage.clickLink(link);
            assertTrue(page.url().toLowerCase().contains(link.toLowerCase()));
            page.goBack();
        }
    }
}
