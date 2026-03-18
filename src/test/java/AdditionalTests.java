package tests;

import org.testng.annotations.Test;
import pages.FactorialPage;

import static org.testng.Assert.*;

public class AdditionalTests extends BaseTest {

    @Test
    public void testFactorial12() {
        FactorialPage pageObj = new FactorialPage(page);

        String result = pageObj.calculateFactorial("12");

        assertTrue(result.contains("479001600"));
    }

    @Test
    public void testValidationStyling() {
        FactorialPage pageObj = new FactorialPage(page);

        pageObj.calculateFactorial("-1");

        String borderColor = pageObj.getInputBorderColor();

        assertTrue(borderColor.contains("255")); // red color check
    }

    @Test
    public void testApiCall() {

        page.onRequest(request -> {
            if (request.url().contains("factorial")) {

                assertEquals(request.method(), "GET");

                assertTrue(request.url().contains("12"));
            }
        });

        FactorialPage pageObj = new FactorialPage(page);
        pageObj.calculateFactorial("12");
    }
}
