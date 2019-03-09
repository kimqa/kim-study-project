package pages;

import libs.ActionsWithElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {

    @FindBy(xpath = ".//*[@ui-sref='authorize.index']")
    private WebElement loginButton;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openHomePage() {
        actionsWithElements.openPage("https://www.ssls.com");
    }

    public void openLoginPage() {
        actionsWithElements.clickOnElement(loginButton);
    }
}
