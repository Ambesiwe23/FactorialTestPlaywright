package tests;

import com.microsoft.playwright.*;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.nio.file.Paths;


public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @BeforeClass
    public void setup() {
        playwright = Playwright.create();

        browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false));

        page = browser.newPage();
        page.navigate("http://qainterview.pythonanywhere.com");
    }


    @AfterMethod
    public void captureScreenshot(ITestResult result) {

        String testName = result.getName();

        // Save screenshot with test name
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("screenshots/" + testName + ".png"))
                .setFullPage(true));
    }

    @AfterClass
    public void teardown() {
        browser.close();
        playwright.close();
    }
}