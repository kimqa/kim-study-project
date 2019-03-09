package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
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
}
