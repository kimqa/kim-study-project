package libs;

import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsWithElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait wait10, wait20;
    ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    public ActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger("ActionsWithElements");
        wait10 = new WebDriverWait(webDriver,configProperties.TIME_FOR_DEFAULT_WAIT());
        wait20 = new WebDriverWait(webDriver,configProperties.TIME_FOR_EXPLICIT_WAIT_LOW());
    }

    /**
     * clear and enter text in to element
     * @param element
     * @param text
     */
    public void enterTextInToElement(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + "was input in to element");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }
    /**
     * show exception
     * @param e
     */
    public void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element" + e);
        Assert.fail("Can not work with element" + e);
    }
    /**
     * click on element and add log
     * @param element
     */
    public void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("Element was clicked");
        } catch(Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void openPage(String url) {
        try {
            webDriver.get(url);
            logger.info("page was opened");
        } catch (Exception e) {
            logger.error("page was not opened" + e);
            Assert.fail("page was not opened" + e);
        }
    }

    public String getTextFromField(WebElement field) {
        try{
            logger.info("text " + field.getText() + " was taken from field");
            return field.getText();
        } catch (Exception e) {
            printErrorAndStopTest(e);
            return null;
        }
    }

    public boolean checkCurrentUrl(String expectedURL){
        try {
            return webDriver.getCurrentUrl() == expectedURL;
        } catch (Exception e) {
            printErrorAndStopTest(e);
            return false;
        }
    }

    public void waitUntilElementIsDisplayed(WebElement element) {
        try{
            wait10.until(ExpectedConditions.visibilityOf(element));
            logger.info("Element " + element.toString() + " is visible");
        } catch (Exception e) {
            logger.error("can not work with element" + e);
        }
    }
}
