package parentTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {

    WebDriver webDriver;
    protected LoginPage loginPage;

    @Before
    public void SetUp() {
        File file = new File("./src/drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = new LoginPage(webDriver);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
    protected void checkExpectedResult(String message, boolean actualResult) {
        Assert.assertEquals(message, actualResult);
    }
}
