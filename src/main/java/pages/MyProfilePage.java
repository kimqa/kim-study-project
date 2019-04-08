package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProfilePage extends ParentPage {

    @FindBy(xpath = "//div[@class='edit-box']//input[@name='email']")
    private WebElement emailField;
    @FindBy(xpath = "//div[contains(@ng-class, 'email')]/button")
    private WebElement editEmailButton;

    public MyProfilePage(WebDriver webDriver) {
        super(webDriver);

    }

    public boolean checkEmail(String email) {
        try{
            return email.contains(actionsWithElements.getTextFromField(emailField));
        }catch (Exception e) {
            actionsWithElements.printErrorAndStopTest(e);
            return false;
        }
    }

    public void clickEditEmail() {
        actionsWithElements.clickOnElement(editEmailButton);
    }
}
