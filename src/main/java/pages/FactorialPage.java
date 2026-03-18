package pages;

import com.microsoft.playwright.Page;

public class FactorialPage {

    private Page page;

    // Constructor
    public FactorialPage(Page page) {
        this.page = page;
    }

    // Locators
    private String inputBox = "#number";
    private String calculateBtn = "#getFactorial";
    private String resultText = "#resultDiv";

    // Actions

    // Enter number
    public void enterNumber(String number) {
        page.fill(inputBox, number);
    }

    // Click calculate button
    public void clickCalculate() {
        page.click(calculateBtn);
    }

    // Get result (with explicit wait)
    public String getResult() {
        page.waitForSelector(resultText); // explicit wait
        return page.locator(resultText).innerText();
    }

    // Combined action
    public String calculateFactorial(String number) {
        enterNumber(number);
        clickCalculate();
        return getResult();
    }

    // Get page title
    public String getPageTitle() {
        return page.title();
    }

    // Click link
    public void clickLink(String linkText) {
        page.click("text=" + linkText);
    }

    // Get input border color (for validation styling)
    public String getInputBorderColor() {
        return page.locator(inputBox)
                .evaluate("el => getComputedStyle(el).borderColor")
                .toString();
    }
}