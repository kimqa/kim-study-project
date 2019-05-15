package parentTest;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.MyProfilePage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ParentTest {

    WebDriver webDriver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected MyProfilePage myProfilePage;
    Logger logger;
    String browser = System.getProperty("browser");

    @Before
    public void SetUp() {
        logger = Logger.getLogger(getClass());

        setBrowser();

//        File file = new File("./src/drivers/chromedriver");
//        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
//        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        myProfilePage = new MyProfilePage(webDriver);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
    protected void checkExpectedResult(String message, boolean actualResult) {
        Assert.assertEquals(message, actualResult);
    }


    private void setBrowser() {
        if (browser == null) {
            browser = "chrome";
        }
        if ("local-chrome".equals(browser)) {
            File fileFF = new File("./src/drivers/chromedriver");
            System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
            webDriver = new ChromeDriver();
        } else if ("chrome".equals(browser)) {
            logger.info("Remote Chrome Driver will be started");
            try {
                DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
                desiredCapabilities.setCapability("enableVNC", true);
                webDriver = new RemoteWebDriver(
                        new URL("http://selenoid.pdgamedev.com:4444/wd/hub"),
                        desiredCapabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else if ("firefox".equals(browser)) {
            logger.info("Remote Firefox Driver will be started");
            try {
                DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
                desiredCapabilities.setCapability("enableVNC", true);
                webDriver = new RemoteWebDriver(
                        new URL("http://selenoid.pdgamedev.com:4444/wd/hub"),
                        desiredCapabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else if ("opera".equals(browser)) {
            logger.info("Remote Opera Driver will be started");
            try {
                DesiredCapabilities desiredCapabilities = DesiredCapabilities.opera();
                desiredCapabilities.setCapability("enableVNC", true);
                webDriver = new RemoteWebDriver(
                        new URL("http://selenoid.pdgamedev.com:4444/wd/hub"),
                        desiredCapabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            Assert.fail("Can not open browser" + browser);
        }
    }


    protected void checkAC(String message, boolean actual, boolean expected) {
        if (!(actual == expected)) {
            logger.error("AC failed: " + message);
        }
        Assert.assertEquals(message, expected, actual);
    }
}
